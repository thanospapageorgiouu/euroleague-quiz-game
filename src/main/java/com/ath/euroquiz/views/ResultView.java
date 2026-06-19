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

        Label finish =  new Label();
        Label scoreLabel = new Label();
        Button MainMenu = new Button();

        finish.setText("Finish");
        scoreLabel.setText("Score: " + player.getScore() + " / " + totalQuestions);
        MainMenu.setText("Main Menu");

        MainMenu.setOnAction(e -> {
            MainMenuView menu = new MainMenuView(stage);
            stage.setScene(menu.getScene());
        });

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(finish, scoreLabel, MainMenu);

        scene = new Scene(layout, 1280, 780);
    }

    public Scene getScene() {
        return scene;
    }
}
