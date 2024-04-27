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

    public static int level =1;

    public void initialize() {
        // Initialize the home page with background image
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Background.png")));
        Page homePage = new Page(backgroundImage);
        //level = Profile.getLevel();

        // Set the background image
        backgroundImageView.setImage(backgroundImage);
    }

    // get background Image for MainApplication to set window size based on background image
    public Image getBackgroundImage() {
        return backgroundImageView.getImage();
    }

    public void exitApplication(ActionEvent actionEvent) {
        // Exit application method
        Platform.exit();
    }
    //Helper method for navigating to quizzes
    @FXML
    public void navigateToQuiz(int numOfProbs, String quizComp, javafx.event.ActionEvent event) {
        QuizPageController.setQuizFXML("quiz.fxml");
        QuizController.setQuizLevel(level);
        QuizController.setQuizCompetency(quizComp);
        QuizController.setNumOfQuizProbs(numOfProbs);
        try {
            // Load the FXML file for the basic addition page
            Parent quizPage = FXMLLoader.load(getClass().getResource("quiz_page.fxml"));
            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // Set the new scene to the stage test
            stage.setScene(new Scene(quizPage));
            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Helper method for navigating to tutorials
    @FXML
    public void navigateToTutorialPage(String url, javafx.event.ActionEvent event) {
        try {
            TutorialPageController.setVideoUrl(url);
            // Load the FXML file for the addition tutorial page
            Parent tutorialPage = FXMLLoader.load(getClass().getResource("tutorial_page.fxml"));
            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // Set the new scene to the stage test
            stage.setScene(new Scene(tutorialPage));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    @FXML
    private void navigateToShopPage() {
        // Implement navigation logic to Shop page
    }
    // Method to navigate to Trophies page
    @FXML
    private void navigateToTrophiesPage() {
        // Implement navigation logic to Trophies page
    }
    @FXML
    public void navigateToTutorial1Page(javafx.event.ActionEvent event) {
        String url = "https://www.youtube.com/embed/AuX7nPBqDts";
        navigateToTutorialPage(url, event);
    }
    @FXML
    public void navigateToPractice1Page(javafx.event.ActionEvent event) {
        String competency = "a";
        int numOfProbs = 10;
        navigateToQuiz(numOfProbs, competency, event);
    }
    @FXML
    public void navigateToTest1Page(javafx.event.ActionEvent event) {
        String competency = "a";
        int numOfProbs = 20;
        navigateToQuiz(numOfProbs, competency, event);
    }
    @FXML
    public void navigateToTutorial2Page(javafx.event.ActionEvent event) {
        String url = "https://www.youtube.com/embed/aNqG4ChKShI";
        navigateToTutorialPage(url, event);
    }
    @FXML
    public void navigateToPractice2Page(javafx.event.ActionEvent event) {
        String competency = "b";
        int numOfProbs = 10;
        navigateToQuiz(numOfProbs, competency, event);
    }
    @FXML
    public void navigateToTest2Page(javafx.event.ActionEvent event) {
        String competency = "b";
        int numOfProbs = 20;
        navigateToQuiz(numOfProbs, competency, event);
    }
    @FXML
    public void navigateToTutorial3Page(javafx.event.ActionEvent event) {
        String url = "https://www.youtube.com/embed/aNqG4ChKShI";
        navigateToTutorialPage(url, event);
    }
    @FXML
    public void navigateToPractice3Page(javafx.event.ActionEvent event) {
        String competency = "c";
        int numOfProbs = 10;
        navigateToQuiz(numOfProbs, competency, event);
    }
    @FXML
    public void navigateToTest3Page(javafx.event.ActionEvent event) {
        String competency = "c";
        int numOfProbs = 20;
        navigateToQuiz(numOfProbs, competency, event);
    }
//    @FXML
//    public void navigateToSubtractionTutorialPage(javafx.event.ActionEvent event) {
//        try {
//            // Load the FXML file for the subtraction tutorial page
//            Parent SubtractionTutorialPage = FXMLLoader.load(getClass().getResource("basic_subtraction_tutorial.fxml")); // edit this
//
//            // Get the current stage
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//            // Set the new scene to the stage test
//            stage.setScene(new Scene(SubtractionTutorialPage));
//
//            // Show the stage
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @FXML
//    public void navigateToAdditionTutorialPage(javafx.event.ActionEvent event) {
//        try {
//            TutorialPageController.setVideoUrl("https://www.youtube.com/embed/AuX7nPBqDts");
//            // Load the FXML file for the addition tutorial page
//            Parent AdditionTutorialPage = FXMLLoader.load(getClass().getResource("tutorial_page.fxml")); // edit this
//
//            // Get the current stage
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//            // Set the new scene to the stage test
//            stage.setScene(new Scene(AdditionTutorialPage));
//
//            // Show the stage
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @FXML
//    public void navigateToBasicAddSubtractPage(javafx.event.ActionEvent event) {
//        QuizPageController.setQuizFXML("basic_add_subtract_test.fxml");
//        try {
//            // Load the FXML file for the basic addition page
//            Parent BasicAddSubtractPage = FXMLLoader.load(getClass().getResource("quiz_page.fxml"));
//
//            // Get the current stage
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//            // Set the new scene to the stage test
//            stage.setScene(new Scene(BasicAddSubtractPage));
//
//            // Show the stage
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    //modified to go to quiz page with basic addition quiz
//    @FXML
//    public void navigateToBasicAdditionPage(javafx.event.ActionEvent event) {
//        QuizPageController.setQuizFXML("basic_addition_quiz.fxml");
//        try {
//            // Load the FXML file for the basic addition page
//            Parent basicAdditionPage = FXMLLoader.load(getClass().getResource("quiz_page.fxml"));
//
//            // Get the current stage
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//            // Set the new scene to the stage test
//            stage.setScene(new Scene(basicAdditionPage));
//            //stage.setScene(new Scene(
//            // Show the stage
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    @FXML
//    public void navigateToBasicSubtractionPage(javafx.event.ActionEvent event) {
//        QuizPageController.setQuizFXML("basic_subtraction_quiz.fxml");
//        try {
//            // Load the FXML file for the basic addition page
//            Parent basicSubtractionPage = FXMLLoader.load(getClass().getResource("quiz_page.fxml"));
//
//            // Get the current stage
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//            // Set the new scene to the stage test
//            stage.setScene(new Scene(basicSubtractionPage));
//
//            // Show the stage
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    // Method to navigate to Quizzes page
//    @FXML
//    private void navigateToQuizzesPage() {
//         Implement navigation logic to Quizzes page
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
//    }
}
