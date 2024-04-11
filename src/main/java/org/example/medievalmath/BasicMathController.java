package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.util.Random;
public class BasicMathController {
    @FXML
    private Label problemLabel;

    @FXML
    private TextField answerField;

    private int a;
    private int b;
    private String operator;
    private int answer;

    @FXML
    public void initialize() {
        generateProblem();
    }

    private void generateProblem() {
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
        problemLabel.setText(getProblem());
    }

    private String getProblem() {
        return a + " " + operator + " " + b + " = ";
    }

    @FXML
    private void checkAnswer(ActionEvent event) {
        int userAnswer = Integer.parseInt(answerField.getText());
        if (userAnswer == answer) {
            // Correct answer, generate new problem
            generateProblem();
        } else {
            // Incorrect answer, show some message
        }
    }

}

