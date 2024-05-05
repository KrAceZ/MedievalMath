package org.example.medievalmath;

import java.util.List;
import java.util.ArrayList;

public class QuizTypeDecider
{
    // Method to create a list of problems based on the input parameters
    public static List<MathProblems> generateProblems(String competency, int level, int numOfProblems) {
        List<MathProblems> problems = new ArrayList<>();
        for (int i = 0; i < numOfProblems; i++) {
            switch (competency) {
                case "arithmetic":
                    problems.add(new ArithmeticProblems(determineOperator(level), level, competency));
                    break;
                case "fractions":
                    problems.add(new FractionProblems(level, competency));
                    break;
                case "counting":
                    problems.add(new CountingProblems(level, competency));
                    break;
                case "values":
                    problems.add(new PlaceValueProblems(level, competency));
                    break;
                // Add cases for other competencies
            }
        }
        return problems;
    }

    // Helper method to determine which operator to use based on level (for arithmetic problems)
    private static String determineOperator(int level) {
        if (level == 1) return "+";
        else if (level == 2) return "-";
        else if (level == 3) return "*";
        else return "/";
    }
}