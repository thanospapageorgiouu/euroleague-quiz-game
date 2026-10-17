package com.ath.euroquiz.views;

import com.ath.euroquiz.managers.GameManager;
import com.ath.euroquiz.models.Question;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;

public class GuessScoreView extends BaseQuestionView{
	public GuessScoreView(Stage stage, GameManager gameManager, Question question, BoardView boardView){
		super(stage, gameManager, question, boardView);

		Label questionLabel = new Label(question.getQuestionText());

		HBox hbox = new HBox();
		hbox.setSpacing(20);
		hbox.setAlignment(Pos.CENTER);

		for(String i : question.getImagePaths()){
			Image image = new Image(getClass().getResource(i).toExternalForm());
			ImageView imageView = new ImageView(image);
			imageView.setFitWidth(250);
			imageView.setFitHeight(250);
			imageView.setPreserveRatio(true);
			hbox.getChildren().add(imageView);
		}

		TextField homeTeamScore = new TextField();
		TextField awayTeamScore = new TextField();

		homeTeamScore.setTextFormatter(new TextFormatter<>(change ->
				change.getControlNewText().matches("\\d*") ? change : null
		));

		awayTeamScore.setTextFormatter(new TextFormatter<>(change ->
				change.getControlNewText().matches("\\d*") ? change : null
		));

		homeTeamScore.setMaxWidth(150);
		awayTeamScore.setMaxWidth(150);

		HBox hbox2 = new HBox(homeTeamScore, awayTeamScore);
		hbox2.setSpacing(20);
		hbox2.setAlignment(Pos.CENTER);

		Label resultLabel = new Label();
		Button submitButton = new Button("Submit");

		Button continueButton = new Button("Continue");
		continueButton.setManaged(false);
		continueButton.setOnAction(event1 -> {
			boardView.updateScore();
			stage.setScene(boardView.getScene());
		});

		submitButton.setOnAction(event -> {
			if (homeTeamScore.getText().isBlank() || awayTeamScore.getText().isBlank()){
				resultLabel.setText("Please enter both team scores!");
			}else{
				submitButton.setDisable(true);
				continueButton.setVisible(true);
				continueButton.setManaged(true);
				String answer = homeTeamScore.getText() + "-" + awayTeamScore.getText();
				boolean correct = gameManager.answerQuestion(question, answer);
				if (correct){
					resultLabel.setText("Correct answer!");
				}else{
					resultLabel.setText("Correct answer: " + question.getCorrectAnswer());
				}
			}
		});

		VBox vBox = new VBox();
		vBox.getChildren().addAll(questionLabel, hbox, hbox2, submitButton, resultLabel, continueButton);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(15);

		StackPane root = new StackPane(vBox);

		scene = new Scene(root, 1200, 800);
	}
}