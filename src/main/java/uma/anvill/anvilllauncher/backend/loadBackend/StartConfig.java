package uma.anvill.anvilllauncher.backend.loadBackend;

public class StartConfig {
    public void onEnable(){
        //configure .minecraft
        ConfigFiles configFiles = new ConfigFiles();
        configFiles.setFiles();

        //get version manifest
        MojangService mojangService = new MojangService();
        mojangService.getVersionManifest();
    }
}
