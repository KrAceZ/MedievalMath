package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
public class ProfilePageController {
    @FXML
    private ImageView ProfilePageBackgroundView;

    @FXML
    private AnchorPane buttonsContainer;

    @FXML
    private AnchorPane profilePageContainer;

    public void initialize() {
        // Initialize buttons or any other UI components here
        Image ProfilePageBackgroundImage = new Image(getClass().getResourceAsStream("ProfilePageBackground.png"));
        Page ProfilePage = new Page(ProfilePageBackgroundImage);

        // Set the background image
        ProfilePageBackgroundView.setImage(ProfilePageBackgroundImage);
    }

    // Buttons corresponding to the text locations in the image
    @FXML
    private Button levelsButton;
    @FXML
    private Button workScrollsButton;
    @FXML
    private Button questsButton;
    @FXML
    private Button trophiesButton;
    @FXML
    private Button shopButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button logOutButton;


    // Add methods to handle button actions if necessary
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