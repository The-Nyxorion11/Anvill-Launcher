package uma.anvill.anvilllauncher;

import io.javalin.Javalin;
import javafx.application.Application;
import uma.anvill.anvilllauncher.backend.backendTest.testingApi;

public class Launcher {
    public static void main(String[] args) {
        //Application.launch();
        //MainBackend.startMainBackend();

        //test localHost electron
        Javalin app = Javalin.create().start(7070);

        app.post("/api/suma", ctx -> {
             testingApi test = ctx.bodyAsClass(testingApi.class);
            ctx.status(201).result(String.valueOf(test.n1 + test.n2));});


    }
}
