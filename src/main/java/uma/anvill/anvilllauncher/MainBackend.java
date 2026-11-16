package uma.anvill.anvilllauncher;

import uma.anvill.anvilllauncher.backend.loadBackend.StartConfig;
import uma.anvill.anvilllauncher.backend.backendTest.mainTest;

import java.util.Scanner;

public class MainBackend {
    //start config
    public static void startMainBackend(){

        StartConfig startConfig = new StartConfig();
        startConfig.onEnable();

    }

    public static void backendAppTest(){
        boolean exit = false;

        while (true){
            Scanner scanner = new Scanner(System.in);

            String command = scanner.nextLine();

            switch (command){
                case "exit":
                    exit = true;
                    break;
                case "-i version":
                    mainTest.testInstallVersion();
                    break;
                default:
                    System.out.printf("error");
            }

            if (exit){
                break;
            }
        }
    }


}
