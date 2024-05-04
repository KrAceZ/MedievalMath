//package org.example.medievalmath;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.control.ProgressIndicator;
//
//public class BasicSubtractionResultController {
//    @FXML
//    public Label resultTitle, remark, score, scoreText, correctText, wrongText;
//
//    @FXML
//    public ProgressIndicator correctProgress, wrongProgress;
//
//    @FXML
//    private void initialize(){
//        resultTitle.setText("Result");
//        int rCorrect = BasicSubtractionQuizController.correct;
//        int rWrong = BasicSubtractionQuizController.wrong;
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
