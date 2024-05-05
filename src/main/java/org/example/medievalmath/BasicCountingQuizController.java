//package org.example.medievalmath;
//
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//
//import java.util.*;
//
//public class BasicCountingQuizController {
//    @FXML
//    private Label question;
//
//    @FXML
//    private Button option1, option2, option3, option4;
//
//    static int correct = 0;
//    static int wrong = 0;
//
//    private Quiz quiz;
//    private Set<String> generatedProblems = new HashSet<>();
//
//    public BasicCountingQuizController() {
//        correct = 0;
//        wrong = 0;
//
//        List<MathProblems> problems = generateProblems(10, 1);
//        this.quiz = new Quiz(problems);
//    }
//
//    @FXML
//    private void initialize() {
//        loadNextProblem();
//    }
//
//    private List<MathProblems> generateProblems(int numOfProbs, int level) {
//        List<MathProblems> problems = new ArrayList<>();
//        for (int i = 0; i < numOfProbs; i++) {
//            MathProblems problem;
//            do {
//                problem = new CountingProblems(level, competency);
//            } while (generatedProblems.contains(problem.toString()));
//
//            problems.add(problem);
//            generatedProblems.add(problem.toString());
//        }
//        return problems;
//    }
//
//    private void loadNextProblem() {
//        if (!quiz.isQuizEnd()) {
//            MathProblems currentProblem = quiz.getCurrentProblem();
//            question.setText(currentProblem.getProblem());
//            if (currentProblem.getLevel() == 1) {
//                option1.setText("a) " + currentProblem.getOption("a"));
//                option2.setText("b) " + currentProblem.getOption("b"));
//                option3.setText("c) " + currentProblem.getOption("c"));
//                option4.setText("d) " + currentProblem.getOption("d"));
//            } else {
//                option1.setText("Please input your answer.");
//                option2.setDisable(true);
//                option3.setDisable(true);
//                option4.setDisable(true);
//            }
//        } else {
//            handleEndOfQuiz();
//        }
//    }
//
//    @FXML
//    public void optionClicked(javafx.event.ActionEvent event) {
//        Button clickedOption = (Button) event.getSource();
//        String userAnswer = clickedOption.getText().substring(0, 1);
//        boolean isCorrect = quiz.checkAnswer(userAnswer);
//
//        if (isCorrect) {
//            correct++;
//        } else {
//            wrong++;
//        }
//        quiz.moveToNextProblem();
//        if(quiz.isQuizEnd())
//        {
//            handleEndOfQuiz();
//        }
//        else {
//            loadNextProblem();
//        }
//    }
//
//    private void handleEndOfQuiz() {
//        QuizPageController.setQuizFXML("basic_counting_result.fxml");
//        QuizPageController.getInstance().loadContent();
//    }
//}