package com.ath.euroquiz.views;

import com.ath.euroquiz.enums.Category;
import com.ath.euroquiz.managers.GameManager;
import com.ath.euroquiz.models.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuView {

    private Scene scene;

    Label title = new Label();
    Button startButton =  new Button();
    Button exitButton =  new Button();
    Label namePromptPlayer1 = new Label();
    Label namePromptPlayer2 = new Label();

    public MainMenuView(Stage stage) {

        //Title Label
        title = new Label("Welcome to Euroquiz!");

        // Players Name textFields
        VBox player1Box = new VBox(10);
        VBox player2Box = new VBox(10);
        HBox playersBox = new HBox(180);

        player1Box.setAlignment(Pos.CENTER);
        player2Box.setAlignment(Pos.CENTER);
        playersBox.setAlignment(Pos.CENTER);

        TextField player1NameField = new TextField();
        TextField player2NameField = new TextField();

        player1NameField.setMaxWidth(200);
        player2NameField.setMaxWidth(200);

        namePromptPlayer1.setText("Player 1 Name:");
        namePromptPlayer2.setText("Player 2 Name:");

        player1Box.getChildren().addAll(
                namePromptPlayer1,
                player1NameField
        );

        player2Box.getChildren().addAll(
                namePromptPlayer2,
                player2NameField
        );

        playersBox.getChildren().addAll(
                player1Box,
                player2Box
        );

        //Buttons
        startButton.setText("Start");
        exitButton.setText("Exit");

        // Layout Creation
        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(
                title,
                playersBox,
                startButton,
                exitButton
        );

        //Styling
        layout.setStyle("-fx-background-color: #1a1a1a;");

        title.setStyle(
                "-fx-font-size: 36px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        namePromptPlayer1.setStyle(
                "-fx-font-size: 22px;" +
                        "-fx-text-fill: white;"
        );

        namePromptPlayer2.setStyle(
                "-fx-font-size: 22px;" +
                        "-fx-text-fill: white;"
        );

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
            GameManager gameManager = new GameManager(player1NameField.getText(), player2NameField.getText());
            BoardView boardView = new BoardView(stage, gameManager);
            stage.setScene(boardView.getScene());
        });

        exitButton.setOnAction(e -> stage.close());

        scene = new  Scene(layout, 1280, 780);
    }

    public Scene getScene() {
        return scene;
    }
}
