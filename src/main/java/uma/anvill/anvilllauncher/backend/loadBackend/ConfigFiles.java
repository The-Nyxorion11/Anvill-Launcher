package uma.anvill.anvilllauncher.backend.loadBackend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

public class ConfigFiles {

    public Path getMinecraftPath() {
        String os = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
        String userHome = System.getProperty("user.home");

        if (os.contains("win")) {
            String appData = System.getenv("APPDATA");
            if (appData != null && !appData.isBlank()) {
                return Path.of(appData, ".minecraft");
            }
            return Path.of(userHome, "AppData", "Roaming", ".minecraft");
        } else if (os.contains("mac")) {
            return Path.of(userHome, "Library", "Application Support", "minecraft");
        } else {
            return Path.of(userHome, ".minecraft");
        }
    }

    public void setFiles() throws IOException {
        Path basePath = getMinecraftPath();

        List<Path> directories = List.of(
                basePath.resolve("versions"),
                basePath.resolve("libraries"),
                basePath.resolve("assets").resolve("indexes"),
                basePath.resolve("assets").resolve("objects"),
                basePath.resolve("mods")
        );

        for (Path dir : directories) {
            Files.createDirectories(dir);
        }

        System.out.println("Directorios verificados en: " + basePath);
    }
}
