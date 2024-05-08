package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProfilePageController {
    public static Map<Integer, ImageView> achievementImages = new HashMap<>();
    @FXML
    private ImageView backgroundImageView;

    @FXML
    private AnchorPane buttonsContainer;

    @FXML
    private AnchorPane profilePageContainer;
    @FXML
    private ImageView royalSumScribeButton;

    @FXML
    private ImageView multiplicationMysticButton;

    @FXML
    private ImageView subtractionSorcererButton;

    @FXML
    private ImageView divisionDragonSlayerButton;
    @FXML
    private ImageView countingButton;
    @FXML
    private ImageView fractionForgingButton;
    @FXML
    private ImageView fractionFellowshipButton;
    @FXML
    private ImageView placeValuePauperButton;
    @FXML
    private ImageView placeValuePrinceButton;
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
    @FXML
    private Label username;
    @FXML
    private Label grade;
    @FXML
    private Label points;



    public void initialize() {
        // Initialize buttons or any other UI components here
        Image defaultBackground = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Background.png")));        Page ProfilePage = new Page(defaultBackground);

        // Set the background image
        backgroundImageView.setImage(defaultBackground);
        username.setText(Profile.username);
        grade.setText("Grade: "+ Profile.grade);
        points.setText("Points: "+ Profile.points);

        achievementImages.put(1,royalSumScribeButton);
        achievementImages.put(2,subtractionSorcererButton);
        achievementImages.put(3,countingButton);
        achievementImages.put(4,multiplicationMysticButton);
        achievementImages.put(5,fractionFellowshipButton);
        achievementImages.put(6,placeValuePauperButton);
        achievementImages.put(7,divisionDragonSlayerButton);
        achievementImages.put(8,fractionForgingButton);
        achievementImages.put(9,placeValuePrinceButton);

        for(int i = 1; i<=achievementImages.size(); i++){
            if(Profile.earnedAchievements.get(i) == true){
                achievementImages.get(i).setVisible(true);
            }
        }
    }
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