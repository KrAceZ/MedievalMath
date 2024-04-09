package org.example.medievalmath;

import javafx.scene.image.Image;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.List;

public class Page {
    private Image backgroundImage;
    private List<Button> buttons;

    // Constructor
    public Page(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
        this.buttons = new ArrayList<>();
    }

    // Method to set background image
    public void setBackgroundImage(Image image) {
        this.backgroundImage = image;
        // Update UI to reflect the new background image (if needed)
    }

    // Method to add button
    public void addButton(Button button) {
        buttons.add(button);
        // Update UI to reflect the new button (if needed)
    }

    // Method to handle button click
    public void handleButtonClick(Button button) {
        // Implement button click logic here
    }

    // Other getters, setters, and methods as needed...
}

