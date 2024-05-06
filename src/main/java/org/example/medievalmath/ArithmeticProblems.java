package org.example.medievalmath;

import java.util.HashMap;
import java.util.Random;

public class ArithmeticProblems extends MathProblems {
    private static int a, b;
    private static String operator;
    private static int answer;

    public ArithmeticProblems(int level) {
        super(level);
//        if (level == 1 && !operator.equals("+") && !operator.equals("-")) { // restricts level 1 to + and - problems
//            throw new IllegalArgumentException("For level 1, operator must be '+' or '-'");
//        }
//        this.operator = operator;
        generateArithmeticProblem(level);
    }


    protected static void generateArithmeticProblem(int level) {
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

    @Override
    public String getProblem() {
        return a + " " + operator + " " + b + " = ";
    }

    protected static void generateOptions() {
        Random rand = new Random();
        options = new HashMap<>();
        for (char option = 'a'; option <= 'd'; option++) {
            options.put(String.valueOf(option), answer + rand.nextInt(10) + 1);
        }
        correctOption = String.valueOf((char) ('a' + rand.nextInt(4)));
        options.put(correctOption, answer);
    }

    // Implementing the abstract method from MathProblems
//    @Override
//    protected String getOption(String key) {
//        Integer optionValue = options.get(key);
//        if (optionValue != null) {
//            return String.valueOf(optionValue);
//        } else {
//            return null; // Or handle the case when the key is not found
//        }
//    }
}