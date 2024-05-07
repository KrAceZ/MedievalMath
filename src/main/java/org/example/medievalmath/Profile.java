package org.example.medievalmath;

public class Profile {
    private String studentName;
    public static int grade;

    private String username;
    private String password;
    public static int points;

    // Constructor to initializes the instance variables
    public Profile(String studentName, String username, int grade, int points) {
        this.studentName = studentName;
        this.username = username;
        this.grade = grade;
        this.points = points;
        //this.password = password;
    }

    // Getters
    // Student's name
    public String getStudentName() {
        return studentName;
    }

    // Student's Grade
    public int getGrade() {
        return grade;
    }

    // Student's username
    public String getUsername() {
        return username;
    }

    // Student's password
    public String getPassword() {
        return password;
    }

    // Method to get the level based on the student's grade
    public static int getLevel() {
        if (grade == 0 || grade == 1) {
            return 1;   // level 1 for grades k and 1
        } else if (grade == 2 || grade == 3) {
            return 2;   // level 2 for grades 2 and 3
        } else if (grade == 4) {
            return 3;   // level 3 for grade 4
        } else {
            throw new IllegalArgumentException("Invalid grade. Grade must be between 0 and 4.");
        }
    }
}
