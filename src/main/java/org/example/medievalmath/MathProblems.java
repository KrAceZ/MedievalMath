package org.example.medievalmath;

import java.util.*;

// General class to define the structure of math problems
public abstract class MathProblems<T> {
    protected static int level;
    protected Map<String, T> options;
    protected static String correctOption;
    protected String problem;


    public MathProblems(int level) {
        MathProblems.level = level;
        //this.competency = competency;
    }

    // Abstract method to display the problem as a string
    abstract public String getProblem();

    // Abstract method to generate multiple choice options
    protected void generateOptions() {
    }

    // Abstract method to get an option by its key
    public String getOption(String option){
        if (!options.containsKey(option)) {
            throw new IllegalArgumentException("Option must be one of 'a', 'b', 'c', 'd'.");
        }
        return  options.get(option).toString();
    }

    // Method to check if the user's answer is correct
    public boolean checkAnswer(String userOption) {
        return userOption.equals(correctOption);
    }

    // Getter for the problem level
    public int getLevel() {
        return level;
    }

    @Override
    public String toString()
    {
        return getProblem();
    }
}