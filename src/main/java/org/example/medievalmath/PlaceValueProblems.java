package org.example.medievalmath;

import java.util.HashMap;
import java.util.Random;

public class PlaceValueProblems extends MathProblems {
    private static int number;
    private static int digit;
    private static String placeValue;

    public PlaceValueProblems(int level) {
        super(level);
        generatePlaceValueProblem();
    }

    protected static void generatePlaceValueProblem() {
        Random rand = new Random();
        number = rand.nextInt(90) + 10; // Generate a number between 10 and 99
        boolean chooseTensPlace = rand.nextBoolean(); // Randomly choose tens or ones place
        if (chooseTensPlace) {
            digit = number / 10;
            placeValue = "Tens";
        } else {
            digit = number % 10;
            placeValue = "Ones";
        }
        generateOptions();
    }

    @Override
    public String getProblem() {
        return "Is this the number " + digit + " in the number " + number + " part of the Ones or the Tens?";
    }

    protected static void generateOptions() {
        options = new HashMap<>();
        options.put("Ones", Integer.valueOf("Ones"));
        options.put("Tens", Integer.valueOf("Tens"));
        correctOption = placeValue;
    }

//    @Override
//    protected String getOption(String key) {
//        return String.valueOf(options.get(key));
//    }
}