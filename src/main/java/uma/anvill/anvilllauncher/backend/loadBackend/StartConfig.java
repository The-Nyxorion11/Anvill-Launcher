package uma.anvill.anvilllauncher.backend.loadBackend;


import java.io.IOException;

public class StartConfig {
    public void onEnable()  {
        //configure .minecraft
        ConfigFiles configFiles = new ConfigFiles();
        try {
            configFiles.setFiles();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


        //get version manifest
        MojangService mojangService = new MojangService();
        mojangService.getVersionManifest();
    }
}
