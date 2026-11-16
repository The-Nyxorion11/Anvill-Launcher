module uma.anvill.anvilllauncher {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.net.http;
    requires com.google.gson;
    requires io.javalin;

    opens uma.anvill.anvilllauncher.backend.loadBackend to com.google.gson;
    opens uma.anvill.anvilllauncher to javafx.fxml;

    exports uma.anvill.anvilllauncher;
}