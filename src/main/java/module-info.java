module org.example.medievalmath {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.medievalmath to javafx.fxml;
    exports org.example.medievalmath;
}