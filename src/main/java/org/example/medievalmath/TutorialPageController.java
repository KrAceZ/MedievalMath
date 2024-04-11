package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

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
        tutorialPage = new TutorialPage(defaultBackground);

        // Set the background image
        backgroundImageView.setImage(defaultBackground);

        // Add videoWebView to the layout
        buttonsContainer.getChildren().add(tutorialPage.getVideoWebView());
    }

    // Method to handle button clicks
    @FXML
    private void handleButtonClick() {
        // Implement button click logic here
    }
}
