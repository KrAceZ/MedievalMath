package org.example.medievalmath;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class QuizController {/*
    @FXML
    private Label question;

    @FXML
    private Button option1, option2, option3, option4;

    private Quiz quiz;

    // Method to initialize the quiz
    @FXML
    private void initialize() {
        // Load quiz data from a problem set (assuming it's provided externally)
        ProblemSet problemSet = getProblemSet(); // You need to implement this method
        quiz = new Quiz(problemSet.getProblems());
        loadNextProblem();
    }

    // Method to load the next problem
    private void loadNextProblem() {
        if (!quiz.isQuizEnd()) {
            MathProblem currentProblem = quiz.getCurrentProblem();
            question.setText(currentProblem.getQuestion());
            option1.setText(currentProblem.getOption1());
            option2.setText(currentProblem.getOption2());
            option3.setText(currentProblem.getOption3());
            option4.setText(currentProblem.getOption4());
        } else {
            // Quiz has ended, handle the end of quiz scenario
            handleEndOfQuiz();
        }
    }

    // Method to handle when an option is clicked
    @FXML
    private void optionClicked(ActionEvent event) {
        Button clickedOption = (Button) event.getSource();
        String userAnswer = clickedOption.getText();
        boolean isCorrect = quiz.checkAnswer(userAnswer);
        // Handle correct/incorrect answer here
        if (isCorrect) {
            // Handle correct answer scenario
        } else {
            // Handle incorrect answer scenario
        }
        // Move to the next problem
        quiz.moveToNextProblem();
        loadNextProblem();
    }

    // Method to handle the end of quiz
    private void handleEndOfQuiz() {
        // Implement end of quiz logic here
    }*/
}
