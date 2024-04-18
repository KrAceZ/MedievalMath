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

public class TutorialPageController
{
    @FXML
    private WebView videoWebView;

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private StackPane buttonsContainer;

    private TutorialPage tutorialPage;

    public void initialize() {
        // Initialize the tutorial page with default background image
        Image defaultBackground = new Image(getClass().getResourceAsStream("Background.png"));
        tutorialPage = new TutorialPage(defaultBackground, "https://www.youtube.com/watch?v=AuX7nPBqDts");

        // Set the background image
        backgroundImageView.setImage(defaultBackground);

        // Add videoWebView to the layout
        buttonsContainer.getChildren().add(tutorialPage.getVideoWebView());
    }

    // Method to handle button clicks
    @FXML
    private void navigateToHomePage() {
        try {
            // Load the profile page
            Parent homePage = FXMLLoader.load(getClass().getResource("home_page.fxml"));

            // Get the current scene and set the new root
            Scene scene = buttonsContainer.getScene();
            scene.setRoot(homePage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
