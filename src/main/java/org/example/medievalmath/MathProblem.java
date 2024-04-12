package org.example.medievalmath;

import java.util.*;

// Class to generate and solve simple math problems
public class MathProblem {
    // final class variables
    private int a;
    private int b;
    private String operator;
    private int answer;
    private Map<String, Integer> options;
    private int level;
    private String correctOption;

    // random problem generator constructor
    public MathProblem(String operator, int level) {
        Random rand = new Random();
        this.level = level;
        if (level == 1) {
            this.a = rand.nextInt(11);   // choose random a 'a' value (0 - 10)
            this.b = rand.nextInt(11);   // choose random a 'b' value (0 - 10)
        } else if (level == 2) {
            this.a = rand.nextInt(21) - 10;   // allows for negative numbers
            this.b = rand.nextInt(21) - 10;
        } else {
            System.out.println("This level is still in development.");
        }
        this.operator = operator;          // calculates correct answer depending on problem type
        switch (operator) {
            case "+":
                this.answer = a + b;
                break;
            case "-":
                this.answer = a - b;
                break;
            case "*":
                this.answer = a * b;
                break;
            case "/":
                if (b != 0) {
                    this.answer = a / b;
                } else {
                    // exception for dividing by 0
                    throw new ArithmeticException("Cannot divide by zero. Please try another problem.");
                }
                break;
            default:
                // exception to force an operator
                throw new IllegalArgumentException("Invalid operator. Operator must be one of '+', '-', '*', '/'.");
        }
        generateOptions();  // Call generateOptions at the end of the constructor
    }

    public MathProblem(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // Method to get the level of the problem
    public int getLevel() {
        return level;
    }

    // Method to generate multiple choice options for the problem
    void generateOptions() {
        if (level == 1) {
            Random rand = new Random();
            options = new HashMap<>();
            // Generate three incorrect options
            for (char option = 'a'; option <= 'd'; option++) {
                options.put(String.valueOf(option), answer + rand.nextInt(10) + 1);
            }
            // Generate the correct option
            correctOption = String.valueOf((char) ('a' + rand.nextInt(4)));
            options.put(correctOption, answer);
        }
    }

    // Method to get the problem as a string
    public String getProblem() {
        return a + " " + operator + " " + b + " = ";
    }

    // Methods to get the options as strings
    public String getOption(String option) {
        if (!options.containsKey(option)) {
            throw new IllegalArgumentException("Option must be one of 'a', 'b', 'c', 'd'.");
        }
        return  options.get(option).toString();
    }

    // getter for problems correct answer
    public int getAnswer()  {
        return answer;
    }

    // method to check if the users answer is correct (direct input version)
    public boolean checkAnswer(int userAnswer) {
        return userAnswer == answer;
    }

    // method to check if the users answer is correct (multiple choice version)
    public boolean checkAnswer(String userOption) {
        // Check if the problem level is 1 (multiple choice)
        if (level == 1) {
            return userOption.equals(correctOption);
        } else {
            throw new IllegalArgumentException("Invalid method call. This method should only be called for multiple-choice problems.");
        }
    }


    // Static method to generate list of math problems
    public static List<MathProblem> generateProblems(int numProblems, String operator, int level) {
        List<MathProblem> problems = new ArrayList<>();
        for (int i = 0; i < numProblems; i++) {
            try {
                problems.add(new MathProblem(operator, level));    // Add a new problem to the list
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                // If division by zero occurred, try again with the same index
                i--;
            }
        }
        return problems;
        // example command to call this class -> List<MathProblem> problems = MathProblem.generateProblems(5, "+", 1);
    }
}
