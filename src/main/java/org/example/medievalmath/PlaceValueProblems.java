package org.example.medievalmath;

import java.util.*;

public class PlaceValueProblems extends MathProblems<String> {
    private int number;
    private int digit;
    private static String placeValue;
    private static final List<String> PLACE_VALUES = Arrays.asList("Ones", "Tens", "Hundreds",
            "Thousands", "Ten Thousands", "Hundred Thousands", "Millions");

    public PlaceValueProblems(int level) {
        super(level);
        generatePlaceValueProblem();
    }

    protected void generatePlaceValueProblem() {
        Random rand = new Random();
        int maxNumber;
        int maxPlace;
        switch (level) {
            case 1:
                maxNumber = 99; // Maximum number for level 1 is 99
                maxPlace = 2; // Maximum place for level 1 is Tens
                break;
            case 2:
                maxNumber = 999; // Maximum number for level 2 is 999
                maxPlace = 3; // Maximum place for level 2 is Hundreds
                break;
            default:
                maxNumber = (int) Math.pow(10, level + 1); // For other levels, use the existing logic
                maxPlace = level * 2;
        }
        number = rand.nextInt(maxNumber) + 1; // Generate a number up to the maximum for the level
        int place = rand.nextInt(maxPlace); // Randomly choose a place value based on the level
        digit = (number / (int) Math.pow(10, place)) % 10;
        placeValue = PLACE_VALUES.get(place);
        generateOptions();
    }

    @Override
    public String getProblem() {
        return "What is the place value of the " + digit + " in the number " + number + "?";
    }

    protected void generateOptions() {
        options = new LinkedHashMap<>();
        Random rand = new Random();
        // Get possible place values based on the level
        List<String> choices = new ArrayList<>(PLACE_VALUES.subList(0, Math.min(level * 2, PLACE_VALUES.size())));
        choices.remove(placeValue); // Remove the correct answer from the choices
        Collections.shuffle(choices); // Shuffle the choices
        choices = choices.subList(0, Math.min(3, choices.size())); // Get the first 3 choices or less if there are fewer than 3 choices

        // Add the correct answer to the choices
        choices.add(placeValue);

        // Shuffle the choices
        Collections.shuffle(choices);

        // Map options to characters (a, b, c, d)
        for (int i = 0; i < 4; i++) {
            if (i < choices.size()) {
                options.put(String.valueOf((char) ('a' + i)), choices.get(i));
            }
        }
        correctOption = String.valueOf((char) ('a' + choices.indexOf(placeValue)));
    }

    @Override
    public String getOption(String key) {
        String optionValue = options.get(key);
        if (optionValue != null) {
            // Convert the integer option value back to a string
            return optionValue;
        } else {
            return null; // Or handle the case when the key is not found
        }
    }
}