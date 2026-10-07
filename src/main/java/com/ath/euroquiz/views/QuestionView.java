package com.ath.euroquiz.views;

import com.ath.euroquiz.models.Player;
import com.ath.euroquiz.models.Question;
import com.ath.euroquiz.managers.GameManager;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class QuestionView {
    private final Scene scene;

    public QuestionView(Stage stage, GameManager gameManager, Question question, BoardView boardView){
        ArrayList<Button> buttonList = new ArrayList<Button>();
        BorderPane root = new BorderPane();
        Button continueButton = new Button("Continue");
        continueButton.setOnAction(event1 -> {
            boardView.updateScore();
            stage.setScene(boardView.getScene());
        });

        //Top
        Label questionLabel = new Label(question.getQuestionText());

        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().add(questionLabel);

        root.setTop(topBox);

        //Center
        VBox answersBox = new VBox(15);
        answersBox.setAlignment(Pos.CENTER);

        for (String answer : question.getAnswers()){
            Button answerButton = new Button(answer);
            buttonList.add(answerButton);
            answerButton.setPrefWidth(250);

            answerButton.setOnAction(event -> {
                if (answer.equals(question.getCorrectAnswer())){
                    int tempScore = gameManager.currentPlayer.getScore();
                    gameManager.currentPlayer.setScore(tempScore+question.getValue());
                }else{
                    System.out.println("Wrong!");
                }
                continueButton.setVisible(true);
                for (Button b : buttonList){
                    b.setDisable(true);
                }
                Player tempCurrentPlayer = gameManager.currentPlayer;
                if (tempCurrentPlayer == gameManager.player1){
                    gameManager.currentPlayer = gameManager.player2;
                }else{
                    gameManager.currentPlayer = gameManager.player1;
                }
            });
            answersBox.getChildren().add(answerButton);
        }

        root.setCenter(answersBox);

        //Bottom
        continueButton.setVisible(false);
        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(continueButton);

        root.setBottom(bottomBox);

        //Scene
        scene = new Scene(root, 1200, 800);
    }

    public Scene getScene(){
        return scene;
    }
}
