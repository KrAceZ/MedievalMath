package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ShopItemController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onCheckOutButtonClick() {
        welcomeText.setText("Checking out the item");
    }

    }


