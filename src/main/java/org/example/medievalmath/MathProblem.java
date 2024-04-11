package org.example.medievalmath;

import java.util.Random;

public class MathProblem {
    private int a;
    private int b;
    private String operator;
    private int answer;

    public MathProblem() {
        Random rand = new Random();
        this.a = rand.nextInt(11);
        this.b = rand.nextInt(11);
        int operatorIndex = rand.nextInt(4);
        switch (operatorIndex) {
            case 0:
                this.operator = "+";
                this.answer = a + b;
                break;
            case 1:
                this.operator = "-";
                this.answer = a - b;
                break;
            case 2:
                this.operator = "*";
                this.answer = a * b;
                break;
            case 3:
                this.operator = "/";
                if (b != 0) {
                    this.answer = a / b;
                } else {
                    this.answer = Integer.MAX_VALUE; // to handle division by 0.
                    // maybe change to message like "can't divide by 0"
                }
                break;
        }
    }

    public String getProblem() {
        return a + " " + operator + " " + b + " = ";
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == answer;
    }
}
