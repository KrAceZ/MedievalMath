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
        //stage.setScene(scene);
        //stage.show();
        //Parent root = FXMLLoader.load(MainApplication.class.getResource("basic_addition_tutorial.fxml"));
        //primaryStage.setTitle("Basic Addition Tutorial");

        //Parent root = FXMLLoader.load(MainApplication.class.getResource("basic_add_subtract_test.fxml"));
        //primaryStage.setTitle("Basic Add Subtract Test");

        //Parent root = FXMLLoader.load(MainApplication.class.getResource("tutorial_page.fxml"));
        //primaryStage.setTitle("Tutorial Page");

        // Sirjana: Adding Shop
        //Parent shop = FXMLLoader.load(MainApplication.class.getResource("ShopItem.fxml"));
        //primaryStage.setTitle("SHOP");
        //primaryStage.setScene(new Scene(shop, 1123, 794));
        //primaryStage.show();

        // Load the main page.fxml file
        //Parent root = FXMLLoader.load(MainApplication.class.getResource("home_page.fxml"));
        //primaryStage.setTitle("Home Page");

        //Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("basic_counting_quiz.fxml")));
        //primaryStage.setTitle("Basic Counting Quiz");
        // LoginController tester
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("login.fxml")));
        primaryStage.setTitle("Login Page");

        //Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("achievements_page.fxml")));
        //primaryStage.setTitle("Achievements Page");

        primaryStage.setScene(new Scene(root, 1123, 794));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}