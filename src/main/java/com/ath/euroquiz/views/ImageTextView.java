package com.ath.euroquiz.views;

import com.ath.euroquiz.managers.GameManager;
import com.ath.euroquiz.models.Question;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;

public class ImageTextView extends BaseQuestionView{
    public ImageTextView(Stage stage, GameManager gameManager, Question question, BoardView boardView){
        super(stage, gameManager, question, boardView);
        Label questionLabel = new Label(question.getQuestionText());
        Image image = new Image(getClass().getResource(question.getImagePaths().getFirst()).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);

        TextField answerField = new TextField();

        Label resultLabel = new Label();

        Button continueButton = new Button("Continue");
        continueButton.setVisible(false);
        continueButton.setOnAction(event1 -> {
            boardView.updateScore();
            stage.setScene(boardView.getScene());
        });

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            submitButton.setDisable(true);
            continueButton.setVisible(true);
            String answer = answerField.getText();
            boolean correct = gameManager.answerQuestion(question, answer);
            if (correct){
                resultLabel.setText("Correct answer!");
            }else{
                resultLabel.setText("Correct answer: " + question.getCorrectAnswer());
            }
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(questionLabel, imageView, answerField, submitButton, resultLabel, continueButton);
        vBox.setSpacing(15);

        scene = new Scene(vBox, 1200, 800);
    }
}