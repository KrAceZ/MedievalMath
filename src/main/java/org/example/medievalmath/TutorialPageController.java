package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.util.Objects;

public class TutorialPageController
{
    @FXML
    private WebView videoWebView;
    @FXML
    private StackPane webViewContainer;

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private AnchorPane buttonsContainer;
    static String videoUrl;

    private TutorialPage tutorialPage;

    private static TutorialPageController instance;

    public TutorialPageController() {
        if (instance == null) {
            instance = this;
        }
    }

    public static void setVideoUrl(String url)
    {
        videoUrl = url;
    }

    public void initialize() {
        // Initialize the tutorial page with default background image
        Image defaultBackground = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Background.png")));
        tutorialPage = new TutorialPage(defaultBackground, videoUrl);

        // Set the background image
        backgroundImageView.setImage(defaultBackground);

        // Assign videoWebView and add it to the layout
        videoWebView = tutorialPage.getVideoWebView();
        webViewContainer.getChildren().add(videoWebView);
    }

    private void destroyWebView() {
        videoWebView.getEngine().load(null);
        webViewContainer.getChildren().remove(videoWebView);
        videoWebView = null;
    }

    // Method to handle button clicks
    @FXML
    private void navigateToHomePage() {
        try {
            // stop video when leaving page
            destroyWebView();
            // Load the profile page
            Parent homePage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home_page.fxml")));            instance = null;
            // Get the current scene and set the new root
            Scene scene = buttonsContainer.getScene();
            scene.setRoot(homePage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
