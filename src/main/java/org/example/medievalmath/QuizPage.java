package org.example.medievalmath;

import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class QuizPage extends Page {
    private String quizFXML;

    public QuizPage(Image backgroundImage, String quizFXML) {
        super(backgroundImage);  // Pass the background image to the super class (Page)
        this.quizFXML = quizFXML;
        loadQuizContent();
    }

    private void loadQuizContent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(quizFXML));
            AnchorPane quizContent = loader.load();
            this.getChildren().add(quizContent);  // Add the loaded content to this page
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the case where the FXML file could not be loaded
        }
    }
}
