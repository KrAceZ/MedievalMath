package org.example.medievalmath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ArithmeticProblems extends MathProblems<Integer> {
    private static int a, b;
    private static String operator;
    private static int answer;
    private static String question;

    public ArithmeticProblems(int level) {
        super(level);
        //generateArithmeticProblems(level);
        Random rand = new Random();
        String[] operators = {"+", "-", "*", "/"};
        int opIndex = 0;
        switch (level) {
            case 1:
                a = rand.nextInt(11); // Generate a number between 0 and 10
                b = rand.nextInt(a + 1); // Generate a number between 0 and a
                opIndex = rand.nextInt(2);
                break;
            case 2:
                a = rand.nextInt(101); // Generate a number between 0 and 100
                b = rand.nextInt(101); // Generate a number between 0 and 100
                opIndex = rand.nextInt(4);
                break;
            case 3:
                a = rand.nextInt(145); // Generate a number between 0 and 144
                b = rand.nextInt(145); // Generate a number between 0 and 144
                opIndex = rand.nextInt(4)+2;
                break;
        }
        operator = operators[opIndex];

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
                        b = rand.nextInt(a + 1); // Generate a number between 0 and a
                    }
                    answer = a / b;
                } else {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operator. Must be '+', '-', '*', '/'");
        }
        generateOptions();
    }


    //protected void generateArithmeticProblem(int level) {
    public static ArithmeticProblems generateArithmeticProblems(int level){
        ArithmeticProblems problem = new ArithmeticProblems(level);
        return problem;
    }

    @Override
    public String getProblem() {
        String displayOperator = operator;
        if (operator.equals("/")) {
            displayOperator = "÷";
        }
        return a + " " + displayOperator + " " + b + " = ";
    }

    protected void generateOptions() {
        Random rand = new Random();
        options = new HashMap<>();
        for (char option = 'a'; option <= 'd'; option++) {
            options.put(String.valueOf(option), answer + rand.nextInt(10) + 1);
        }
        correctOption = String.valueOf((char) ('a' + rand.nextInt(4)));
        options.put(correctOption, answer);
    }

    // Implementing the abstract method from MathProblems
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