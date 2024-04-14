module com.example.appdbconnect {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires software.amazon.awssdk.services.secretsmanager;
    requires software.amazon.awssdk.regions;
    requires software.amazon.awssdk.auth;


    opens com.example.appdbconnect to javafx.fxml;
    exports com.example.appdbconnect;
}