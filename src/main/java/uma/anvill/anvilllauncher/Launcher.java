package uma.anvill.anvilllauncher;

import io.javalin.Javalin;
import uma.anvill.anvilllauncher.backend.backendTest.testingApi;

import java.util.Map;


public class Launcher {
    public static void main(String[] args) {
        //Application.launch();
        //MainBackend.startMainBackend();

        //test localHost electron
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(it -> it.anyHost());
            });
        }).start(7070);

        app.post("/api/suma", ctx -> {
            testingApi test = ctx.bodyAsClass(testingApi.class);
            int resultado = test.n1 + test.n2;


            ctx.status(201).json(Map.of("resultado", resultado));
        });

    }
}
