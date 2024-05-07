package org.example.medievalmath;

import java.util.List;

public class Quiz {
    // List of MathProblems objects that make up the quiz
    public List<MathProblems> problems;
    public static MathProblems problem;
    // Index of the current problem being displayed
    public String type;
    public int numOfProblems;
    public int currentProblemIndex = 0; // To keep track of the current problem being displayed

    // Constructor that initializes the problems list and sets the current problem index to 0
//    public Quiz(List<MathProblems> problems) {   // constructor now takes MathProblems objects and no longer takes ProblemSet object
//        this.problems = problems;
//        this.currentProblemIndex = 0;
//    }

    public Quiz(String type, int numOfProblems) {   // constructor now takes MathProblems objects and no longer takes ProblemSet object
        this.type = type;
        this.numOfProblems = numOfProblems;
        this.currentProblemIndex = 0;
    }
    // Method to get the current problem
    public MathProblems getCurrentProblem() {
        // checks if problem index is valid
//        if (currentProblemIndex >= 0 && currentProblemIndex < problems.size()) {
        if (currentProblemIndex >= 0 && currentProblemIndex < numOfProblems) {

            // returns current problem
            //return problems.get(currentProblemIndex);
            return problem;
        } else {
            // null if no more problems left or invalid current index
            return null;
        }
    }

    // Method to check the answer for the current problem
    /*public boolean checkAnswer(String userAnswer) {
        MathProblems currentProblem = getCurrentProblem();
        // check if current problem index is valid
        if (currentProblem != null) {
            // check user's answer then return results
            return currentProblem.checkAnswer(Integer.parseInt(userAnswer));    // convert String to int
        } else {
            // false if no problem to check
            return false; // No current problem to check
        }
    }*/

    //**********************************************
    public boolean checkAnswer(String userAnswer) {
        MathProblems currentProblem = getCurrentProblem();
        // check if current problem index is valid
        if (currentProblem != null) {
            // check user's answer then return results
            return currentProblem.checkAnswer(userAnswer);    // convert String to int
        } else {
            // false if no problem to check
            return false; // No current problem to check
        }
    }
    //**********************************************
    // Method to move to the next problem
    public void moveToNextProblem() {
        System.out.println(currentProblemIndex);

        currentProblemIndex++;
        System.out.println(currentProblemIndex);
    }

    // Method to check if the quiz has ended
    public boolean isQuizEnd() {
        //return currentProblemIndex >= problems.size();
        return currentProblemIndex >= numOfProblems;
    }
}
