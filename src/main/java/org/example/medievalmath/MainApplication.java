package org.example.medievalmath;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("login.fxml")));
        primaryStage.setTitle("Login Page");

        primaryStage.setScene(new Scene(root, 1123, 794));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}
