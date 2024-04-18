package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

import java.io.IOException;

public class BasicSubtractionTutorialController {

    @FXML
    private WebView videoWebView;

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private StackPane buttonsContainer;

    private TutorialPage basicAdditionTut;

    public void initialize() {
        // Initialize the tutorial page with default background image
        Image defaultBackground = new Image(getClass().getResourceAsStream("Background.png"));
        basicAdditionTut = new TutorialPage(defaultBackground, "https://www.youtube.com/embed/aNqG4ChKShI");

        // Set the background image
        backgroundImageView.setImage(defaultBackground);

        // Add videoWebView to the layout
        buttonsContainer.getChildren().add(basicAdditionTut.getVideoWebView());
    }

    // Method to handle button clicks
    @FXML
    private void navigateToHomePage() {
        try {
            // Load the home page
            Parent homePage = FXMLLoader.load(getClass().getResource("home_page.fxml"));

            // Get the current scene and set the new root
            Scene scene = buttonsContainer.getScene();
            scene.setRoot(homePage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

