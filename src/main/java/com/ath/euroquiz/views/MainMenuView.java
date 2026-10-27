package com.ath.euroquiz.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuView {

    private Scene scene;

    Label title = new Label();
    Button startButton =  new Button();
    Button settingsButton = new Button();
    Button exitButton =  new Button();

    public MainMenuView(Stage stage) {

        //Title Label
        title = new Label("Welcome to Euroquiz!");

        //Buttons
        startButton.setText("Start");
        settingsButton.setText("Settings");
        exitButton.setText("Exit");

        // Layout Creation
        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(title, startButton, settingsButton,exitButton);

        //Styling
        layout.setStyle("-fx-background-color: #1a1a1a;");

        title.setStyle(
                "-fx-font-size: 36px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        startButton.setPrefWidth(200);
        settingsButton.setPrefWidth(200);
        exitButton.setPrefWidth(200);

        startButton.setStyle(
                "-fx-background-color: #ff6b00;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;"
        );

        settingsButton.setStyle(
                "-fx-background-color: #e96eff;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 18px;"
        );

        exitButton.setStyle(
                "-fx-background-color: #444444;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 18px;"
        );

        //Buttons Actions
        startButton.setOnAction(e -> {
            GameCreationView gameCreationView = new GameCreationView(stage);
            stage.setScene(gameCreationView.getScene());
        });

        exitButton.setOnAction(e -> stage.close());

        scene = new  Scene(layout, 1280, 780);
    }

    public Scene getScene() {
        return scene;
    }
}
