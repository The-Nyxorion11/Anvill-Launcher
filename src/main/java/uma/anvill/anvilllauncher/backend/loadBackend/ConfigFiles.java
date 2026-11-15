package uma.anvill.anvilllauncher.backend.loadBackend;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigFiles {

    //get .minecraft path
    public static Path getMinecraftPath() {
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
}
