package org.example.medievalmath;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
<<<<<<< Updated upstream
=======
import javafx.scene.layout.VBox;

>>>>>>> Stashed changes
import java.util.*;

import static org.example.medievalmath.Quiz.problem;

public class QuizController {
    // FXML UI elements
    public ImageView backgroundImageView;
    @FXML
    private Label question;
    @FXML
    private Button option1, option2, option3, option4;

    // Static counters for correct and wrong answers
    static int correct = 0;
    static int wrong = 0;

    // Constants representing quiz size
    public static final int QUIZSIZE = 10;
    public static final int TESTSIZE = 20;

    // Static variables for managing the quiz
    private static Quiz quiz;
    private final Set<String> generatedProblems = new HashSet<>();
    static int quizLevel;
    public static String quizCompetency;
    static int numOfQuizProbs;
    private static QuizController instance;
    static String quizType;
    @FXML
    public  PieChart fractionChart;
    @FXML
    public  VBox fractionChartContainer;


    // Constructor: initializes the quiz settings and creates a new quiz
    public QuizController() {
        correct = 0;
        wrong = 0;
        quizLevel = Profile.getLevel(); // Retrieve the quiz level from the user's profile
        quizType = setQuizType(quizLevel, quizCompetency); // Determine the quiz type based on the level and competency
        quiz = new Quiz(quizType, numOfQuizProbs); // Initialize a new Quiz object
    }

    // Setters for quiz properties
    public static void setQuizLevel(int level) {
        quizLevel = level;
    }

    public static void setQuizCompetency(String competency) {
        quizCompetency = competency;
    }

    public static void setNumOfQuizProbs(int num) {
        numOfQuizProbs = num;
    }

    // FXML to load the first problem
    @FXML
    private void initialize() {
        // Initialize the quiz by resetting the problem index and loading the first problem
        System.out.println("Loading problem from QuizController.initialize");
        quiz.currentProblemIndex = 0;
        fractionChart.setVisible(false);
        loadNextProblem(quizType);
        if(quizType.equals("Fraction")){
            updatePieChart(FractionProblems.numerator, FractionProblems.denominator);
            fractionChart.setVisible(true); // Show the pie chart only for fraction problems
        }

    }

    // Method to set the quiz type based on level/competency
    private String setQuizType(int level, String competency) {
        String type = "";
        switch (competency) {
            case "a":
                type = "Arithmetic";
                break;
            case "b":
                if (level == 1) {
                    type = "Counting";
                } else {
                    type = "Fraction";
                }
                break;
            case "c":
                type = "PlaceValue";
                break;
        }
        return type;
    }

    // Method to load the next problem based on the quiz type
    private void loadNextProblem(String type) {
        // Switch-case logic to generate a problem based on the quiz type
        switch (type) {
            case "Arithmetic":
                do {
                    problem = new ArithmeticProblems(quizLevel);
                } while (generatedProblems.contains(problem.toString())); // Avoid duplicate problems
                generatedProblems.add(problem.toString());
                break;
            case "Counting":
                do {
                    problem = new CountingProblems(quizLevel);
                } while (generatedProblems.contains(problem.toString()));
                generatedProblems.add(problem.toString());
                break;
            case "Fraction":
                do {
                    problem = new FractionProblems(quizLevel);
                } while (generatedProblems.contains(problem.toString()));
                generatedProblems.add(problem.toString());

                break;
            case "PlaceValue":
                do {
                    problem = new PlaceValueProblems(quizLevel);
                } while (generatedProblems.contains(problem.toString()));
                generatedProblems.add(problem.toString());
                break;
        }

<<<<<<< Updated upstream
        // Set the text of the question label
        question.setText(problem.getProblem());
        System.out.println(problem.getProblem());
        // Set the text of the buttons
=======
        //ArithmeticProblems problem = new ArithmeticProblems(quizLevel);
        if(quizType.equals("Fraction")){
            question.setText("What fraction do you see?");
        }
        else {
            question.setText(problem.getProblem());
            System.out.println(problem.getProblem());
        }
>>>>>>> Stashed changes
        option1.setText("a) " + problem.getOption("a"));
        option2.setText("b) " + problem.getOption("b"));

        // Changes button visibility if the problem type is a PLace Values type
        if (type.equals("PlaceValue")) {
            if (quizLevel >= 2) {
                // enables/shows 3rd button
                option3.setText("c) " + problem.getOption("c"));
                option3.setDisable(false);
                option3.setVisible(true);
            } else {
                // disbale/hides 3rd button
                option3.setDisable(true);
                option3.setVisible(false);
            }
            if (quizLevel >= 3) {
                // enables/shows 4th button
                option4.setText("d) " + problem.getOption("d"));
                option4.setDisable(false);
                option4.setVisible(true);
            } else {
                // disbale/hides 4th button
                option4.setDisable(true);
                option4.setVisible(false);
            }
        } else {
            // For other problem types, ensure all options are visible and enabled
            option3.setText("c) " + problem.getOption("c"));
            option3.setDisable(false);
            option3.setVisible(true);

            option4.setText("d) " + problem.getOption("d"));
            option4.setDisable(false);
            option4.setVisible(true);
        }
    }

    // FXML event handler for when an option is clicked
    @FXML
    public void optionClicked(ActionEvent event) {
        // Extract the selected answer from the button text
        Button clickedOption = (Button) event.getSource();
        String userAnswer = clickedOption.getText().split("\\)")[0].trim();
        boolean isCorrect = quiz.checkAnswer(userAnswer);
        System.out.println(isCorrect);

        // Update counters based on the correctness of the user's answer
        if (isCorrect) {
            correct++;
        } else {
            wrong++;
        }

        // Move to the next problem or handle the end of the quiz
        quiz.moveToNextProblem();
        if (quiz.isQuizEnd()) {
            handleEndOfQuiz();
        } else {
            // Load the next problem
            System.out.println("Loading next problem from QuizController.optionClicked");
            loadNextProblem(quizType);
        }
    }

    // Method to handle the end of the quiz and transition to the results page
    private void handleEndOfQuiz() {
        // Navigate to the quiz results page
        QuizPageController.setQuizFXML("quiz_result.fxml");
        QuizPageController.getInstance().loadContent();
    }
<<<<<<< Updated upstream
}
=======

    public void updatePieChart(int numerator, int denominator) {
        fractionChart.getData().clear();
        PieChart.Data slice1 = new PieChart.Data("Fraction " + numerator + "/" + denominator, numerator);
        PieChart.Data slice2 = new PieChart.Data("Remaining", denominator - numerator);
        fractionChart.getData().addAll(slice1, slice2);
    }

}
>>>>>>> Stashed changes
