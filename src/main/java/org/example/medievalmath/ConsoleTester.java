package org.example.medievalmath;

import java.util.Scanner;

public class ConsoleTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user's level
        System.out.println("Enter your level (1, 2, or 3): ");
        int level = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Choose problem type
        System.out.println("Choose problem type:");
        System.out.println("1. Place Value Problems");
        System.out.println("2. Fraction Problems");
        System.out.println("3. Arithmetic Problems");
        System.out.println("4. Counting Problems");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Generate and present 4 questions
        for (int i = 0; i < 4; i++) {
            MathProblems problems = null;

            // Create appropriate problem instance based on user's choice
            switch (choice) {
                case 1:
                    problems = new PlaceValueProblems(level);
                    break;
                case 2:
                    problems = new FractionProblems(level);
                    break;
                case 3:
                    problems = new ArithmeticProblems(level);
                    break;
                case 4:
                    problems = new CountingProblems(level);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }

            System.out.println("Question " + (i + 1) + ": " + problems.getProblem());

            // Display options
            for (char option = 'a'; option <= 'd'; option++) {
                System.out.println(option + ") " + problems.getOption(String.valueOf(option)));
            }

            // Get user's answer
            System.out.println("Enter your answer (a, b, c, or d): ");
            String userAnswer = scanner.nextLine();

            // Check user's answer
            if (problems.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is: " + problems.getOption(problems.correctOption));
            }
        }

        scanner.close();
    }
}
