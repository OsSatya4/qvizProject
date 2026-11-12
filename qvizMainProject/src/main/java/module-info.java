module org.nye.qvizmainproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens org.nye.qvizmainproject to javafx.fxml;
    exports org.nye.qvizmainproject;
}