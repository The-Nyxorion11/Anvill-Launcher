package uma.anvill.anvilllauncher.backend.loadBackend;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MojangService {

    private static final String MANIFEST_URL = "https://piston-meta.mojang.com/mc/game/version_manifest_v2.json";
    private final HttpClient httpClient;
    private final Gson gson;
    private final Path manifestCachePath;

    public MojangService() {
        this.httpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        this.gson = new Gson();

        // get .minecraft for json
        ConfigFiles configFiles = new ConfigFiles();
        this.manifestCachePath = configFiles.getMinecraftPath().resolve("versions").resolve("version_manifest_v2.json");
    }


    public VersionManifestModel getVersionManifest() {
        String jsonContent = null;

        try {
            // Downolad
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(MANIFEST_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                jsonContent = response.body();

                // If the download was successful, we save/update the local file
                Files.createDirectories(manifestCachePath.getParent());
                Files.writeString(manifestCachePath, jsonContent, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Master manifest downloaded and cached.");
            } else {
                System.err.println("Error HTTP al actualizar manifiesto: " + response.statusCode());
            }

        } catch (Exception e) {
            // If there is no internet or the network fails, we don’t break the launcher: we attempt to use the local file
            System.err.println("No internet connection. Attempting to load manifest from local cache...");
            jsonContent = loadManifestFromCache();
        }

        // If it wasn't downloaded and there is no local cache, we return null.
        if (jsonContent == null) {
            return null;
        }

        // We deserialize the JSON (whether just downloaded or read from the cache) using Gson
        return gson.fromJson(jsonContent, VersionManifestModel.class);
    }

    // Auxiliary method for reading the local file if the user does not have internet access
    private String loadManifestFromCache() {
        try {
            if (Files.exists(manifestCachePath)) {
                System.out.println("Loading manifest from: " + manifestCachePath);
                return Files.readString(manifestCachePath);
            }
        } catch (IOException e) {
            System.err.println("Could not read the local manifest cache: " + e.getMessage());
        }
        return null;
    }
}
