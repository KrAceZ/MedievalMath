package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShopItemController {
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label checkOutText;
    @FXML
    private Label shopText;
    @FXML
    private  Label welcomeText;

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView4;
    @FXML
    private void initialize() {

        loadImage("Hat.svg", imageView1);
        loadImage("Sword.svg", imageView2);
        loadImage("Kite-Helmet.svg", imageView3);
        loadImage("Hat.svg", imageView4);

        // Add listener to handle dropdown selection
        comboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Handle selected item
            handleSelectedItem(newValue);
        });
    }

    // Method to handle selected item from dropdown
    private void handleSelectedItem(String selectedItem) {
        // Implement your logic based on the selected item
        System.out.println("Selected Item: " + selectedItem);
        // You can update UI elements or perform other actions based on the selected item
    }

    @FXML
    protected void onCheckOutButtonClick() {
        welcomeText.setText("Checking out the item");
    }
    @FXML
    protected void onShopButtonClick(){
        welcomeText.setText("Shopping the checked out button");
    }

    // Method to handle image selection
    @FXML
    private void onImageSelect1() {
        // Load and display selected image
        loadImage("Hat.svg", imageView1);
    }

    @FXML
    private void onImageSelect2() {
        // Load and display selected image
        loadImage("Sword.svg", imageView2);
    }

    @FXML
    private void onImageSelect3() {
        // Load and display selected image
        loadImage("Kite-Helmet.svg", imageView3);
    }

    @FXML
    private void onImageSelect4() {
        // Load and display selected image
        loadImage("Hat.svg", imageView4);
    }

    // Method to load and display an image
    private void loadImage(String imagePath, ImageView imageView) {
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            imageView.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


