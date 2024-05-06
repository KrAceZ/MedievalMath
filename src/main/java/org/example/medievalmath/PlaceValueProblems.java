package org.example.medievalmath;

import java.util.*;

public class PlaceValueProblems extends MathProblems {
    private int number;
    private int digit;
    private static String placeValue;
    private static final List<String> PLACE_VALUES = Arrays.asList("Ones", "Tens", "Hundreds", "Thousands", "Ten Thousands", "Hundred Thousands", "Millions");

    public PlaceValueProblems(int level) {
        super(level);
        generateProblem();
    }

    protected void generateProblem() {
        Random rand = new Random();
        number = rand.nextInt((int) Math.pow(10, level + 1)); // Generate a number up to the maximum for the level
        int place = rand.nextInt(level * 2); // Randomly choose a place value based on the level
        digit = (number / (int) Math.pow(10, place)) % 10;
        placeValue = PLACE_VALUES.get(place);
        generateOptions();
    }

    @Override
    public String getProblem() {
        return "Is this the number " + digit + " in the number " + number + " part of the " + placeValue + "?";
    }

    protected static void generateOptions() {
        options = new HashMap<>();
        List<String> choices = new ArrayList<>(PLACE_VALUES.subList(0, Math.min(level * 2, 7))); // Get possible place values based on the level
        choices.remove(placeValue); // Remove the correct answer from the choices
        Collections.shuffle(choices); // Shuffle the choices
        choices = choices.subList(0, 3); // Get the first 3 choices
        choices.add(placeValue); // Add the correct answer to the choices
        Collections.shuffle(choices); // Shuffle the choices again
        for (int i = 0; i < 4; i++) {
            options.put(String.valueOf((char) ('a' + i)), Integer.valueOf(choices.get(i)));
        }
        correctOption = String.valueOf((char) ('a' + choices.indexOf(placeValue)));
    }

    @Override
    public String getOption(String key) {
        return String.valueOf(options.get(key));
    }
}