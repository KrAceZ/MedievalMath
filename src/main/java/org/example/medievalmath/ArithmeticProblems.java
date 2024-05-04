package org.example.medievalmath;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ArithmeticProblems extends MathProblems {
    private int a, b;
    private final String operator;
    private int answer;

    public ArithmeticProblems(String operator, int level, String competency) {
        super(level, competency);
        this.operator = operator;
        generateProblem();
    }

    @Override
    protected void generateProblem() {
        Random rand = new Random();
        a = (level == 1) ? rand.nextInt(11) : rand.nextInt(21) - 10;
        b = (level == 1) ? rand.nextInt(a + 1) : rand.nextInt(21) - 10;
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

    @Override
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
    protected String getOption(String key) {
        Integer optionValue = options.get(key);
        if (optionValue != null) {
            return String.valueOf(optionValue);
        } else {
            return null; // Or handle the case when the key is not found
        }
    }
}
