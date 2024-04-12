package org.example.medievalmath;

import java.util.List;
import java.util.Scanner;

public class GeneralTesting {

    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Get profile details from the user
        System.out.println("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter grade: ");
        int grade = Integer.parseInt(scanner.nextLine());
//        System.out.println("Enter username: ");
//        String username = scanner.nextLine();
//        System.out.println("Enter password: ");
//        String password = scanner.nextLine();
        // Hardcode username and password
        String username = "testUser";
        String password = "testPassword";

        // Create a profile
        Profile profile = new Profile(studentName, grade, username, password);

        // Generate problems
        List<MathProblem> problems = MathProblem.generateProblems(3, "+", profile.getLevel());

        // Create a quiz
        Quiz quiz = new Quiz(problems);

        // Loop through the problems
        while (!quiz.isQuizEnd()) {
            MathProblem problem = quiz.getCurrentProblem();
            System.out.println(problem.getProblem());
            // If the problem level is 1, display the options
            if (problem.getLevel() == 1) {
                System.out.println("a) " + problem.getOption("a"));
                System.out.println("b) " + problem.getOption("b"));
                System.out.println("c) " + problem.getOption("c"));
                System.out.println("d) " + problem.getOption("d"));
                System.out.println("Enter your answer (a, b, c, or d): ");
                String userOption = scanner.nextLine();
                // Check answer
                if (problem.checkAnswer(userOption)) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is " + problem.getAnswer());
                }
            } else {
                // If the problem level is not 1, get user's answer as an integer
                System.out.println("Enter your answer: ");
                int userAnswer = Integer.parseInt(scanner.nextLine());
                // Check answer
                if (problem.checkAnswer(userAnswer)) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is " + problem.getAnswer());
                }
            }
            // Move to next problem
            quiz.moveToNextProblem();
        }

        System.out.println("Quiz ended.");
    }
}
