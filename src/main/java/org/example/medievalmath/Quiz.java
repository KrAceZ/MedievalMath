package org.example.medievalmath;
import java.util.List;

public class Quiz {
    private List<MathProblem> problems;
    private int currentProblemIndex; // To keep track of the current problem being displayed

    public Quiz(List<MathProblem> problems) {
        this.problems = problems;
        this.currentProblemIndex = 0; // Start from the first problem
    }

    // Method to load quiz data from a ProblemSet object
    public void loadQuizData(ProblemSet problemSet) {
        this.problems = problemSet.getProblems();
        this.currentProblemIndex = 0; // Reset current index to start from the first problem
    }

    // Method to get the current problem
    public MathProblem getCurrentProblem() {
        if (currentProblemIndex >= 0 && currentProblemIndex < problems.size()) {
            return problems.get(currentProblemIndex);
        } else {
            return null; // No more problems left or invalid current index
        }
    }

    // Method to check the answer for the current problem
    public boolean checkAnswer(String userAnswer) {
        MathProblem currentProblem = getCurrentProblem();
        if (currentProblem != null) {
            return currentProblem.checkAnswer(userAnswer);
        } else {
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
