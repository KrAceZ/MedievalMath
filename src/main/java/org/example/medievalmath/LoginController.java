package org.example.medievalmath;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

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

    // Method to handle the action of the switch link
    @FXML
    protected void handleSwitchLink(ActionEvent event) {
        // If the current view is "Login"
        if (loginLabel.getText().equals("Login")) {
            // Change the view to "Create a new account"
            loginLabel.setText("Create a new account");
            switchLink.setText("Login as a returning user");
            // Make the name field, confirm password field, and grade field visible
            nameField.setVisible(true);
            confirmPasswordField.setVisible(true);
            gradeField.setVisible(true);
        } else {
            // If the current view is "Create a new account", change the view to "Login"
            loginLabel.setText("Login");
            switchLink.setText("Create a new account");
            // Hide the name field, confirm password field, and grade field
            nameField.setVisible(false);
            confirmPasswordField.setVisible(false);
            gradeField.setVisible(false);
        }
    }

    // Method to handle the action of the show password check box
    @FXML
    protected void handleShowPasswordCheckBox(ActionEvent event) {
        // If the check box is selected, show the password
        if (showPasswordCheckBox.isSelected()) {
            passwordField.setPromptText(passwordField.getText());
            passwordField.clear();
        } else {
            // If the check box is not selected, hide the password
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
                loadHomePage();
            } else {
                // If the password and confirm password do not match, show an error message
                errorLabel.setText("Passwords do not match");
            }
        } else {
            // If the current view is "Login", check the user's credentials
            boolean isValidUser = checkCredentials(username, password);

            // If the credentials are valid, load the home page
            if (isValidUser) {
                loadHomePage();
            } else {
                // If the credentials are not valid, show an error message
                errorLabel.setText("Incorrect");
            }
        }
    }

    // Method to load the home page
    private void loadHomePage() {
        try {
            // Load the home page
            Parent root = FXMLLoader.load(getClass().getResource("home_page.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to create a new account
    private void createAccount(String name, String username, String password, String grade) {
        // TODO: Implement this method to create a new account in the AWS database
    }

    private boolean checkCredentials(String username, String password) {
        // TODO: Implement this method to check the user's credentials against the AWS database
        // return false;    uncomment to actually check username and password
        return true; // @Sadie: delete line when to actually check username/password

    }
}