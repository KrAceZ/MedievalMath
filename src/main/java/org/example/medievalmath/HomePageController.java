package org.example.medievalmath;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomePageController {
    @FXML
    private ImageView backgroundImageView;

    @FXML
    private AnchorPane buttonsContainer;

    public void initialize() {
        // Initialize the home page with background image
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Background.png")));
        Page homePage = new Page(backgroundImage);

        // Set the background image
        backgroundImageView.setImage(backgroundImage);
    }

    // get background Image for MainApplication to set window size based on background image
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
//        try {
//            // Load the profile page
//            Parent quizPage = FXMLLoader.load(getClass().getResource("quiz_page.fxml"));
//
//            // Get the current scene and set the new root
//            Scene scene = buttonsContainer.getScene();
//            scene.setRoot(quizPage);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    // Method to navigate to Shop page
    @FXML
    private void navigateToShopPage() {
        // Implement navigation logic to Shop page
        try {
            // Load the profile page
            Parent profilePage = FXMLLoader.load(getClass().getResource("ShopItem.fxml"));

            // Get the current scene and set the new root
            Scene scene = buttonsContainer.getScene();
            scene.setRoot(profilePage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to navigate to Trophies page
    @FXML
    private void navigateToTrophiesPage() {
        // Implement navigation logic to Trophies page
    }

    /* original
    @FXML
    public void navigateToBasicAdditionPage(javafx.event.ActionEvent event) {
        try {
            // Load the FXML file for the basic addition page
            Parent basicAdditionPage = FXMLLoader.load(getClass().getResource("basic_addition_quiz.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene to the stage test
            stage.setScene(new Scene(basicAdditionPage));

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     */
    //modified to go to quiz page with basic addition quiz
    @FXML
    public void navigateToBasicAdditionPage(javafx.event.ActionEvent event) {
        QuizPageController.setQuizFXML("basic_addition_quiz.fxml");
        try {
            // Load the FXML file for the basic addition page
            Parent basicAdditionPage = FXMLLoader.load(getClass().getResource("quiz_page.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene to the stage test
            stage.setScene(new Scene(basicAdditionPage));

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void navigateToBasicSubtractionPage(javafx.event.ActionEvent event) {
        QuizPageController.setQuizFXML("basic_subtraction_quiz.fxml");
        try {
            // Load the FXML file for the basic addition page
            Parent basicSubtractionPage = FXMLLoader.load(getClass().getResource("quiz_page.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene to the stage test
            stage.setScene(new Scene(basicSubtractionPage));

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void navigateToBasicAddSubtractPage(javafx.event.ActionEvent event) {
        QuizPageController.setQuizFXML("basic_add_subtract_test.fxml");
        try {
            // Load the FXML file for the basic addition page
            Parent BasicAddSubtractPage = FXMLLoader.load(getClass().getResource("quiz_page.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene to the stage test
            stage.setScene(new Scene(BasicAddSubtractPage));

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void navigateToAdditionTutorialPage(javafx.event.ActionEvent event) {
        try {
            // Load the FXML file for the addition tutorial page
            Parent AdditionTutorialPage = FXMLLoader.load(getClass().getResource("basic_addition_tutorial.fxml")); // edit this

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene to the stage test
            stage.setScene(new Scene(AdditionTutorialPage));

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void navigateToSubtractionTutorialPage(javafx.event.ActionEvent event) {
        try {
            // Load the FXML file for the subtraction tutorial page
            Parent SubtractionTutorialPage = FXMLLoader.load(getClass().getResource("basic_subtraction_tutorial.fxml")); // edit this

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene to the stage test
            stage.setScene(new Scene(SubtractionTutorialPage));

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exitApplication(ActionEvent actionEvent) {
        // Exit application method
        Platform.exit();
    }

}
