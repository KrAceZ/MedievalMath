package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class QuizPageController {
    @FXML
    private AnchorPane mainContainer;  // Main container for all content
    @FXML
    private StackPane quizContainer;
    @FXML
    private ImageView backgroundImageView;  // View for the background image directly linked with FXML
    @FXML
    private AnchorPane buttonsContainer;
    private static String quizFXML; //the default quiz
    private static QuizPageController instance;

    public QuizPageController() {
        if (instance == null) {
            instance = this;
        }
    }


    public static QuizPageController getInstance() {
        return instance;
    }

    public static void setQuizFXML(String fxmlPath)
    {
        quizFXML = fxmlPath;
    }
    @FXML
    public void initialize() {
        Image backgroundImage = new Image(getClass().getResourceAsStream("Background.png"));
        QuizPage quizpage = new QuizPage(backgroundImage, quizFXML);

        // Ensure the path is correct; it should be relative to the classpath root
        if (backgroundImageView != null) {
            backgroundImageView.setImage(new Image(getClass().getResourceAsStream("Background.png")));
            backgroundImageView.setFitWidth(1123);  // Adjust to match the size of your mainContainer
            backgroundImageView.setFitHeight(794);
            backgroundImageView.setPreserveRatio(true);
            backgroundImageView.toBack();  // Ensure the background image is behind all other content
        }
        loadContent();  // Load initial quiz content
    }

    // Method to load content dynamically into the quizContainer above the background
    public void loadContent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(quizFXML));
            AnchorPane newContent = loader.load();
            quizContainer.getChildren().clear();  // Clear existing content in the quizContainer
            quizContainer.getChildren().add(newContent);  // Add new content to quizContainer
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading FXML: " + "quiz.fxml");
        }
    }

    @FXML
    private void navigateToHomePage() {
        try {
            // Load the profile page
            Parent homePage = FXMLLoader.load(getClass().getResource("home_page.fxml"));
            instance = null;
            // Get the current scene and set the new root
            Scene scene = buttonsContainer.getScene();
            scene.setRoot(homePage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}