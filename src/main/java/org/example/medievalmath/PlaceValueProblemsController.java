package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class PlaceValueProblemsController {
    @FXML
    private Label question;
    @FXML
    private Button option1;
    @FXML
    private Button option2;

    private Quiz quiz;
    private int correctCount = 0;
    private int wrongCount = 0;

    public void initialize() {
        List<MathProblems> problems = generateProblems(10, 1);
        quiz = new Quiz(problems);
        loadNextProblem();
    }

    private List<MathProblems> generateProblems(int numProblems, int level) {
        List<MathProblems> problems = new ArrayList<>();
        for (int i = 0; i < numProblems; i++) {
            problems.add(new PlaceValueProblems(level, "Place Value"));
        }
        return problems;
    }

    private void loadNextProblem() {
        if (!quiz.isQuizEnd()) {
            MathProblems currentProblem = quiz.getCurrentProblem();
            question.setText(currentProblem.getProblem());
            option1.setText("Ones");
            option2.setText("Tens");
        } else {
            handleEndOfQuiz();
        }
    }

    private void handleEndOfQuiz() {
        question.setText("Quiz completed! You got " + correctCount + " correct and " + wrongCount + " wrong.");
        option1.setDisable(true);
        option2.setDisable(true);
    }

    @FXML
    private void optionClicked(javafx.event.ActionEvent event) {
        Button clickedOption = (Button) event.getSource();
        boolean isCorrect = quiz.checkAnswer(clickedOption.getText());
        if (isCorrect) {
            correctCount++;
        } else {
            wrongCount++;
        }
        quiz.moveToNextProblem();
        loadNextProblem();
    }
}