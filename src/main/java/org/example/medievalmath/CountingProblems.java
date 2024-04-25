package org.example.medievalmath;

import java.util.*;

public class CountingProblems extends MathProblems {
    private final List<Integer> sequence;
    private final int missingNumberIndex;
    private final int missingNumber;
    private static final Set<String> generatedProblems = new HashSet<>();

    public CountingProblems(int level) {
        super("+", level); // Call the superclass constructor
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
    void generateOptions() {
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
    public boolean checkAnswer(String userOption) {
        return userOption.equals(correctOption);
    }
}