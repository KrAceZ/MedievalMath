package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class HomePageController {
    @FXML
    private ImageView backgroundImageView;

    @FXML
    private VBox buttonsContainer;

    private Page homePage;

    public void initialize() {
        // Initialize the home page with background image
        Image backgroundImage = new Image(getClass().getResourceAsStream("Background.png"));
        homePage = new Page(backgroundImage);

        // Set the background image
        backgroundImageView.setImage(backgroundImage);
    }

    // Method to navigate to Levels page
    @FXML
    private void navigateToLevelsPage() {
        // Implement navigation logic to Levels page
    }

    // Method to navigate to Profile page
    @FXML
    private void navigateToProfilePage() {
        // Implement navigation logic to Profile page
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
