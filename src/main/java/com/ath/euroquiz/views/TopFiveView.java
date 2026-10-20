package com.ath.euroquiz.views;

import com.ath.euroquiz.managers.GameManager;
import com.ath.euroquiz.models.Question;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.GridPane;

public class TopFiveView extends BaseQuestionView{
	Label resultLabel = new Label();
	List<Label> labelList = new ArrayList<>();
	Label questionLabel;
	Button continueButton = new Button("Continue");
	TextField answerField = new TextField();
	Button submitButton = new Button("Submit");

	public TopFiveView(Stage stage, GameManager gameManager, Question question, BoardView boardView){
		super(stage, gameManager, question, boardView);
		questionLabel = new Label(question.getQuestionText());
		gameManager.resetTopFiveState();

		questionLabel.setWrapText(true);

		GridPane gridPane = new GridPane();
		gridPane.setHgap(30);
		gridPane.setVgap(30);
		gridPane.setAlignment(Pos.CENTER);
		for (int i = 0; i<=5; i++){
			Label label = new Label(Integer.toString(i+1));
			labelList.add(label);
			label.setAlignment(Pos.CENTER);
			label.setMinWidth(100);
			label.setMinHeight(100);
			gridPane.add(label, i % 3, i / 3);
		}

		continueButton.setManaged(false);
		continueButton.setVisible(false);
		continueButton.setOnAction(event1 -> {
			boardView.updateScore();
			stage.setScene(boardView.getScene());
		});

		answerField.setPromptText("Enter your guess");

		submitButton.setOnAction(event -> {
			if (answerField.getText().isBlank()){
				resultLabel.setText("Please enter an answer!");
			}else{
				String answer = answerField.getText();
				int answerPosition = gameManager.answerQuestionInt(question, answer);
				if(answerPosition >= 1 && answerPosition <= 5){
					labelList.get(answerPosition - 1).setText(answer);
					if (gameManager.checkFinished()){
						//O paiktis ta vrike ola
						finishQuestion(true);
					}
				}else if(answerPosition == -1){
					//Wrong answer
					labelList.get(5).setText(answer);
				}else if(answerPosition == 10){
					//Xeirismos diplis swstis apantisis
					resultLabel.setText("Please enter a different answer!");
				}else if(answerPosition == 11){
					//Xeirismos diplis lathos apantisis
					resultLabel.setText("Please enter a different answer!");
				}else if(answerPosition == 12){
					//O paiktis exase
					finishQuestion(false);
				}
			}
			answerField.clear();
		});

		VBox vBox = new VBox();
		vBox.getChildren().addAll(questionLabel, gridPane, answerField, submitButton, resultLabel, continueButton);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(15);

		StackPane root = new StackPane(vBox);

		scene = new Scene(root, 1200, 800);
	}

	private void finishQuestion(boolean allCorrect){
		gameManager.finishTopFiveQuestion();
		if (allCorrect){
			resultLabel.setText("Congratulations, 5/5!");
		}else{
			resultLabel.setText("Wrong! Correct answers are shown!");
			for (int i = 0; i < question.getAnswers().size(); i++){
				labelList.get(i).setText(question.getAnswers().get(i));
			}

		}

		submitButton.setManaged(false);
		submitButton.setVisible(false);
		continueButton.setManaged(true);
		continueButton.setVisible(true);
	}
}