package org.example.medievalmath;

import java.util.*;

public class FractionProblems extends MathProblems {
    private static int numerator;
    private static int denominator;

    private static final List<Integer> denominators = Arrays.asList(2, 3, 4, 6, 8, 10, 12, 100);

    public FractionProblems(int level, String competency) {
        super(level, competency);
        generateFractionProblem();
    }

    public static void generateFractionProblem() {
        Random rand = new Random();
        denominator = denominators.get(rand.nextInt(denominators.size()));
        numerator = rand.nextInt(denominator) + 1;

        int type = rand.nextInt(4);  // Choose problem type
        switch (type) {
            case 0:
                generateIdentifyFractionProblem();
                break;
            case 1:
                generateComparisonProblem();
                break;
            case 2:
                generateAdditionSubtractionProblem();
                break;
            case 3:
                generateMultiplicationProblem();
                break;
        }
    }

    private static void generateIdentifyFractionProblem() {
        correctOption = numerator + "/" + denominator;
        options = new HashMap<>();
        options.put("a", Integer.valueOf(correctOption));
        options.put("b", Integer.valueOf((numerator % 2 + 1) + "/" + denominator));
        options.put("c", Integer.valueOf(numerator + "/" + (denominator % 2 + 1)));
        options.put("d", Integer.valueOf((numerator % 2 + 1) + "/" + (denominator % 2 + 2)));
    }

    private static void generateComparisonProblem() {
        int otherNumerator = numerator + 1 + new Random().nextInt(denominator - 1);
        otherNumerator = (otherNumerator > denominator) ? otherNumerator % denominator : otherNumerator;
        String firstFraction = numerator + "/" + denominator;
        String secondFraction = otherNumerator + "/" + denominator;
        correctOption = (numerator > otherNumerator) ? "a" : "b";
        options = new HashMap<>();
        options.put("a", Integer.valueOf(firstFraction));
        options.put("b", Integer.valueOf(secondFraction));
        options.put("c", Integer.valueOf(numerator + "/" + (denominator + 1)));
        options.put("d", Integer.valueOf((numerator - 1) + "/" + denominator));
    }

    private static void generateAdditionSubtractionProblem() {
        // Simplify by keeping the denominator same for addition/subtraction
        int addendNumerator = new Random().nextInt(denominator - 1) + 1;
        int resultNumerator = numerator + addendNumerator;
        correctOption = resultNumerator + "/" + denominator;
        options = new HashMap<>();
        options.put("a", Integer.valueOf(correctOption));
        options.put("b", Integer.valueOf(addendNumerator + "/" + denominator));
        options.put("c", Integer.valueOf((numerator - addendNumerator) + "/" + denominator));
        options.put("d", Integer.valueOf((numerator * 2) + "/" + denominator));
    }

    private static void generateMultiplicationProblem() {
        int multiplier = new Random().nextInt(4) + 1;  // Multiplier between 1 and 4
        int resultNumerator = numerator * multiplier;
        correctOption = resultNumerator + "/" + denominator;
        options = new HashMap<>();
        options.put("a", Integer.valueOf(correctOption));
        options.put("b", Integer.valueOf(numerator + "/" + denominator));
        options.put("c", Integer.valueOf((numerator * 2) + "/" + denominator));
        options.put("d", Integer.valueOf((numerator - 1) + "/" + denominator));
    }

    @Override
    public String getProblem() {
        return "Solve the fraction problem: " + correctOption;
    }


    public static void generateOptions () {
        // Options are generated in specific problem methods
        // finish this
    }

    @Override
    protected String getOption(String key) {
        Integer optionValue = options.get(key);
        if (optionValue != null) {
            return String.valueOf(optionValue);
        } else {
            return null; // Or handle the case when the key is not found
        }
    }

    @Override
    public boolean checkAnswer(String userOption) {
        return userOption.equals(correctOption);
    }

    // Additional getters for pie chart visualization
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
