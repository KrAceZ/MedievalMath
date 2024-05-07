package org.example.medievalmath;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

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
    public int currentGrade;
    public int currentPoints;
    public String currentUsername;
    public String currentStudentName;
    public static Map<Integer, String> videoURLs = new HashMap<>();

    // Method to handle the action of the switch link
    @FXML
    protected void handleSwitchLink(ActionEvent event) {
        // If the current view is "Login"
        if (loginLabel.getText().equals("Login")) {
            // Change the view to "Create a new account"
            loginLabel.setText(""); // FIX THIS
            switchLink.setText("Login as a returning user");
            // Hide the login-related fields
            usernameField.setVisible(false);
            passwordField.setVisible(false);
            showPasswordCheckBox.setVisible(false);
            // Show the new account-related fields
            nameField.setVisible(true);
            confirmPasswordField.setVisible(true);
            gradeField.setVisible(true);
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
            // If the checkbox is not selected, hide the password
            passwordField.setPromptText("Password");
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

        // If the current view is "Create a new account"
        if (loginLabel.getText().equals("Create a new account")) {
            // If the password and confirm password match, create a new account
            if (password.equals(confirmPassword)) {
                createAccount(name, username, password, grade);
                // Load the home page
                loadHomePage(event);
            } else {
                // If the password and confirm password do not match, show an error message
                errorLabel.setText("Passwords do not match");
            }
        } else {
            // If the current view is "Login", check the user's credentials
            boolean isValidUser = checkCredentials(username, password);

            // If the credentials are valid, load the home page
            if (isValidUser) {
                loadHomePage(event);
            } else {
                // If the credentials are not valid, show an error message
                errorLabel.setText("Incorrect");
            }
        }
    }

    // Method to load the home page
    private void loadHomePage(javafx.event.ActionEvent event) {
        try {
            Profile user = new Profile(currentStudentName, currentUsername, currentGrade, currentPoints);
            setTutorialUrls();
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
    private void createAccount(String name, String username, String password, String grade) {
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
            if (grade.equalsIgnoreCase("k") || grade.equalsIgnoreCase("kindergarten")){
                preparedStatement.setInt(4, 0);
            }
            else{
                preparedStatement.setInt(4, Integer.parseInt(grade));
            }
            preparedStatement.setString(5, name);
            preparedStatement.execute();
            conn.close();
        }
        catch (Exception e){
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
            while (profileReturn.next()){
                if (profileReturn.getString(2).equals(username)){
                    if (BCrypt.checkpw(password, profileReturn.getString("password"))){
                        int grade = profileReturn.getInt("currentGrade");
                        int points = profileReturn.getInt("points");
                        String userName = profileReturn.getString("userName");
                        String studentName = profileReturn.getString("name");
                        setUserInfo(grade, points, userName, studentName);
                        return true;
                    }
                }
            }
            return false;
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
        return false;
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
