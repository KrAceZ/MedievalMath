package org.example.medievalmath;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//import static org.example.medievalmath.LoginController.videoURLs;

public class HomePageController {
    @FXML
    private ImageView backgroundImageView;
    @FXML
    private ImageView Level1Crest;
    @FXML
    private ImageView Level2Crest;
    @FXML
    private ImageView Level3Crest;
    @FXML
    private AnchorPane buttonsContainer;

    // FXML references to competency buttons
    @FXML
    private Button btnCompetency1Tutorial;
    @FXML
    private Button btnCompetency1Practice;
    @FXML
    private Button btnCompetency1Test;
    @FXML
    private Button btnCompetency2Tutorial;
    @FXML
    private Button btnCompetency2Practice;
    @FXML
    private Button btnCompetency2Test;
    @FXML
    private Button btnCompetency3Tutorial;
    @FXML
    private Button btnCompetency3Practice;
    @FXML
    private Button btnCompetency3Test;

    public static int level;
    public static Map<Integer, String> urls = new HashMap<>();

    public void initialize() {
        // Initialize the home page with background image
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Background.png")));
        Page homePage = new Page(backgroundImage);
        level = Profile.getLevel();
        urls = LoginController.videoURLs;
        switch(level){
            case 1:
                Level1Crest.setVisible(true);
                break;
            case 2:
                Level2Crest.setVisible(true);
                break;
            case 3:
                Level3Crest.setVisible(true);
                break;
        }
        // Update competency button texts based on the level
        updateButtonTextsForLevel(level);

        // Set the background image
        backgroundImageView.setImage(backgroundImage);
    }

    private void updateButtonTextsForLevel(int level) {
        switch (level) {
            case 1:
                btnCompetency1Tutorial.setText("Arithmetic Tutorial (Level 1)");
                btnCompetency1Practice.setText("Arithmetic Practice (Level 1)");
                btnCompetency1Test.setText("Arithmetic Test (Level 1)");
                btnCompetency2Tutorial.setText("Counting Tutorial (Level 1)");
                btnCompetency2Practice.setText("Counting Practice (Level 1)");
                btnCompetency2Test.setText("Counting Test (Level 1)");
                btnCompetency3Tutorial.setText("Place Values Tutorial (Level 1)");
                btnCompetency3Practice.setText("Place Values Practice (Level 1)");
                btnCompetency3Test.setText("Place Values Test (Level 1)");
                break;
            case 2:
                btnCompetency1Tutorial.setText("Arithmetic Tutorial (Level 2)");
                btnCompetency1Practice.setText("Arithmetic Practice (Level 2)");
                btnCompetency1Test.setText("Arithmetic Test (Level 2)");
                btnCompetency2Tutorial.setText("Fractions Tutorial (Level 2)");
                btnCompetency2Practice.setText("Fractions Practice (Level 2)");
                btnCompetency2Test.setText("Fractions Test (Level 2)");
                btnCompetency3Tutorial.setText("Place Values Tutorial (Level 2)");
                btnCompetency3Practice.setText("Place Values Practice (Level 2)");
                btnCompetency3Test.setText("Place Values Test (Level 2)");
                break;
            case 3:
                btnCompetency1Tutorial.setText("Arithmetic Tutorial (Level 3)");
                btnCompetency1Practice.setText("Arithmetic Practice (Level 3)");
                btnCompetency1Test.setText("Arithmetic Test (Level 3)");
                btnCompetency2Tutorial.setText("Fractions Tutorial (Level 3)");
                btnCompetency2Practice.setText("Fractions Practice (Level 3)");
                btnCompetency2Test.setText("Fractions Test (Level 3)");
                btnCompetency3Tutorial.setText("Place Values Tutorial (Level 3)");
                btnCompetency3Practice.setText("Place Values Practice (Level 3)");
                btnCompetency3Test.setText("Place Values Test (Level 3)");
                break;
        }
    }

    // get background Image for MainApplication to set window size based on background image
    public Image getBackgroundImage() {
        return backgroundImageView.getImage();
    }

    public void exitApplication(ActionEvent actionEvent) {
        // Exit application method
        LoginController.saveProfile();
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
        // Implement navigation logic to achievements page
        try {
            // Load the profile page
            Parent profilePage = FXMLLoader.load(getClass().getResource("achievements_page.fxml"));

            // Get the current scene and set the new root
            Scene scene = buttonsContainer.getScene();
            scene.setRoot(profilePage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void navigateToTutorial1Page(javafx.event.ActionEvent event) {

        String url = "";
        switch(level){
            case 1:
                url = urls.get(1);
                break;
            case 2:
                url = urls.get(4);
                break;
            case 3:
                url = urls.get(7);
                break;
        }
        navigateToTutorialPage(url, event);
    }
    @FXML
    public void navigateToPractice1Page(javafx.event.ActionEvent event) {
        String competency = "a";
        int numOfProbs = QuizController.QUIZSIZE;
        navigateToQuiz(numOfProbs, competency, event);
    }
    @FXML
    public void navigateToTest1Page(javafx.event.ActionEvent event) {
        String competency = "a";
        int numOfProbs = QuizController.TESTSIZE;
        navigateToQuiz(numOfProbs, competency, event);
    }
    @FXML
    public void navigateToTutorial2Page(javafx.event.ActionEvent event) {
        String url = "";
        switch(level){
            case 1:
                url = urls.get(2);
                break;
            case 2:
                url = urls.get(5);
                break;
            case 3:
                url = urls.get(8);
                break;
        }
        navigateToTutorialPage(url, event);
    }
    @FXML
    public void navigateToPractice2Page(javafx.event.ActionEvent event) {
        String competency = "b";
        int numOfProbs = QuizController.QUIZSIZE;
        navigateToQuiz(numOfProbs, competency, event);
    }
    @FXML
    public void navigateToTest2Page(javafx.event.ActionEvent event) {
        String competency = "b";
        int numOfProbs = QuizController.TESTSIZE;
        navigateToQuiz(numOfProbs, competency, event);
    }
    @FXML
    public void navigateToTutorial3Page(javafx.event.ActionEvent event) {
        String url = "";
        switch(level){
            case 1:
                url = urls.get(3);
                break;
            case 2:
                url = urls.get(6);
                break;
            case 3:
                url = urls.get(9);
                break;
        }
        navigateToTutorialPage(url, event);
    }
    @FXML
    public void navigateToPractice3Page(javafx.event.ActionEvent event) {
        String competency = "c";
        int numOfProbs = QuizController.QUIZSIZE;
        navigateToQuiz(numOfProbs, competency, event);
    }
    @FXML
    public void navigateToTest3Page(javafx.event.ActionEvent event) {
        String competency = "c";
        int numOfProbs = QuizController.TESTSIZE;
        navigateToQuiz(numOfProbs, competency, event);
    }
}