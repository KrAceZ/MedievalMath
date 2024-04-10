package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HomePageController {
    @FXML
    private ImageView backgroundImageView;

    @FXML
    private AnchorPane buttonsContainer;

    public void initialize() {
        // Initialize the home page with background image
        Image homeBackgroundImage = new Image(getClass().getResourceAsStream("HomeBackground.png"));
        Page homePage = new Page(homeBackgroundImage);

        // Set the background image
        backgroundImageView.setImage(homeBackgroundImage);
    }

    // get background Image for HelloApplication to set window size based on background image
    public Image getBackgroundImage() {
        return backgroundImageView.getImage();
    }


    // Method to navigate to Levels page
    @FXML
    private void navigateToLevelsPage() {
        // Implement navigation logic to Levels page
    }

    // Method to navigate to Profile page
    @FXML
    private void navigateToProfilePage() {
        try {
            // Load the profile page
            Parent profilePage = FXMLLoader.load(getClass().getResource("profile_page.fxml"));

            // Get the current scene and set the new root
            Scene scene = buttonsContainer.getScene();
            scene.setRoot(profilePage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to navigate to Quizzes page
    @FXML
    private void navigateToQuizzesPage() {
        // Implement navigation logic to Quizzes page
    }

    // Method to navigate to Shop page
    @FXML
    private void navigateToShopPage() {
        // Implement navigation logic to Shop page
    }

    // Method to navigate to Trophies page
    @FXML
    private void navigateToTrophiesPage() {
        // Implement navigation logic to Trophies page
    }
}
