//package org.example.medievalmath;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.control.ProgressIndicator;
//
//public class BasicAddSubtractResultController {
//    @FXML
//    public Label resultTitle, remark, score, scoreText, correctText, wrongText;
//
//    @FXML
//    public ProgressIndicator correctProgress, wrongProgress;
//
//    @FXML
//    private void initialize(){
//        resultTitle.setText("Result");
//        int rCorrect = BasicAddSubtractTestController.correct;
//        int rWrong = BasicAddSubtractTestController.wrong;
//        score.setText(rCorrect + " / 20");
//        scoreText.setText(rCorrect + " Points Out of 20");
//        correctText.setText("Correct Answers: "+ rCorrect);
//        wrongText.setText("Wrong Answers: "+ rWrong);
//
//        double correctf = (double) rCorrect / 20;
//        correctProgress.setProgress(correctf);
//
//        double wrongf = (double) rWrong /20;
//        wrongProgress.setProgress(wrongf);
//
//        switch (rCorrect){
//            case 20:
//                remark.setText("Congratulations! You earned an A+");
//                break;
//            case 18, 19:
//                remark.setText("Great work! You earned an A");
//                break;
//            case 16, 17:
//                remark.setText("Good work! You earned a B");
//                break;
//            case 14, 15:
//                remark.setText("You passed! You earned a C");
//                break;
//            default:
//                remark.setText("Failed. Almost there! Keep Practicing!");
//                break;
//        }
//    }
//}
