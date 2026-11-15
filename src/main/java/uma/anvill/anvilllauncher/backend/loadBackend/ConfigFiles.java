package uma.anvill.anvilllauncher.backend.loadBackend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigFiles {

    //get .minecraft path
    public Path getMinecraftPath() {
        String os = System.getProperty("os.name").toLowerCase();
        String userHome = System.getProperty("user.home");
        //windows
        if (os.contains("win")) {

            String appData = System.getenv("APPDATA");
            if (appData != null) {
                return Paths.get(appData, ".minecraft");
            }
            return Paths.get(userHome, "AppData", "Roaming", ".minecraft");

        }
        //mac
        else if (os.contains("mac")) {

            return Paths.get(userHome, "Library", "Application Support", "minecraft");
        }
        //others (linux)
        else {
            return Paths.get(userHome, ".minecraft");
        }
    }
    //create .minecraft folder
    public void setFiles(){
        Path path = getMinecraftPath();

        try {


            Files.createDirectories(path.resolve("versions"));
            Files.createDirectories(path.resolve("libraries"));

            Files.createDirectories(path.resolve("assets/indexes"));
            Files.createDirectories(path.resolve("assets/objects"));


            Files.createDirectories(path.resolve("mods"));

            System.out.println("Ok: " + path);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
