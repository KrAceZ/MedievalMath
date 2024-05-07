package org.example.medievalmath;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.*;


import static org.example.medievalmath.Quiz.problem;


public class QuizController {
    public ImageView backgroundImageView;
    @FXML
    private Label question;

    @FXML
    private Button option1, option2, option3, option4;
    static int correct = 0;
    static int wrong = 0;

    private static Quiz quiz;
    private final Set<String> generatedProblems = new HashSet<>();
    static int quizLevel;
    static String quizCompetency;
    static int numOfQuizProbs;
    private static QuizController instance;
    static String quizType;


    public QuizController()
    {
        correct = 0;
        wrong = 0;
        quizLevel = Profile.getLevel();
        //List<MathProblems> problems = generateProblems(numOfQuizProbs, quizLevel, quizCompetency);

        //List<MathProblems> problems = generateProblems(numOfQuizProbs, quizLevel, quizCompetency);
        quizType = setQuizType(numOfQuizProbs, quizLevel, quizCompetency);
        //quiz = new Quiz(problems);
        quiz = new Quiz(quizType, numOfQuizProbs);
        //System.out.println("number of problems: "+ problems.size());

        //List<MathProblems> problems = generateProblems(numOfQuizProbs, quizLevel, quizCompetency);
        //quiz = new Quiz(problems);
       // System.out.println("number of problems: "+ problems.size());

    }

    public static void setQuizLevel(int level)
    {
        quizLevel = level;
    }
    public static void setQuizCompetency(String competency)
    {
        quizCompetency = competency;
    }
    public static void setNumOfQuizProbs(int num)
    {
        numOfQuizProbs=num;
    }
    // Method to initialize the quiz
    @FXML
    private void initialize() {
        // load the first problem
        System.out.println("Loading problem from QuizController.initialize");
        quiz.currentProblemIndex = 0;
        loadNextProblem(quizType);
    }


     //private List<MathProblems> generateProblems(int numOfProbs, int level, String competency) {
    private String setQuizType(int numOfProbs, int level, String competency){
         //List<MathProblems> probs = new ArrayList<>();
        String type = "";


     //private List<MathProblems> generateProblems(int numOfProbs, int level, String competency) {
         //List<MathProblems> probs = new ArrayList<>();
         switch (competency){
             case "a":
                 //probs = generateArithmeticProblems(numOfProbs, level, competency);
//                 for (int i = 0; i < numOfProbs; i++) {
//                     //MathProblems problem;
//                     ArithmeticProblems problem;
//                     do {
//                         problem = new ArithmeticProblems(level);
//                     } while (generatedProblems.contains(problem.toString()));
//                     //problem = new ArithmeticProblems(level);
//                     probs.add(problem);
//                     generatedProblems.add(problem.toString());
//                     System.out.println(problem);
//                 }
                 type = "Arithmetic";
                 break;
             case "b":
                 if(level == 1) {
                     type = "Counting";
//                     for (int i = 0; i < numOfProbs; i++) {
//                         MathProblems problem;
//                         do {
//                             problem = new CountingProblems(level);
//                         } while (generatedProblems.contains(problem.toString()));
//
//                         probs.add(problem);
//                         generatedProblems.add(problem.toString());
//                     }
                 }
                 else{
                     type = "Fraction";
//                     for (int i = 0; i < numOfProbs; i++) {
//                         MathProblems problem;
//                         do {
//                             problem = new FractionProblems(level);
//                         } while (generatedProblems.contains(problem.toString()));
//
//                         probs.add(problem);
//                         generatedProblems.add(problem.toString());
//                     }
                 }
                 break;
             case "c":
                 type = "PlaceValue";
//                 for (int i = 0; i < numOfProbs; i++) {
//                    MathProblems problem;
//                    do {
//                         problem = new PlaceValueProblems(level);
//                    } while (generatedProblems.contains(problem.toString()));
//
//                    probs.add(problem);
//                    generatedProblems.add(problem.toString());
//                 }
                 break;
         }

         return type;
     }

    // method to load the next problem
//    private void loadNextProblem() {
//            MathProblems currentProblem = quiz.getCurrentProblem();
//            question.setText(currentProblem.getProblem());
//            System.out.println(currentProblem.getProblem());
//
//            option1.setText("a) " + currentProblem.getOption("a"));
//            option2.setText("b) " + currentProblem.getOption("b"));
//            option3.setText("c) " + currentProblem.getOption("c"));
//            option4.setText("d) " + currentProblem.getOption("d"));
//    }
    private void loadNextProblem(String type) {
        switch(type){
            case "Arithmetic":
                problem = new ArithmeticProblems(quizLevel);
                break;
            case "Counting":
                problem = new CountingProblems(quizLevel);
                break;
            case "Fraction":
                problem = new FractionProblems(quizLevel);
                break;
            case "PlaceValue":
                problem = new PlaceValueProblems(quizLevel);
                break;
        }

        //ArithmeticProblems problem = new ArithmeticProblems(quizLevel);
        question.setText(problem.getProblem());
        System.out.println(problem.getProblem());

        option1.setText("a) " + problem.getOption("a"));
        option2.setText("b) " + problem.getOption("b"));
        option3.setText("c) " + problem.getOption("c"));
        option4.setText("d) " + problem.getOption("d"));
    }

    // Method to handle when an option is clicked
    @FXML
    public void optionClicked(ActionEvent event) {
        Button clickedOption = (Button) event.getSource();
        String userAnswer = clickedOption.getText().split("\\)")[0].trim(); // Corrected button text extraction
        boolean isCorrect = quiz.checkAnswer(userAnswer);
        System.out.println(isCorrect);

        if (isCorrect) {
            correct++;
        } else {
            wrong++;
        }
        // Move to the next problem
        quiz.moveToNextProblem();
        if(quiz.isQuizEnd())
        {
            handleEndOfQuiz();
        }
        else {
            // Load the next problem
            System.out.println("Loading next problem from QuizController.optionClicked");
            loadNextProblem(quizType);
        }
    }

    // Method to handle the end of quiz
    private void handleEndOfQuiz() {
        // Implement end of quiz logic here
        QuizPageController.setQuizFXML("quiz_result.fxml");
        QuizPageController.getInstance().loadContent();
    }

}
