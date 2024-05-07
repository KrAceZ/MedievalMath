package org.example.medievalmath;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

public class QuizResultController {
    @FXML
    public Label resultTitle, remark, score, scoreText, correctText, wrongText;

    @FXML
    public ProgressIndicator correctProgress, wrongProgress;

    @FXML
    private void initialize(){
        resultTitle.setText("Result");
        int rCorrect = QuizController.correct;
        int rWrong = QuizController.wrong;
        int numOfProbs = QuizController.numOfQuizProbs;
        score.setText(rCorrect + " / "+ numOfProbs);
        scoreText.setText(rCorrect + " Points Out of "+ numOfProbs);
        correctText.setText("Correct Answers: "+ rCorrect);
        wrongText.setText("Wrong Answers: "+ rWrong);

        double correctf = (double) rCorrect / numOfProbs;
        correctProgress.setProgress(correctf);

        double wrongf = (double) rWrong /numOfProbs;
        wrongProgress.setProgress(wrongf);

        if (correctf>0.95) {
            remark.setText("Congratulations! You earned an A+");
        }
        else if(correctf>=0.9) {
            remark.setText("Great work! You earned an A");
        }
        else if(correctf>=0.8) {
            remark.setText("Good work! You earned a B");
        }
        else if(correctf>=0.7) {
            remark.setText("You passed! You earned a C");
        }
        else{
            remark.setText("Failed. Almost there! Keep Practicing!");
        }

        int level = QuizController.quizLevel;
        String type = QuizController.quizType;
        if(correctf>= 0.7)
        {
            Profile.addPoints(5*numOfProbs);
            if(numOfProbs==QuizController.TESTSIZE){
                int compID = 1;
                switch(QuizController.quizCompetency){
                    case "a":
                        compID = level*1;
                        break;
                    case "b":
                        compID = level*2;
                        break;
                    case "c":
                        compID = level*3;
                        break;
                }
                Profile.earnedAchievements.put(compID, true);
            }
        }
    }
}
