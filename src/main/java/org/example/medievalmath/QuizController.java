package org.example.medievalmath;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.*;

//import static org.example.medievalmath.ArithmeticProblems.generateArithmeticProblem;
//import static org.example.medievalmath.CountingProblems.generateCountingProblem;
//import static org.example.medievalmath.FractionProblems.generateFractionProblem;
//import static org.example.medievalmath.PlaceValueProblems.generatePlaceValueProblem;

public class QuizController {
    @FXML
    private Label question;

    @FXML
    private Button option1, option2, option3, option4;
    static int correct = 0;
    static int wrong = 0;

    private Quiz quiz;
    private Set<String> generatedProblems = new HashSet<>();
    static int quizLevel;
    static String quizCompetency;
    static int numOfQuizProbs;
    private static QuizController instance;

    public QuizController()
    {
        if(instance == null)
        {
            instance = this;
        }
    }



    public static QuizController getInstance()
    {
        return instance;
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
        correct = 0;
        wrong = 0;
        quizLevel = Profile.getLevel();
        //List<MathProblems> problems = generateProblems(numOfQuizProbs, quizLevel, quizCompetency);
        List<MathProblems> problems = generateProblems(numOfQuizProbs, quizLevel, quizCompetency);
        this.quiz = new Quiz(problems);

        // load the first problem
        loadNextProblem();
    }

    public void setQuiz(List<MathProblems> problems) {
        quiz = new Quiz(problems);
        loadNextProblem();  // Load the first problem when the quiz is set
    }

     private List<MathProblems> generateProblems(int numOfProbs, int level, String competency) {
         List<MathProblems> probs = new ArrayList<>();
         switch (competency){
             case "a":
                 for (int i = 0; i < numOfProbs; i++) {
                     MathProblems problem;
                     do {
                         problem = new ArithmeticProblems(level);
                     } while (generatedProblems.contains(problem.toString()));

                     probs.add(problem);
                     generatedProblems.add(problem.toString());
                 }
                 break;
             case "b":
                 if(level == 1) {
                     for (int i = 0; i < numOfProbs; i++) {
                         MathProblems problem;
                         do {
                             problem = new CountingProblems(level);
                         } while (generatedProblems.contains(problem.toString()));

                         probs.add(problem);
                         generatedProblems.add(problem.toString());
                     }
                 }
                 else{
                     for (int i = 0; i < numOfProbs; i++) {
                         MathProblems problem;
                         do {
                             problem = new FractionProblems(level);
                         } while (generatedProblems.contains(problem.toString()));

                         probs.add(problem);
                         generatedProblems.add(problem.toString());
                     }
                 }
                 break;
             case "c":
                 for (int i = 0; i < numOfProbs; i++) {
                    MathProblems problem;
                    do {
                         problem = new PlaceValueProblems(level);
                    } while (generatedProblems.contains(problem.toString()));

                    probs.add(problem);
                    generatedProblems.add(problem.toString());
                 }
                 break;
         }

         return probs;
     }


//    private List<MathProblems> generateProblems(int numOfProbs, int level) {
//        List<MathProblems> problems = new ArrayList<>();
//        for (int i = 0; i < numOfProbs; i++) {
//            MathProblems problem;
//            do {
//                problem = QuizTypeDecider.generateProblems(QuizController.quizCompetency, level, 1).get(0); // Corrected problem generation
//            } while (generatedProblems.contains(problem.toString()));
//            problems.add(problem);
//            generatedProblems.add(problem.toString());
//        }
//        return problems;
//    }



    // method to load the next problem
    private void loadNextProblem() {
        if (!quiz.isQuizEnd()) {
            MathProblems currentProblem = quiz.getCurrentProblem();
            question.setText(currentProblem.getProblem());
            if (currentProblem.getLevel() == 1) {
                option1.setText("a) " + currentProblem.getOption("a"));
                option2.setText("b) " + currentProblem.getOption("b"));
                option3.setText("c) " + currentProblem.getOption("c"));
                option4.setText("d) " + currentProblem.getOption("d"));
            } else {
                option1.setText("Please input your answer.");
                option2.setDisable(true);
                option3.setDisable(true);
                option4.setDisable(true);
            }
        } else {
            // If there are no more problems left, handle the end of the quiz
            handleEndOfQuiz();
        }
    }

    // Method to handle when an option is clicked
    @FXML
    public void optionClicked(ActionEvent event) {
        Button clickedOption = (Button) event.getSource();
        String userAnswer = clickedOption.getText().split("\\)")[0].trim(); // Corrected button text extraction
        boolean isCorrect = quiz.checkAnswer(userAnswer);

        if (isCorrect) {
            correct++;
        } else {
            wrong++;
        }
        // Move to the next problem
        quiz.moveToNextProblem();
        // Load the next problem
        loadNextProblem();
    }

    // Method to handle the end of quiz
    private void handleEndOfQuiz() {
        // Implement end of quiz logic here
    }
//    public QuizController() {
//        correct = 0;
//        wrong = 0;
//        List<MathProblems> problems = generateProblems(10, 1);
//        this.quiz = new Quiz(problems);
//    }

//    private List<MathProblems> generateProblems(int numOfProbs, int level, String competency) {
//        List<MathProblems> problems = new ArrayList<>();
//        for (int i = 0; i < numOfProbs; i++) {
//            MathProblems problem;
//            do {
//                problem = new MathProblems(level, competency);
//            } while (generatedProblems.contains(problem.toString()));
//
//            problems.add(problem);
//            generatedProblems.add(problem.toString());
//        }
//        return problems;
//    }


//    private Profile getProfile() {
//    // The following code with replace the hardcoded profile info when the database is set up:
//        // String username = getCurrentUsername();
//        // Profile profile = queryDatabaseForProfile(username);
//        // return profile;
//
//    // temporary hardcoded profile maker
//        String studentName = getUserInput("Enter student name: ");
//        int grade = Integer.parseInt(getUserInput("Enter grade: "));
//        String username = getUserInput("Enter username: ");
//        String password = getUserInput("Enter password: ");
//
//        // Create and return a new Profile object
//        return new Profile(studentName, grade, username, password);
//    }

    // temporary Scanner object to make profiles in getProfile() until database is added
//    private String getUserInput(String prompt) {
//        // Create a Scanner object for reading input
//        Scanner scanner = new Scanner(System.in);
//
//        // Print the prompt
//        System.out.println(prompt);
//
//        // Get user input
//        return scanner.nextLine();
//    }

    // method to generate problems
//    private List<MathProblems> getProblems(Profile profile) {
//        List<MathProblems> problems = new ArrayList<>();
//        String[] operators = {"+", "-", "*", "/"};
//        Random rand = new Random();
//
//        // get the level from the profile
//        int level = profile.getLevel();
//
//        // Generate 3 problems for normal quiz
//        for (int i = 0; i < 3; i++) {
//            // choose a random operator
//            String operator = operators[rand.nextInt(operators.length)];
//            // create a new MathProblems object with the chosen level and add it to the list
//            problems.add(new MathProblems(operator, level));
//        }
//
//        return problems;
//    }
}
