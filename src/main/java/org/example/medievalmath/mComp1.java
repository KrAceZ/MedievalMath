//package org.example.medievalmath;
//
//import java.util.*;
//
//public class mComp1 {
//    public static class mComp1a extends MathProblems {
//
//
//        public mComp1a(String competencyCode) {
//            super(1, "1a"); // Call the superclass constructor
//            Random rand = new Random();
//            this.a = rand.nextInt(21);   // choose random 'a' value (0 - 20)
//            this.b = rand.nextInt(21);   // choose random 'b' value (0 - 20)
//            this.operator = rand.nextBoolean() ? "+" : "-"; // randomly choose between addition and subtraction
//            // calculates correct answer depending on problem type
//            switch (operator) {
//                case "+":
//                    this.answer = Math.min(a + b, 20); // Ensure answer is not greater than 20
//                    break;
//                case "-":
//                    this.answer = Math.max(a - b, 0); // Ensure answer is not less than 0
//                    break;
//                default:
//                    // exception to force an operator
//                    throw new IllegalArgumentException("Invalid operator. Operator must be one of '+', '-'.");
//            }
//            generateOptions();  // Call generateOptions at the end of the constructor
//        }
//
//        @Override
//        protected void generateOptions() {
//            Random rand = new Random();
//            options = new HashMap<>();
//            Set<Integer> generatedOptions = new HashSet<>();
//            for (char option = 'a'; option <= 'd'; option++) {
//                int optionValue;
//                do {
//                    optionValue = answer + rand.nextInt(5) - 2;
//                } while (generatedOptions.contains(optionValue));
//                generatedOptions.add(optionValue);
//                options.put(String.valueOf(option), optionValue);
//            }
//            correctOption = String.valueOf((char) ('a' + rand.nextInt(4)));
//            options.put(correctOption, answer);
//        }
//
//        @Override
//        protected void generateProblem() {
//
//        }
//
//        @Override
//        public String getProblem() {
//            return a + " " + operator + " " + b + " = ";
//        }
//
//        @Override
//        public boolean checkAnswer(String userOption) {
//            return userOption.equals(correctOption);
//        }
//    }
//
//    // Level 1 Sublevel B
//    public static class mComp1b extends MathProblems {
//        private final List<Integer> sequence;
//        private final int missingNumberIndex;
//        private final int missingNumber;
//        private static final Set<String> generatedProblems = new HashSet<>();
//
//        public mComp1b() {
//            super(1, "1b"); // Call the superclass constructor
//            Random rand = new Random();
//            int start;
//            do {
//                start = rand.nextInt(116); // Start of the sequence
//            } while (generatedProblems.contains(String.valueOf(start)));
//            generatedProblems.add(String.valueOf(start));
//            sequence = new ArrayList<>();
//            for (int i = 0; i < 5; i++) {
//                sequence.add(start + i);
//            }
//            missingNumberIndex = rand.nextInt(5);
//            missingNumber = sequence.get(missingNumberIndex);
//            sequence.set(missingNumberIndex, null); // Set the missing number to null
//            generateOptions();
//            generatedProblems.clear();
//        }
//
//        @Override
//        protected void generateOptions() {
//            Random rand = new Random();
//            options = new HashMap<>();
//            Set<Integer> generatedOptions = new HashSet<>();
//            for (char option = 'a'; option <= 'd'; option++) {
//                int optionValue;
//                do {
//                    optionValue = missingNumber + rand.nextInt(11); // Ensure non-negative options
//                } while (generatedOptions.contains(optionValue));
//                generatedOptions.add(optionValue);
//                options.put(String.valueOf(option), optionValue);
//            }
//            correctOption = String.valueOf((char) ('a' + rand.nextInt(4)));
//            options.put(correctOption, missingNumber);
//        }
//
//        @Override
//        protected void generateProblem() {
//
//        }
//
//        @Override
//        public String getProblem() {
//            StringBuilder problem = new StringBuilder();
//            for (int i = 0; i < 5; i++) {
//                if (i == missingNumberIndex) {
//                    problem.append("_ ");
//                } else {
//                    problem.append(sequence.get(i)).append(" ");
//                }
//            }
//            return problem.toString();
//        }
//
//        @Override
//        public boolean checkAnswer(String userOption) {
//            return userOption.equals(correctOption);
//        }
//    }
//
//    // Level 1 Sublevel C
//    public static class mComp1c extends MathProblems {
//        public mComp1c() {
//            super(1, "1c"); // Call the superclass constructor
//            Random rand = new Random();
//            this.a = rand.nextInt(90) + 10; // Generate a two-digit number (10 to 99)
//            // Determine whether the digit represents tens or ones
//            this.operator = (rand.nextBoolean()) ? "tens" : "ones";
//            // Calculate the correct answer based on the operator
//            this.answer = (operator.equals("tens")) ? a / 10 : a % 10;
//            // Call generateOptions() at the end of the constructor
//            generateOptions();
//        }
//
//        @Override
//        protected void generateOptions() {
//            options = new HashMap<>();
//            options.put("a", (operator.equals("tens")) ? a / 10 : a % 10);
//            options.put("b", (operator.equals("tens")) ? a % 10 : a / 10);
//            correctOption = (operator.equals("tens")) ? "a" : "b";
//        }
//
//        @Override
//        protected void generateProblem() {
//
//        }
//
//        @Override
//        public String getProblem() {
//            return "In the number " + a + ", does the digit '" + ((operator.equals("tens")) ? a / 10 : a % 10) + "' represent tens or ones?";
//        }
//
//        @Override
//        public boolean checkAnswer(String userOption) {
//            return userOption.equals(correctOption);
//        }
//    }
//}
