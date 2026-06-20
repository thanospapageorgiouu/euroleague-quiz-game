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

    public  ResultView(Stage stage, Player player, int totalQuestions) {
        this.stage = stage;
        this.player = player;
        this.totalQuestions = totalQuestions;

        Label finish = new Label();
        Label playerName = new Label();
        Label scoreLabel = new Label();
        Button mainMenu = new Button();

        finish.setText("FINAL SCORE");
        playerName.setText("Player: " + player.getName());

        double accuracy = ((double) player.getScore() / totalQuestions) * 100;

        scoreLabel.setText(
                "Score: " + player.getScore() +
                        " / " + totalQuestions +
                        " (" + String.format("%.1f", accuracy) + "%)"
        );

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
                mainMenu
        );

        scene = new Scene(layout, 1280, 780);
    }

    public Scene getScene() {
        return scene;
    }
}
