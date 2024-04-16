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
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //stage.setTitle("Hello!");
        //stage.setScene(scene);
        //stage.show();
        // Load the main page.fxml file
        //Parent root = FXMLLoader.load(HelloApplication.class.getResource("home_page.fxml"));
        //primaryStage.setTitle("Home Page");
        //Parent root = FXMLLoader.load(HelloApplication.class.getResource("basic_addition_tutorial.fxml"));
        //primaryStage.setTitle("Basic Addition Tutorial");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("basic_subtraction_quiz.fxml"));
        primaryStage.setTitle("Basic Subtraction Quiz");
        //Parent root = FXMLLoader.load(HelloApplication.class.getResource("tutorial_page.fxml"));
        //primaryStage.setTitle("Tutorial Page");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}