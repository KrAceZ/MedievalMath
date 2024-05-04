package org.example.medievalmath;

import java.util.*;

public class CountingProblems extends MathProblems {
    private final List<Integer> sequence;
    private final int missingNumberIndex;
    private final int missingNumber;
    private static final Set<String> generatedProblems = new HashSet<>();

    public CountingProblems(int level, String competency) {
        super(level, competency);
        Random rand = new Random();
        int start;
        do {
            start = rand.nextInt(116); // Start of the sequence
        } while (generatedProblems.contains(String.valueOf(start)));
        generatedProblems.add(String.valueOf(start));
        sequence = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sequence.add(start + i);
        }
        missingNumberIndex = rand.nextInt(5);
        missingNumber = sequence.get(missingNumberIndex);
        sequence.set(missingNumberIndex, null); // Set the missing number to null
        generateOptions();
    }

    @Override
    protected void generateProblem() {
        // Problem generation logic
        StringBuilder problem = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < sequence.size(); i++) {
            if (i == missingNumberIndex) {
                problem.append("_ ");
            } else {
                problem.append(sequence.get(i)).append(" ");
            }
        }
        this.problem = problem.toString(); // Store the problem as a class variable
    }

    @Override
    public String getProblem() {
        StringBuilder problem = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (i == missingNumberIndex) {
                problem.append("_ ");
            } else {
                problem.append(sequence.get(i)).append(" ");
            }
        }
        return problem.toString();
    }

    @Override
    public void generateOptions() {
        Random rand = new Random();
        options = new HashMap<>();
        Set<Integer> generatedOptions = new HashSet<>();
        for (char option = 'a'; option <= 'd'; option++) {
            int optionValue;
            do {
                optionValue = missingNumber + rand.nextInt(5) - 2;
            } while (generatedOptions.contains(optionValue));
            generatedOptions.add(optionValue);
            options.put(String.valueOf(option), optionValue);
        }
        correctOption = String.valueOf((char) ('a' + rand.nextInt(4)));
        options.put(correctOption, missingNumber);
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
}