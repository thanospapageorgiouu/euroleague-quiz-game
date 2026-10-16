package com.ath.euroquiz.views;

import com.ath.euroquiz.managers.GameManager;
import com.ath.euroquiz.models.Question;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class OverUnderView extends BaseQuestionView{
    public OverUnderView(Stage stage, GameManager gameManager, Question question, BoardView boardView){
        super(stage, gameManager, question, boardView);

        Label questionLabel = new Label(question.getQuestionText());
        questionLabel.setWrapText(true);

        Button overButton = new Button(question.getAnswers().get(0));
        Button underButton = new Button(question.getAnswers().get(1));
        List<Button> answerButtons = List.of(overButton, underButton);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(20);
        hbox.getChildren().addAll(overButton, underButton);

        Label resultLabel = new Label();

        Button continueButton = new Button("Continue");
        continueButton.setVisible(false);
        continueButton.setOnAction(event1 -> {
            boardView.updateScore();
            stage.setScene(boardView.getScene());
        });

        for (Button b : answerButtons){
            b.setOnAction(event -> {
                overButton.setDisable(true);
                underButton.setDisable(true);
                continueButton.setVisible(true);
                boolean correct = gameManager.answerQuestion(question, b.getText());
                if (correct){
                    resultLabel.setText("Correct answer!");
                }else{
                    resultLabel.setText("Wrong! Correct answer was: " + question.getCorrectAnswer());
                }
            });
        }

        VBox vBox = new VBox();
        vBox.getChildren().addAll(questionLabel, hbox, resultLabel, continueButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(15);

        StackPane root = new StackPane(vBox);

        scene = new Scene(root, 1200, 800);
    }
}