package org.example.medievalmath;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;

import javafx.scene.image.Image;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.List;

public class Page extends AnchorPane{
    private ImageView backgroundImageView;
    private List<Button> buttons;

    // Constructor
    public Page(Image backgroundImage) {
        this.backgroundImageView = new ImageView(backgroundImage);
        this.buttons = new ArrayList<>();

        setupBackground();
    }
    private void setupBackground() {
        backgroundImageView.setFitWidth(1123); // Set width for the background image
        backgroundImageView.setFitHeight(794); // Set height for the background image
        backgroundImageView.setPreserveRatio(true);
        this.getChildren().add(backgroundImageView); // Add the ImageView to the page
    }

    // Method to set background image
    public void setBackgroundImage(Image image) {
        backgroundImageView.setImage(image);
        // Update UI to reflect the new background image (if needed)
    }

    // Method to add button
    public void addButton(Button button) {
        buttons.add(button);
        this.getChildren().add(button);
        // Update UI to reflect the new button (if needed)
    }



    // Method to handle button click
    public void handleButtonClick(Button button) {
        // Implement button click logic here
    }

    // Other getters, setters, and methods as needed...
}

