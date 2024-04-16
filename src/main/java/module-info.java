module org.example.medievalmath {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.desktop;


    opens org.example.medievalmath to javafx.fxml;
    exports org.example.medievalmath;
}