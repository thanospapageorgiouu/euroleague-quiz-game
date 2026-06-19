package com.ath.euroquiz.views;

import com.ath.euroquiz.enums.Difficulty;
import com.ath.euroquiz.models.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuView {

    private Scene scene;

    Label title = new Label();
    Button startButton =  new Button();
    Button exitButton =  new Button();
    Label namePrompt = new Label();

    public MainMenuView(Stage stage) {

        //Title Label
        title = new Label("Welcome to Euroquiz!");

        //Player Name textField
        TextField playerNameField = new TextField();
        playerNameField.setMaxWidth(200.0);
        namePrompt.setText("Player Name:");

        //Difficulty select
        RadioButton easy =  new RadioButton("Easy");
        RadioButton medium =  new RadioButton("Medium");
        RadioButton hard =  new RadioButton("Hard");

        ToggleGroup group = new ToggleGroup();

        easy.setToggleGroup(group);
        medium.setToggleGroup(group);
        hard.setToggleGroup(group);
        easy.setSelected(true); //Default Difficulty

        easy.setUserData(Difficulty.EASY);
        medium.setUserData(Difficulty.MEDIUM);
        hard.setUserData(Difficulty.HARD);

        //Start - Exit Buttons
        startButton = new Button("Start");
        exitButton = new Button("Exit");

        //Difficulty VBox
        VBox difficultyBox = new VBox(10);
        difficultyBox.setAlignment(Pos.CENTER);

        difficultyBox.getChildren().addAll(
                easy,
                medium,
                hard
        );

        easy.setMinWidth(200);
        medium.setMinWidth(200);
        hard.setMinWidth(200);

        //Layout Creation
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(title, namePrompt, playerNameField, difficultyBox, startButton, exitButton);

        //Styling
        layout.setStyle("-fx-background-color: #1a1a1a;");

        title.setStyle(
                "-fx-font-size: 36px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        namePrompt.setStyle(
                "-fx-font-size: 22px;" +
                        "-fx-text-fill: white;"
        );

        easy.setStyle("-fx-text-fill: white;");
        medium.setStyle("-fx-text-fill: white;");
        hard.setStyle("-fx-text-fill: white;");

        startButton.setPrefWidth(200);
        exitButton.setPrefWidth(200);

        startButton.setStyle(
                "-fx-background-color: #ff6b00;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;"
        );

        exitButton.setStyle(
                "-fx-background-color: #444444;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 18px;"
        );

        //Buttons Actions
        startButton.setOnAction(e -> {
            Difficulty difficulty = (Difficulty) group.getSelectedToggle().getUserData();
            Player player = new Player(playerNameField.getText());
            QuizView quizView = new QuizView(stage, player, difficulty);
            stage.setScene(quizView.getScene());
            System.out.println(difficulty);
        });
        exitButton.setOnAction(e -> stage.close());

        scene = new  Scene(layout, 1280, 780);
    }

    public Scene getScene() {
        return scene;
    }
}
