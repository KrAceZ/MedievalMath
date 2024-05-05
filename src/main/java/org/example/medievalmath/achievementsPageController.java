package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class achievementsPageController {
    @FXML
    private ImageView royalSumScribeButton;

    @FXML
    private ImageView multiplicationMysticButton;

    @FXML
    private ImageView subtractionSorcererButton;

    @FXML
    private ImageView divisionDragonSlayerButton;

    @FXML
    private ImageView sumScribeCertificate;

    @FXML
    private ImageView levelCompleted1;

    @FXML
    private ImageView levelCompleted2;

    @FXML
    private ImageView levelCompleted3;

    @FXML
    private ImageView banner1;

    @FXML
    private ImageView banner2;

    @FXML
    private ImageView banner3;

    @FXML
    private ImageView crest1;

    @FXML
    private ImageView crest2;

    @FXML
    private ImageView crest3;

    @FXML
    private ImageView subSorcererCertificate;

    @FXML
    private ImageView multMysticCertificate;

    @FXML
    private ImageView divDragonSlayerCert;

    @FXML
    private ImageView firstLevelComplete;

    @FXML
    private ImageView secondLevelComplete;

    @FXML
    private ImageView thirdLevelComplete;

    @FXML
    private ImageView goBack1;

    @FXML
    private ImageView goBack2;

    @FXML
    public void royalSumScribeClick() {
        // Show the certificate for this button
        sumScribeCertificate.setVisible(!sumScribeCertificate.isVisible());
        goBack2.setVisible(!goBack2.isVisible());
        // Remove all other images for this button
        levelCompleted1.setVisible(!levelCompleted1.isVisible());
        levelCompleted2.setVisible(!levelCompleted2.isVisible());
        levelCompleted3.setVisible(!levelCompleted3.isVisible());
        royalSumScribeButton.setVisible(!royalSumScribeButton.isVisible());
        multiplicationMysticButton.setVisible(!multiplicationMysticButton.isVisible());
        subtractionSorcererButton.setVisible(!subtractionSorcererButton.isVisible());
        divisionDragonSlayerButton.setVisible(!divisionDragonSlayerButton.isVisible());
        banner1.setVisible(!banner1.isVisible());
        banner2.setVisible(!banner2.isVisible());
        banner3.setVisible(!banner3.isVisible());
        crest1.setVisible(!crest1.isVisible());
        crest2.setVisible(!crest2.isVisible());
        crest3.setVisible(!crest3.isVisible());
    }

    @FXML
    public void subtractionSorcererClick(){
        // Show the certificate for this button
        subSorcererCertificate.setVisible(!subSorcererCertificate.isVisible());
        goBack2.setVisible(!goBack2.isVisible());
        // Remove all other images for this button
        levelCompleted1.setVisible(!levelCompleted1.isVisible());
        levelCompleted2.setVisible(!levelCompleted2.isVisible());
        levelCompleted3.setVisible(!levelCompleted3.isVisible());
        royalSumScribeButton.setVisible(!royalSumScribeButton.isVisible());
        multiplicationMysticButton.setVisible(!multiplicationMysticButton.isVisible());
        subtractionSorcererButton.setVisible(!subtractionSorcererButton.isVisible());
        divisionDragonSlayerButton.setVisible(!divisionDragonSlayerButton.isVisible());
        banner1.setVisible(!banner1.isVisible());
        banner2.setVisible(!banner2.isVisible());
        banner3.setVisible(!banner3.isVisible());
        crest1.setVisible(!crest1.isVisible());
        crest2.setVisible(!crest2.isVisible());
        crest3.setVisible(!crest3.isVisible());
    }

    @FXML
    public void multiplicationMysticClick(){
        // Show the certificate for this button
        multMysticCertificate.setVisible(!multMysticCertificate.isVisible());
        goBack2.setVisible(!goBack2.isVisible());
        // Remove all other images for this button
        levelCompleted1.setVisible(!levelCompleted1.isVisible());
        levelCompleted2.setVisible(!levelCompleted2.isVisible());
        levelCompleted3.setVisible(!levelCompleted3.isVisible());
        royalSumScribeButton.setVisible(!royalSumScribeButton.isVisible());
        multiplicationMysticButton.setVisible(!multiplicationMysticButton.isVisible());
        subtractionSorcererButton.setVisible(!subtractionSorcererButton.isVisible());
        divisionDragonSlayerButton.setVisible(!divisionDragonSlayerButton.isVisible());
        banner1.setVisible(!banner1.isVisible());
        banner2.setVisible(!banner2.isVisible());
        banner3.setVisible(!banner3.isVisible());
        crest1.setVisible(!crest1.isVisible());
        crest2.setVisible(!crest2.isVisible());
        crest3.setVisible(!crest3.isVisible());
    }

    @FXML
    public void divisionDragonSlayerClick(){
        // Show the certificate for this button
        divDragonSlayerCert.setVisible(!divDragonSlayerCert.isVisible());
        goBack2.setVisible(!goBack2.isVisible());
        // Remove all other images for this button
        levelCompleted1.setVisible(!levelCompleted1.isVisible());
        levelCompleted2.setVisible(!levelCompleted2.isVisible());
        levelCompleted3.setVisible(!levelCompleted3.isVisible());
        royalSumScribeButton.setVisible(!royalSumScribeButton.isVisible());
        multiplicationMysticButton.setVisible(!multiplicationMysticButton.isVisible());
        subtractionSorcererButton.setVisible(!subtractionSorcererButton.isVisible());
        divisionDragonSlayerButton.setVisible(!divisionDragonSlayerButton.isVisible());
        banner1.setVisible(!banner1.isVisible());
        banner2.setVisible(!banner2.isVisible());
        banner3.setVisible(!banner3.isVisible());
        crest1.setVisible(!crest1.isVisible());
        crest2.setVisible(!crest2.isVisible());
        crest3.setVisible(!crest3.isVisible());
    }

    @FXML
    public void firstLevelCompleteClick(){
        // Show the certificate for this button
        firstLevelComplete.setVisible(!firstLevelComplete.isVisible());
        goBack2.setVisible(!goBack2.isVisible());
        // Remove all other images for this button
        levelCompleted1.setVisible(!levelCompleted1.isVisible());
        levelCompleted2.setVisible(!levelCompleted2.isVisible());
        levelCompleted3.setVisible(!levelCompleted3.isVisible());
        royalSumScribeButton.setVisible(!royalSumScribeButton.isVisible());
        multiplicationMysticButton.setVisible(!multiplicationMysticButton.isVisible());
        subtractionSorcererButton.setVisible(!subtractionSorcererButton.isVisible());
        divisionDragonSlayerButton.setVisible(!divisionDragonSlayerButton.isVisible());
        banner1.setVisible(!banner1.isVisible());
        banner2.setVisible(!banner2.isVisible());
        banner3.setVisible(!banner3.isVisible());
        crest1.setVisible(!crest1.isVisible());
        crest2.setVisible(!crest2.isVisible());
        crest3.setVisible(!crest3.isVisible());
    }

    @FXML
    public void secondLevelCompleteClick(){
        // Show the certificate for this button
        secondLevelComplete.setVisible(!secondLevelComplete.isVisible());
        goBack2.setVisible(!goBack2.isVisible());
        // Remove all other images for this button
        levelCompleted1.setVisible(!levelCompleted1.isVisible());
        levelCompleted2.setVisible(!levelCompleted2.isVisible());
        levelCompleted3.setVisible(!levelCompleted3.isVisible());
        royalSumScribeButton.setVisible(!royalSumScribeButton.isVisible());
        multiplicationMysticButton.setVisible(!multiplicationMysticButton.isVisible());
        subtractionSorcererButton.setVisible(!subtractionSorcererButton.isVisible());
        divisionDragonSlayerButton.setVisible(!divisionDragonSlayerButton.isVisible());
        banner1.setVisible(!banner1.isVisible());
        banner2.setVisible(!banner2.isVisible());
        banner3.setVisible(!banner3.isVisible());
        crest1.setVisible(!crest1.isVisible());
        crest2.setVisible(!crest2.isVisible());
        crest3.setVisible(!crest3.isVisible());
    }

    @FXML
    public void thirdLevelCompleteClick(){
        // Show the certificate for this button
        thirdLevelComplete.setVisible(!thirdLevelComplete.isVisible());
        goBack2.setVisible(!goBack2.isVisible());
        // Remove all other images for this button
        levelCompleted1.setVisible(!levelCompleted1.isVisible());
        levelCompleted2.setVisible(!levelCompleted2.isVisible());
        levelCompleted3.setVisible(!levelCompleted3.isVisible());
        royalSumScribeButton.setVisible(!royalSumScribeButton.isVisible());
        multiplicationMysticButton.setVisible(!multiplicationMysticButton.isVisible());
        subtractionSorcererButton.setVisible(!subtractionSorcererButton.isVisible());
        divisionDragonSlayerButton.setVisible(!divisionDragonSlayerButton.isVisible());
        banner1.setVisible(!banner1.isVisible());
        banner2.setVisible(!banner2.isVisible());
        banner3.setVisible(!banner3.isVisible());
        crest1.setVisible(!crest1.isVisible());
        crest2.setVisible(!crest2.isVisible());
        crest3.setVisible(!crest3.isVisible());
    }
    public void certGoBack(){
        if (thirdLevelComplete.isVisible()){
            thirdLevelCompleteClick();
        }
        else if (secondLevelComplete.isVisible()){
            secondLevelCompleteClick();
        }
        else if (firstLevelComplete.isVisible()) {
            firstLevelCompleteClick();
        }
        else if (divDragonSlayerCert.isVisible()){
            divisionDragonSlayerClick();
        }
        else if (multMysticCertificate.isVisible()) {
            divisionDragonSlayerClick();
        } else if (subSorcererCertificate.isVisible()) {
            subtractionSorcererClick();
        } else if (sumScribeCertificate.isVisible()) {
            royalSumScribeClick();
        }
        else{
            System.out.println("Error. Please check code.");
        }
    }

    @FXML
    private void goToHomePage() {
        try {
            // Load the home_page.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home_page.fxml"));
            Parent root = loader.load();

            // Get the stage from the ImageView
            Stage stage = (Stage) goBack1.getScene().getWindow();

            // Set the scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
