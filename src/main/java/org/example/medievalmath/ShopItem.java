package org.example.medievalmath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShopItem {
    // Instance variables
    private int item_cost;
    public List<String> selectedItems = new ArrayList<>();
    private String userName;
    public ShopItem() {

    }
    // Constructor

    public ShopItem(int item_cost, List<String> selectedItems, String userName) {
        this.item_cost = item_cost;
        this.selectedItems = selectedItems;
        this.userName = userName;
    }
    // get and set method for ShopItem

    public boolean checkIftheUserNameIsValid(){
        //Check to see if the username is valid
        String myUrl = "jdbc:mysql://medievalmath.c3eqia6i2cfi.us-east-2.rds.amazonaws.com:3306/medievalMath";
        String user = "admin";
        String adminPassword = "WbIofZIaebOVezZ2wy9u";
        String userNameToSearch = this.userName;

        int recordsCount = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, user, adminPassword);
            String sql = "SELECT * FROM medievalMath.profiles where userName = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userNameToSearch);
            ResultSet profileReturn = preparedStatement.executeQuery();
            while (profileReturn.next()) {
                recordsCount +=1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        if(recordsCount > 0)
        {
            return true;
        }
        return false;
    }

    public int getPoints(){
        int userPoints = 0;

        String myUrl = "jdbc:mysql://medievalmath.c3eqia6i2cfi.us-east-2.rds.amazonaws.com:3306/medievalMath";
        String user = "admin";
        String adminPassword = "WbIofZIaebOVezZ2wy9u";
        String userNameToSearch = this.userName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, user, adminPassword);
            String sql = "SELECT * FROM medievalMath.profiles where userName = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            // Set the value of the username
            preparedStatement.setString(1, userNameToSearch);

            ResultSet profileReturn = preparedStatement.executeQuery();
            while (profileReturn.next()) {
                userPoints = profileReturn.getInt("points");
                //String userID = profileReturn.getString("userID");
                //System.out.println("The username is " + userName + " userID is " + userID);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return userPoints;
    }
    public void purchase(int availablepoints) {
        // Implementation to handle item purchase goes here
        int leftoutPoints = availablepoints - this.item_cost;

        String myUrl = "jdbc:mysql://medievalmath.c3eqia6i2cfi.us-east-2.rds.amazonaws.com:3306/medievalMath";
        String user = "admin";
        String adminPassword = "WbIofZIaebOVezZ2wy9u";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, user, adminPassword);
            String sql = "UPDATE profiles SET POINTS = '" + leftoutPoints + "' WHERE userName = '" + this.userName + "'";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.execute();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Purchased selected items and " + leftoutPoints + " coins left");
    }
}


