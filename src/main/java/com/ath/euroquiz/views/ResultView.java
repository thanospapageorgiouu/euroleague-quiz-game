package com.ath.euroquiz.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.ath.euroquiz.models.Player;

public class ResultView {
    Stage stage;
    Player player;
    int totalQuestions;

    private Scene scene;

    public ResultView(Stage stage, Player player, int totalQuestions) {
        this.stage = stage;
        this.player = player;
        this.totalQuestions = totalQuestions;

        Label finish = new Label();
        Label playerName = new Label();
        Label scoreLabel = new Label();
        Label correctLabel = new Label();
        Label wrongLabel = new Label();
        Label accuracyLabel = new Label();
        Button mainMenu = new Button();

        finish.setText("FINAL SCORE");
        playerName.setText("Player: " + player.getName());

        int correctAnswers = player.getScore();
        int wrongAnswers = totalQuestions - correctAnswers;
        double accuracy = ((double) correctAnswers / totalQuestions) * 100;

        scoreLabel.setText(
                "Score: " + correctAnswers +
                        " / " + totalQuestions
        );

        correctLabel.setText("Correct Answers: " + correctAnswers);
        wrongLabel.setText("Wrong Answers: " + wrongAnswers);
        accuracyLabel.setText("Accuracy: " + String.format("%.1f", accuracy) + "%");

        mainMenu.setText("Main Menu");

        mainMenu.setOnAction(e -> {
            MainMenuView menu = new MainMenuView(stage);
            stage.setScene(menu.getScene());
        });

        finish.setStyle(
                "-fx-font-size: 32px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: gold;"
        );

        playerName.setStyle(
                "-fx-font-size: 22px;" +
                        "-fx-text-fill: white;"
        );

        scoreLabel.setStyle(
                "-fx-font-size: 24px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        correctLabel.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-text-fill: lightgreen;"
        );

        wrongLabel.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-text-fill: #ff6666;"
        );

        accuracyLabel.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-text-fill: gold;"
        );

        mainMenu.setPrefWidth(250);

        mainMenu.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-background-color: #2d2d2d;" +
                        "-fx-text-fill: white;"
        );

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        layout.setStyle(
                "-fx-background-color: #1a1a1a;"
        );

        layout.getChildren().addAll(
                finish,
                playerName,
                scoreLabel,
                correctLabel,
                wrongLabel,
                accuracyLabel,
                mainMenu
        );

        scene = new Scene(layout, 1280, 780);
    }

    public Scene getScene() {
        return scene;
    }
}