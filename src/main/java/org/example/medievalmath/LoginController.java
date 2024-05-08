package org.example.medievalmath;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;


import javafx.scene.paint.Color;

import javax.swing.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class LoginController {
    // Define the FXML elements as private instance variables
    @FXML
    private Label loginLabel;
    @FXML
    private TextField nameField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField gradeField;
    @FXML
    private CheckBox showPasswordCheckBox;
    @FXML
    private Hyperlink switchLink;
    @FXML
    private Label errorLabel;
    @FXML
    private ImageView backgroundImageView;
    @FXML
    private Button createAccountButton;
    @FXML
    private Button loginButton;
    public static int currentGrade;
    public static int currentPoints;

    private String username;


    public static String currentUsername;
    public static String currentStudentName;
    public static int currentUserID;
    public static Map<Integer, String> videoURLs = new HashMap<>();


    // Method to handle the action of the switch link
    @FXML
    protected void handleSwitchLink(ActionEvent event) {
        // If the current view is "Login"
        if (loginLabel.getText().equals("Login")) {
            // Change the view to "Create a new account"

            loginLabel.setText("Create a new account");
            loginLabel.setTextFill(Color.WHITE);

            loginLabel.setText(""); // FIX THIS

            switchLink.setText("Login as a returning user");
            // Hide the login-related fields
            showPasswordCheckBox.setVisible(false);
            // Show the new account-related fields
            nameField.setVisible(true);
            usernameField.setVisible(true);
            passwordField.setVisible(true);
            confirmPasswordField.setVisible(true);
            gradeField.setVisible(true);
            createAccountButton.setVisible(true);
        } else {
            // If the current view is "Create a new account", change the view to "Login"
            loginLabel.setText("Login");
            switchLink.setText("Create a new account");
            // Show the login-related fields
            usernameField.setVisible(true);
            passwordField.setVisible(true);
            showPasswordCheckBox.setVisible(true);
            // Hide the new account-related fields
            nameField.setVisible(false);
            confirmPasswordField.setVisible(false);
            gradeField.setVisible(false);
            createAccountButton.setVisible(false);
        }
    }

    // Method to handle the action of the show password check box
    @FXML
    protected void handleShowPasswordCheckBox(ActionEvent event) {
        // If the checkbox is selected, show the password
        if (showPasswordCheckBox.isSelected()) {
            passwordField.setPromptText(passwordField.getText());
            passwordField.clear();
        } else {
            // If the checkbox is not selected, restore the original password
            passwordField.setText(passwordField.getPromptText());
        }
    }

    // Method to handle the action of the login button
    @FXML
    protected void handleLoginButton(ActionEvent event) {
        // Get the text from the input fields
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String grade = gradeField.getText();

        // Check the user's credentials
        boolean isValidUser = checkCredentials(username, password);

        // If the credentials are valid, load the home page
        if (isValidUser) {
            loadHomePage(event);
        } else {
            // If the credentials are not valid, show an error message
            errorLabel.setText("Incorrect");
        }
    }

    @FXML
    protected void handleCreateAccountButton(ActionEvent event){
        // If the current view is "Create a new account"
            if (passwordField.getText().equals(confirmPasswordField.getText())) {
                createAccount();
                // Load the home page
                loadHomePage(event);
            } else {
                // If the password and confirm password do not match, show an error message
                errorLabel.setText("Passwords do not match");
            }
        }

    // Method to load the home page
    private void loadHomePage(ActionEvent event) {
        try {
            Profile user = new Profile(currentStudentName, currentUsername, currentGrade, currentPoints);
            setTutorialUrls();
            setUserAchievements();
            // Load the home page FXML
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home_page.fxml")));

            // Get the current stage via the event source (which is a Node)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene to the existing stage
            currentStage.setScene(new Scene(root, 1123, 794));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to create a new account
    private void createAccount() {
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String grade = gradeField.getText();
        String myUrl = "jdbc:mysql://medievalmath.c3eqia6i2cfi.us-east-2.rds.amazonaws.com:3306/medievalMath";
        String user = "admin";
        String adminPassword = "WbIofZIaebOVezZ2wy9u";
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        Random rand = new Random();
        int userID = rand.nextInt(1000);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, user, adminPassword);
            String sql = "INSERT INTO profiles VALUES (?, ?, ?, ?, 0, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, hashedPassword);
            if (grade.equalsIgnoreCase("k") || grade.equalsIgnoreCase("kindergarten")) {
                preparedStatement.setInt(4, 0);
                setUserInfo(username, 0, 0);
            } else {
                preparedStatement.setInt(4, Integer.parseInt(grade));
                setUserInfo(username, Integer.parseInt(grade), 0);
            }
            preparedStatement.setString(5, name);
            preparedStatement.execute();

            sql = "INSERT INTO achievements (userID, competencyID, earned) " +
                    "SELECT ?, competencyID, false FROM standards";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, userID);
            preparedStatement.execute();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private boolean checkCredentials(String username, String password) {
        String myUrl = "jdbc:mysql://medievalmath.c3eqia6i2cfi.us-east-2.rds.amazonaws.com:3306/medievalMath";
        String user = "admin";
        String adminPassword = "WbIofZIaebOVezZ2wy9u";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, user, adminPassword);
            String sql = "SELECT * FROM profiles";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet profileReturn = preparedStatement.executeQuery();
            while (profileReturn.next()) {
                if (profileReturn.getString(2).equals(username)) {
                    if (BCrypt.checkpw(password, profileReturn.getString("password"))) {
                        int grade = profileReturn.getInt("currentGrade");
                        int points = profileReturn.getInt("points");

                        setUserInfo(username, grade, points);

                        String userName = profileReturn.getString("userName");
                        String studentName = profileReturn.getString("name");
                        currentUserID = profileReturn.getInt("userID");
                        setUserInfo(grade, points, userName, studentName);
                        setUserAchievements();

                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return false;
    }


    public void setUserInfo(String userName, int grade, int points) {
        username = userName;
        currentGrade = grade;
        currentPoints = points;
    }

    public int getPoints() {
        return currentPoints;
    }

    public int getStudentGrade() {
        return currentGrade;
    }

    public int addPoints(int newPoints) {
        currentPoints = currentPoints + newPoints;
        return currentPoints;
    }

    public String getUsername() {
        return username;
    }

    public static void saveProfile() {
        String myUrl = "jdbc:mysql://medievalmath.c3eqia6i2cfi.us-east-2.rds.amazonaws.com:3306/medievalMath";
        String user = "admin";
        String adminPassword = "WbIofZIaebOVezZ2wy9u";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, user, adminPassword);
            String sql = "UPDATE profiles SET POINTS = '" + Profile.getPoints() + "' WHERE userID = '" + currentUserID + "'";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.execute();
            for(int i = 1; i<=Profile.earnedAchievements.size(); i++){
                sql = "UPDATE achievements SET earned = '?' WHERE userID = '?' AND competencyID = '?'";
                preparedStatement.setBoolean(1, Profile.earnedAchievements.get(i));
                preparedStatement.setInt(2, currentUserID);
                preparedStatement.setInt(3, i);
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.execute();
            }

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setTutorialUrls(){
        String myUrl = "jdbc:mysql://medievalmath.c3eqia6i2cfi.us-east-2.rds.amazonaws.com:3306/medievalMath";
        String user = "admin";
        String adminPassword = "WbIofZIaebOVezZ2wy9u";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, user, adminPassword);
            String sql = "SELECT * FROM standards";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet standardsReturn = preparedStatement.executeQuery();
            while (standardsReturn.next()){
                System.out.println("accessing standards in database...");
                int comp = standardsReturn.getInt("competencyID");
                System.out.println("comp id: "+ comp);
                String url = standardsReturn.getString("videoURL");
                System.out.println("url: "+ url);
                videoURLs.put(comp, url);
            }
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    public void setUserAchievements(){
        String myUrl = "jdbc:mysql://medievalmath.c3eqia6i2cfi.us-east-2.rds.amazonaws.com:3306/medievalMath";
        String user = "admin";
        String adminPassword = "WbIofZIaebOVezZ2wy9u";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, user, adminPassword);
            String sql = "SELECT * FROM achievements " +
                    "WHERE userID = " + currentUserID;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet achievementsReturn = preparedStatement.executeQuery();
            while (achievementsReturn.next()){
                System.out.println("accessing achievements in database...");
                int comp = achievementsReturn.getInt("competencyID");
                System.out.println("comp id: "+ comp);
                Boolean earned = achievementsReturn.getBoolean("earned");
                System.out.println("earned: "+ earned);
                Profile.earnedAchievements.put(comp, earned);

            }
            System.out.println(Profile.earnedAchievements);
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
    public void setUserInfo(int grade, int points, String userName, String studentName){
        currentGrade = grade;
        currentPoints = points;
        currentUsername = userName;
        currentStudentName = studentName;
        System.out.println("Student Name: " + currentStudentName);
        System.out.println("User Name: " + currentUsername);
        System.out.println("Grade: " + currentGrade);
        System.out.println("Points: " + currentPoints);

    }
}
