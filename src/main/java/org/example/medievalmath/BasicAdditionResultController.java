//package org.example.medievalmath;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.control.ProgressIndicator;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//
//public class BasicAdditionResultController {
//    @FXML
//    public Label resultTitle, remark, score, scoreText, correctText, wrongText;
//
//    @FXML
//    public ProgressIndicator correctProgress, wrongProgress;
//
//    @FXML
//    private void initialize(){
//        resultTitle.setText("Result");
//        int rCorrect = BasicAdditionQuizController.correct;
//        int rWrong = BasicAdditionQuizController.wrong;
//        score.setText(rCorrect + " / 10");
//        scoreText.setText(rCorrect + " Points Out of 10");
//        correctText.setText("Correct Answers: "+ rCorrect);
//        wrongText.setText("Wrong Answers: "+ rWrong);
//
//        double correctf = (double) rCorrect / 10;
//        correctProgress.setProgress(correctf);
//
//        double wrongf = (double) rWrong /10;
//        wrongProgress.setProgress(wrongf);
//
//        switch (rCorrect){
//            case 10:
//                remark.setText("Congratulations! You earned an A+");
//                break;
//            case 9:
//                remark.setText("Great work! You earned an A");
//                break;
//            case 8:
//                remark.setText("Good work! You earned a B");
//                break;
//            case 7:
//                remark.setText("You passed! You earned a C");
//                break;
//            default:
//                remark.setText("Failed. Almost there! Keep Practicing!");
//                break;
//        }
//    }
//}
