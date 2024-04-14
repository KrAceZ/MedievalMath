package com.example.appdbconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.*;

public class HelloController {
    @FXML
    private TextField addition;

    public void connectButton(ActionEvent event){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        try{
            String checkDatabase = "SELECT SCHEMA_NAME \n" +
                    "FROM information_schema.SCHEMATA \n" +
                    "WHERE SCHEMA_NAME = 'medivalmath'\n;";
            Statement statement = connectDB.createStatement();
            statement.execute(checkDatabase);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            String checkTable = "SELECT * FROM test";
            Statement statement = connectDB.createStatement();
            statement.execute(checkTable);
        }
        catch (Exception e){
            try {
                String createTable = "CREATE TABLE test (testDemo varChar(255))";
                Statement statement = connectDB.createStatement();
                statement.execute(createTable);
            }
            catch (Exception f) {
                f.printStackTrace();
            }
        }

        try{
            String connectQuery = "INSERT INTO test VALUES('" + addition.getText() + "')";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(connectQuery);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}