package org.example.medievalmath;

import java.util.*;

public class FractionProblems extends MathProblems {
    private static int numerator;
    private static int denominator;

    private static final List<Integer> denominatorsLevel2 = Arrays.asList(2, 3, 4, 6, 8);
    private static final List<Integer> denominatorsLevel3 = Arrays.asList(2, 3, 4, 5, 6, 8, 10, 12, 100);

    public FractionProblems(int level) {
        super(level);
        generateFractionProblem();
    }

    private void generateFractionProblem() {
        Random rand = new Random();
        List<Integer> denominators = (level == 2) ? denominatorsLevel2 : denominatorsLevel3;
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

    private void generateIdentifyFractionProblem() {
        correctOption = numerator + "/" + denominator;
        options = new HashMap<>();
        options.put("a", (numerator + "/" + denominator));
        options.put("b", ((numerator % 2 + 1) + "/" + denominator));
        options.put("c", (numerator + "/" + (denominator % 2 + 1)));
        options.put("d", ((numerator % 2 + 1) + "/" + (denominator % 2 + 2)));
    }

    private void generateComparisonProblem() {
        int otherNumerator = numerator + 1 + new Random().nextInt(denominator - 1);
        otherNumerator = (otherNumerator > denominator) ? otherNumerator % denominator : otherNumerator;
        String firstFraction = numerator + "/" + denominator;
        String secondFraction = otherNumerator + "/" + denominator;
        correctOption = (numerator > otherNumerator) ? "a" : "b";
        options = new HashMap<>();
        options.put("a", firstFraction);
        options.put("b", secondFraction);
        options.put("c", (numerator + "/" + (denominator + 1)));
        options.put("d", (numerator - 1) + "/" + denominator);
    }

    private void generateAdditionSubtractionProblem() {
        int addendNumerator = new Random().nextInt(denominator - 1) + 1;
        int resultNumerator = numerator + addendNumerator;
        correctOption = resultNumerator + "/" + denominator;
        options = new HashMap<>();
        options.put("a", (correctOption));
        options.put("b", addendNumerator + "/" + denominator);
        options.put("c", (numerator - addendNumerator) + "/" + denominator);
        options.put("d", (numerator * 2) + "/" + denominator);
    }

    private void generateMultiplicationProblem() {
        int multiplier = new Random().nextInt(4) + 1;  // Multiplier between 1 and 4
        int resultNumerator = numerator * multiplier;
        correctOption = resultNumerator + "/" + denominator;
        options = new HashMap<>();
        options.put("a", (correctOption));
        options.put("b", numerator + "/" + denominator);
        options.put("c", (numerator * 2) + "/" + denominator);
        options.put("d", (numerator - 1) + "/" + denominator);
    }

    @Override
    public String getProblem() {
        return "Solve the fraction problem: " + correctOption;
    }


    protected void generateOptions() {
        // Options are generated in specific problem methods
        switch (level) {
            case 2:
            case 3:
                generateIdentifyFractionProblem();
                break;
            // Add cases for other levels if needed
        }
    }

    @Override
    public String getOption(String key) {
        String optionValue = String.valueOf(options.get(key));
        if (optionValue != null) {
            return optionValue;
        } else {
            return null; // Or handle the case when the key is not found
        }
    }

    // Additional getters for pie chart visualization
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}