//package org.example.medievalmath;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//
//import java.util.*;
//
//public class BasicAddSubtractTestController {
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
//    //private Profile profile;
//
//    public BasicAddSubtractTestController() {
//        // reset correct and wrong counters to 0 each time a quiz made
//        correct = 0;
//        wrong = 0;
//
//        // get the user profile
//        //this.profile = getProfile();
//
//        // Generate a list of problems based on the profile level
//        //List<MathProblems> problems = getProblems(profile); // Pass the profile to the getProblems method
//        List<MathProblems> problems = getProblems(20, 1);
//        // Create a Quiz object with random problems
//        this.quiz = new Quiz(problems);
//    }
//
//    // Method to initialize the quiz
//    @FXML
//    private void initialize() {
//        // Load quiz data from a problem set (assuming it's provided externally)
////        Profile profile = getProfile();
////        List<MathProblems> problems = getProblems(profile);
////        quiz = new Quiz(problems);
////        loadNextProblem();
//
//        // load the first problem
//        loadNextProblem();
//    }
//
//    private Profile getProfile() {
//        // The following code with replace the hardcoded profile info when the database is set up:
//        // String username = getCurrentUsername();
//        // Profile profile = queryDatabaseForProfile(username);
//        // return profile;
//
//        // temporary hardcoded profile maker
//        String studentName = getUserInput("Enter student name: ");
//        int grade = Integer.parseInt(getUserInput("Enter grade: "));
//        String username = getUserInput("Enter username: ");
//        String password = getUserInput("Enter password: ");
//
//        // Create and return a new Profile object
//        return new Profile(studentName, grade, username, password);
//    }
//
//    // temporary Scanner object to make profiles in getProfile() until database is added
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
//
//    // method to generate problems
//    private List<MathProblems> getProblems(int numOfProbs, int level) {
//        Set<MathProblems> problems = new HashSet<>();
//        int numOfOps = 0;
//        if(level ==1)
//        {
//            numOfOps = 2;
//        }
//        else
//        {
//            numOfOps = 4;
//        }
//        String[] operators = {"+", "-", "*", "/"};
//        Random rand = new Random();
//
//        // Generate problems for normal quiz
//        while (problems.size() < numOfProbs) {
//            // choose a random operator
//            int op = rand.nextInt(numOfOps);
//            String operator = operators[op];
//            // create a new MathProblems object with the chosen level
//            MathProblems problem = new MathProblems(operator, level);
//            // add it to the set (duplicates will be ignored)
//            problems.add(problem);
//        }
//
//        // Convert the set to a list and return it
//        return new ArrayList<>(problems);
//    }
//
//    // method to load the next problem
//    private void loadNextProblem() {
//        // check if quiz has ended
//        //if (!quiz.isQuizEnd()) {
//        // get current problem
//        MathProblems currentProblem = quiz.getCurrentProblem();
//        // display the problem
//        question.setText(currentProblem.getProblem());
//        // (I changed the following code to work with a different style of getters in the MathProblems class)
//        if (currentProblem.getLevel() == 1) {   // If the problem level is 1, set the text of the option buttons to the options of the problem
//            option1.setText("a) " + currentProblem.getOption("a"));
//            option2.setText("b) " + currentProblem.getOption("b"));
//            option3.setText("c) " + currentProblem.getOption("c"));
//            option4.setText("d) " + currentProblem.getOption("d"));
//        } else {     // If the problem level is 2 or above, disable the option buttons and prompt the user to input their answer
//            option1.setText("Please input your answer.");
//            option2.setDisable(true);
//            option3.setDisable(true);
//            option4.setDisable(true);
//        }
//        //} else {
//        // If there are no more problems left, handle the end of the quiz
//        //    handleEndOfQuiz();
//        //}
//    }
//
//    // Method to handle when an option is clicked
//    @FXML
//    public void optionClicked(ActionEvent event) {
//        // Get the clicked option
//        Button clickedOption = (Button) event.getSource();
//        // Get the user's answer
//        String userAnswer = clickedOption.getText().substring(0, 1);  // Get the option letter ("a", "b", "c", or "d")
//        // Check the user's answer
//        boolean isCorrect = quiz.checkAnswer(userAnswer);
//
//        if (isCorrect) {
//            // If the answer is correct, do something
//            correct++;
//        } else {
//            // If the answer is incorrect, do something else
//            wrong++;
//        }
//        // Move to the next problem
//        quiz.moveToNextProblem();
//        if(quiz.isQuizEnd())
//        {
//            handleEndOfQuiz();
//            /*
//            try {
//                Stage thisStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
//                thisStage.close();
//
//                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("basic_addition_result.fxml"));
//                Scene scene = new Scene(fxmlLoader.load());
//                Stage stage = new Stage();
//                stage.setScene(scene);
//                stage.initStyle(StageStyle.TRANSPARENT);
//                scene.setFill(Color.TRANSPARENT);
//                stage.show();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }*/
//        }
//        else {
//            // Load the next problem
//            loadNextProblem();
//        }
//    }
//
//    // Method to handle the end of quiz
//    private void handleEndOfQuiz() {
//        // Implement end of quiz logic here
//        QuizPageController.setQuizFXML("basic_add_subtract_result.fxml");
//        QuizPageController.getInstance().loadContent();
//    }
//}
