package org.example.medievalmath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// Class ArithmeticProblems extends the abstract class MathProblems
public class ArithmeticProblems extends MathProblems<Integer> {
    // Declare variables for the operands, operator, answer, and question
    private static int a, b;
    private static String operator;
    private static int answer;


    // Constructor for the ArithmeticProblems class
    public ArithmeticProblems(int level) {
        super(level); // Call the constructor of the superclass MathProblems
        Random rand = new Random(); // Create a new Random object
        String[] operators = {"+", "-", "*", "/"}; // Array of operators
        int opIndex = 0; // Index for selecting an operator from the array
        // Generate operands and select operator based on the level
        switch (level) {
            case 1:
                a = rand.nextInt(11); // Generate a number between 0 and 10
                b = rand.nextInt(a + 1); // Generate a number between 0 and a
                opIndex = rand.nextInt(2); // Select an operator (+ or -)
                break;
            case 2:
                opIndex = rand.nextInt(4); // Select an operator (+, -, *, /)
                operator = operators[opIndex]; // Set the operator
                switch (operator) {
                    case "+":
                    case "-":
                        a = rand.nextInt(101); // Generate a number between 0 and 100
                        b = rand.nextInt(101 - a); // Generate a number between 0 and (100 - a)
                        break;
                    case "*":
                    case "/":
                        a = rand.nextInt(11); // Generate a number between 0 and 10
                        b = rand.nextInt(11); // Generate a number between 0 and 10
                        break;
                }
                break;
            case 3:
                opIndex = rand.nextInt(4)+2; // Select an operator (*, /)
                operator = operators[opIndex]; // Set the operator
                switch (operator) {
                    case "+":
                    case "-":
                        a = rand.nextInt(145); // Generate a number between 0 and 144
                        b = rand.nextInt(145 - a); // Generate a number between 0 and (144 - a)
                        break;
                    case "*":
                    case "/":
                        a = rand.nextInt(13); // Generate a number between 0 and 12
                        b = rand.nextInt(13); // Generate a number between 0 and 12
                        break;
                }
                break;
        }
        operator = operators[opIndex]; // Set the operator

        // Calculate the answer based on the operator
        switch (operator) {
            case "+":
                answer = a + b;
                break;
            case "-":
                answer = a - b;
                break;
            case "*":
                answer = a * b;
                break;
            case "/":
                if (b != 0) {
                    while (a % b != 0) {
                        a = rand.nextInt(145); // Generate a number between 0 and 144
                        b = rand.nextInt(a) + 1; // Generate a number between 1 and a
                    }
                    answer = a / b;
                } else {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operator. Must be '+', '-', '*', '/'");
        }
        generateOptions(); // Generate the options for the problem
    }

    // Method to get the problem as a string
    @Override
    public String getProblem() {
        String displayOperator = operator;
        if (operator.equals("/")) {
            displayOperator = "÷"; // Display the division operator as ÷
        }
        return a + " " + displayOperator + " " + b + " = ";
    }

    // Method to generate the options for the problem
    protected void generateOptions() {
        Random rand = new Random();
        options = new HashMap<>();
        List<Integer> usedNumbers = new ArrayList<>();
        for (char option = 'a'; option <= 'd'; option++) {
            int randomNum;
            do {
                randomNum = answer + rand.nextInt(10) + 1;
            } while (usedNumbers.contains(randomNum));
            usedNumbers.add(randomNum);
            options.put(String.valueOf(option), randomNum);
        }
        correctOption = String.valueOf((char) ('a' + rand.nextInt(4)));
        options.put(correctOption, answer);
    }

    // Method to get the option corresponding to a key
    @Override
    public String getOption(String key) {
        Integer optionValue = options.get(key);
        if (optionValue != null) {
            return String.valueOf(optionValue);
        } else {
            return null; // Or handle the case when the key is not found
        }
    }
}