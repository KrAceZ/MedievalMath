package org.example.medievalmath;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ToggleGroup;

public class ShopItemController {

    @FXML
    private ImageView ShopPageBackgroundView;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private ToggleButton hat;

    @FXML
    private ToggleButton sword;

    @FXML
    private ToggleButton kitehelmet;

    @FXML
    private ToggleButton bridge;

    private ToggleGroup toggleGroup;

    public void initialize() {

        // Initialize toggle group
        toggleGroup = new ToggleGroup();
        hat.setToggleGroup(toggleGroup);
        sword.setToggleGroup(toggleGroup);
        kitehelmet.setToggleGroup(toggleGroup);
        bridge.setToggleGroup(toggleGroup);

        // Load background image
        Image backgroundImage = new Image(getClass().getResourceAsStream("Background.png"));
        ShopPageBackgroundView.setImage(backgroundImage);
    }

    @FXML
    private void handleButtonShopClick() {
        // Handle button 1 click event
        System.out.println("Shopping Started .....");
    }

    @FXML
    private void handleButtonCheckOutClick() {
        // Handle button 2 click event
        System.out.println("Button 2 clicked");
    }

    @FXML
    private void navigateToHomePage(ActionEvent event) {
        try {
            // Load the profile page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home_page.fxml"));
            Parent homePage = loader.load();

            // Get the scene from the event source
            Scene scene = ((Node) event.getSource()).getScene();

            // Set the new scene root
            scene.setRoot(homePage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleImageSelection() {
        ToggleButton selectedButton = (ToggleButton) toggleGroup.getSelectedToggle();
        if (selectedButton != null) {
            String imageId = selectedButton.getId();
            System.out.println("Selected image id: " + imageId);
        }
    }
}
