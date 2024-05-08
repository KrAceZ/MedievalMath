package org.example.medievalmath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    boolean shoppingStarted = false;
    List<String> selectedItems = new ArrayList<>();
    String username = "";
    int totalCostItems = 0;

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
        selectedItems.clear();
        totalCostItems = 0;

        System.out.println("Shopping Started .....");
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("UserName");
        dialog.setHeaderText("Please enter your username:");
        dialog.setContentText("UserName");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> {
            username = name; // Enter UserName here
        });

        //check the username is valid in database
        shoppingStarted = true;
    }

    @FXML
    private void handleButtonCheckOutClick() {
        if (selectedItems.isEmpty()) {
            System.out.println("No items selected for check out");
        } else {
            // hat, sword, kitehelmet, bridge
            for (String item : selectedItems) {
                switch (item) {
                    case "hat":
                        totalCostItems = totalCostItems + 50;
                        break;
                    case "sword":
                        totalCostItems = totalCostItems + 100;
                        break;
                    case "kitehelmet":
                        totalCostItems = totalCostItems + 200;
                        break;
                    case "bridge":
                        totalCostItems = totalCostItems + 300;
                        break;
                    default:
                        break;
                }
            }

            // check if there are enough points for the shop items
            ShopItem items = new ShopItem(totalCostItems, selectedItems, username);
            if (items.checkIftheUserNameIsValid()) {
                if (items.getPoints() >= totalCostItems) {
                    items.purchase(items.getPoints());
                } else {
                    System.out.println("The user " + username + " does not have " + totalCostItems + " coins to purchase");
                }
            } else {
                System.out.println("The username " + username + " is invalid");
            }
            selectedItems.clear();
        }
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

        if (!shoppingStarted) {
            System.out.println("Please start shopping first");
        } else {
            if (selectedButton != null) {
                String imageId = selectedButton.getId();
                System.out.println("Selected image id: " + imageId);
                selectedItems.add(imageId);
            }
        }
    }
}
