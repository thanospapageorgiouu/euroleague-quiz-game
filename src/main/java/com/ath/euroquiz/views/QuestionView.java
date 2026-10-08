package com.ath.euroquiz.views;

import com.ath.euroquiz.models.Player;
import com.ath.euroquiz.models.Question;
import com.ath.euroquiz.managers.GameManager;
import com.ath.euroquiz.enums.Category;

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

    public QuestionView(Stage stage, GameManager gameManager, Question question, BoardView boardView, Category category){
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
                gameManager.answerQuestion(question, answer);
                continueButton.setVisible(true);
                for (Button b : buttonList){
                    b.setDisable(true);
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
