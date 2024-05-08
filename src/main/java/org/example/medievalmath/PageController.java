package org.example.medievalmath;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class PageController {
    @FXML
    private ImageView backgroundImageView;

    @FXML
    private AnchorPane buttonsContainer;

    private Page page;

    public void initialize() {
        // Initialize the page with default background image
        Image defaultBackground = new Image(getClass().getResourceAsStream("Background.png"));
        page = new Page(defaultBackground);

        // Set the background image
        backgroundImageView.setImage(defaultBackground);
    }

    // Method to handle button clicks
    @FXML
    private void handleButtonClick() {
        // Implement button click logic here
        // currently unused
    }
}
