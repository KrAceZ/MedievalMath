package org.example.medievalmath;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 1123, 794);
        // stage.setTitle("Hello!");
        //stage.setScene(scene);
        //stage.show();
        // Load the main page.fxml file
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("quiz_page.fxml"));
        primaryStage.setTitle("Quiz Page");
        //Parent root = FXMLLoader.load(HelloApplication.class.getResource("basic_addition_tutorial.fxml"));
        //primaryStage.setTitle("Basic Addition Tutorial");

        //Parent root = FXMLLoader.load(HelloApplication.class.getResource("basic_add_subtract_test.fxml"));
        //primaryStage.setTitle("Basic Add Subtract Test");

        //Parent root = FXMLLoader.load(HelloApplication.class.getResource("tutorial_page.fxml"));
        //primaryStage.setTitle("Tutorial Page");
        primaryStage.setScene(new Scene(root, 1123, 794));
        primaryStage.show();
        primaryStage.setResizable(false);

        // Sirjana: Adding Shop
        //Parent shop = FXMLLoader.load(HelloApplication.class.getResource("ShopItem.fxml"));
        //primaryStage.setTitle("SHOP");
        //primaryStage.setScene(new Scene(shop, 1123, 794));
        //primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}