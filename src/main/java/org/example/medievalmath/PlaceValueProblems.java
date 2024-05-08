package org.example.medievalmath;

import java.util.*;

public class PlaceValueProblems extends MathProblems<String> {
    private int number;
    private int digit;
    private static List<String> correctAnswers;
    private static final List<String> PLACE_VALUES = Arrays.asList("Ones", "Tens", "Hundreds",
            "Thousands", "Ten Thousands", "Hundred Thousands", "Millions");

    public PlaceValueProblems(int level) {
        super(level);
        generatePlaceValueProblem();
    }

    protected void generatePlaceValueProblem() {
        Random rand = new Random();
        int maxNumber;
        int maxPlace = switch (level) {
            case 1 -> {
                maxNumber = 99; // Maximum number for level 1 is 99
                yield 2; // Maximum place for level 1 is Tens
            }
            case 2 -> {
                maxNumber = 999; // Maximum number for level 2 is 999
                yield 3; // Maximum place for level 2 is Hundreds
            }
            case 3 -> {
                maxNumber = 9999999; // Maximum number for level 3 is 9,999,999
                yield 7; // Maximum place for level 3 is Millions
            }
            default -> throw new IllegalArgumentException("Unsupported level: " + level);
        };

        // Set the appropriate limits based on the level

        number = rand.nextInt(maxNumber) + 1; // Generate a number up to the maximum for the level
        int place;
        do {
            place = rand.nextInt(maxPlace); // Randomly choose a place value based on the level
            digit = (number / (int) Math.pow(10, place)) % 10;
        } while (digit == 0); // Repeat until a non-zero digit is found

        generateOptions(maxPlace);
    }

    @Override
    public String getProblem() {
        return "What is the place value of the " + digit + " in the number " + number + "?";
    }

    protected void generateOptions(int maxPlace) {
        options = new LinkedHashMap<>();
        List<String> allCorrectAnswers = new ArrayList<>();

        // Identify all occurrences of the digit and their respective place values
        int remainingNumber = number;
        int placeIndex = 0;
        while (remainingNumber > 0) {
            int currentDigit = remainingNumber % 10;
            if (currentDigit == digit && placeIndex < PLACE_VALUES.size()) {
                allCorrectAnswers.add(PLACE_VALUES.get(placeIndex));
            }
            remainingNumber /= 10;
            placeIndex++;
        }
        correctAnswers = allCorrectAnswers;

        // Get possible place values based on the level
        List<String> choices = new ArrayList<>(PLACE_VALUES.subList(0, maxPlace));
        choices.removeAll(correctAnswers); // Remove all correct answers from the choices
        Collections.shuffle(choices); // Shuffle the choices
        choices = choices.subList(0, Math.min(3, choices.size())); // Get the first 3 choices or fewer

        // Add all the correct answers back to the choices
        choices.addAll(correctAnswers);
        Collections.shuffle(choices);

        // Map options to characters (a, b, c, d)
        for (int i = 0; i < 4; i++) {
            String key = String.valueOf((char) ('a' + i));
            if (i < choices.size()) {
                options.put(key, choices.get(i));
            } else {
                options.put(key, "N/A"); // Placeholder for missing options
            }
        }
    }

    @Override
    public String getOption(String key) {
        return options.getOrDefault(key, "N/A");
    }

    @Override
    public boolean checkAnswer(String userOption) {
        String selectedAnswer = options.get(userOption);
        return correctAnswers.contains(selectedAnswer);
    }
}