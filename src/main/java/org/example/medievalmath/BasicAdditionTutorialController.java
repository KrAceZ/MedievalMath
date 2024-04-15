package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

public class BasicAdditionTutorialController
{
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
        basicAdditionTut = new TutorialPage(defaultBackground, "https://www.youtube.com/watch?v=AuX7nPBqDts");

        // Set the background image
        backgroundImageView.setImage(defaultBackground);

        // Add videoWebView to the layout
        buttonsContainer.getChildren().add(basicAdditionTut.getVideoWebView());
    }

    // Method to handle button clicks
    @FXML
    private void handleButtonClick() {
        // Implement button click logic here
    }
}