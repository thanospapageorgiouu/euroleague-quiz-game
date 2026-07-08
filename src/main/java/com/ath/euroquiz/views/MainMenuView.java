package com.ath.euroquiz.views;

import com.ath.euroquiz.enums.Category;
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
        RadioButton history =  new RadioButton("History");
        RadioButton geography =  new RadioButton("Geography");
        RadioButton mvp =  new RadioButton("MVP");

        ToggleGroup group = new ToggleGroup();

        history.setToggleGroup(group);
        geography.setToggleGroup(group);
        mvp.setToggleGroup(group);
        history.setSelected(true); //Default Difficulty

        history.setUserData(Category.HISTORY);
        geography.setUserData(Category.GEOGRAPHY);
        mvp.setUserData(Category.MVP);

        //Start - Exit Buttons
        startButton = new Button("Start");
        exitButton = new Button("Exit");

        //Difficulty VBox
        VBox difficultyBox = new VBox(10);
        difficultyBox.setAlignment(Pos.CENTER);

        difficultyBox.getChildren().addAll(
                history,
                geography,
                mvp
        );

        history.setMinWidth(200);
        geography.setMinWidth(200);
        mvp.setMinWidth(200);

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

        history.setStyle("-fx-text-fill: white;");
        geography.setStyle("-fx-text-fill: white;");
        mvp.setStyle("-fx-text-fill: white;");

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
            Category category = (Category) group.getSelectedToggle().getUserData();
            Player player = new Player(playerNameField.getText());
            QuizView quizView = new QuizView(stage, player, category);
            stage.setScene(quizView.getScene());
            System.out.println(category);
        });
        exitButton.setOnAction(e -> stage.close());

        scene = new  Scene(layout, 1280, 780);
    }

    public Scene getScene() {
        return scene;
    }
}
