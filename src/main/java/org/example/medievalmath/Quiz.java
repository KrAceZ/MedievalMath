package org.example.medievalmath;

import java.util.List;

public class Quiz {
    // List of MathProblem objects that make up the quiz
    private List<MathProblem> problems;
    // Index of the current problem being displayed
    private int currentProblemIndex; // To keep track of the current problem being displayed

    // Constructor that initializes the problems list and sets the current problem index to 0
    public Quiz(List<MathProblem> problems) {   // constructor now takes MathProblem objects and no longer takes ProblemSet object
        this.problems = problems;
        this.currentProblemIndex = 0;
    }

    // Method to get the current problem
    public MathProblem getCurrentProblem() {
        // checks if problem index is valid
        if (currentProblemIndex >= 0 && currentProblemIndex < problems.size()) {
            // returns current problem
            return problems.get(currentProblemIndex);
        } else {
            // null if no more problems left or invalid current index
            return null;
        }
    }

    // Method to check the answer for the current problem
    public boolean checkAnswer(String userAnswer) {
        MathProblem currentProblem = getCurrentProblem();
        // check if current problem index is valid
        if (currentProblem != null) {
            // check user's answer then return results
            return currentProblem.checkAnswer(Integer.parseInt(userAnswer));    // convert String to int
        } else {
            // false if no problem to check
            return false; // No current problem to check
        }
    }

    // Method to move to the next problem
    public void moveToNextProblem() {
        currentProblemIndex++;
    }

    // Method to check if the quiz has ended
    public boolean isQuizEnd() {
        return currentProblemIndex >= problems.size();
    }
}
