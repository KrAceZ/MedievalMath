package org.example.medievalmath;

import java.util.List;
import java.util.ArrayList;

import static org.example.medievalmath.ArithmeticProblems.generateArithmeticProblem;
import static org.example.medievalmath.CountingProblems.generateCountingProblem;
import static org.example.medievalmath.FractionProblems.generateFractionProblem;
import static org.example.medievalmath.PlaceValueProblems.generatePlaceValueProblem;

public class QuizTypeDecider
{
    private static int numberOfProblems;
    private static String competency;
    private static int level;

    public static void setNumberOfProblems(int numOfProbs) {
        numberOfProblems = numOfProbs;
    }

    public static void setCompetency(String comp) {
        competency = comp;
    }
    // Method to create a list of problems based on the input parameters
    public static List<MathProblems> generateProblems(String competency, int numOfProblems) {
        level = Profile.getLevel();
        List<MathProblems> problems = new ArrayList<>();
        for (int i = 0; i < numOfProblems; i++) {
            switch (competency) {
                case "a":
                    problems.add(generateArithmeticProblem(level));
                    break;
                case "b":
                    if(level == 1) {
                        problems.add(generateCountingProblem());
                    }
                    else{
                        problems.add(generateFractionProblem());
                    }
                    break;
                case "c":
                    problems.add(generatePlaceValueProblem());
                    break;
            }
        }
        return problems;
    }

    // Helper method to determine which operator to use based on level (for arithmetic problems)
//    private static String determineOperator(int level) {
//        if (level == 1) return "+";
//        else if (level == 2) return "-";
//        else if (level == 3) return "*";
//        else return "/";
//    }
}