package com.ath.euroquiz.views;

import com.ath.euroquiz.enums.Category;
import com.ath.euroquiz.managers.GameManager;
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
        RadioButton club_combo =  new RadioButton("Club Combo");
        RadioButton missing_starter =  new RadioButton("Missing Starter");
        RadioButton guess_the_score =  new RadioButton("Guess the Score");
        RadioButton over_under =  new RadioButton("Over Under");
        RadioButton gossip =  new RadioButton("Gossip");
        RadioButton transfer_history =  new RadioButton("Transfer History");
        RadioButton logo_quiz =  new RadioButton("Logo Quiz");
        RadioButton top_five =  new RadioButton("Top 5");

        ToggleGroup group = new ToggleGroup();

        history.setToggleGroup(group);
        geography.setToggleGroup(group);
        club_combo.setToggleGroup(group);
        missing_starter.setToggleGroup(group);
        guess_the_score.setToggleGroup(group);
        over_under.setToggleGroup(group);
        gossip.setToggleGroup(group);
        transfer_history.setToggleGroup(group);
        logo_quiz.setToggleGroup(group);
        top_five.setToggleGroup(group);

        history.setSelected(true); //Default Difficulty

        history.setUserData(Category.HISTORY);
        geography.setUserData(Category.GEOGRAPHY);
        club_combo.setUserData(Category.CLUB_COMBO);
        missing_starter.setUserData(Category.MISSING_STARTER);
        guess_the_score.setUserData(Category.GUESS_THE_SCORE);
        over_under.setUserData(Category.OVER_UNDER);
        gossip.setUserData(Category.GOSSIP);
        transfer_history.setUserData(Category.TRANSFER_HISTORY);
        logo_quiz.setUserData(Category.LOGO_QUIZ);
        top_five.setUserData(Category.TOP_FIVE);

        //Start - Exit Buttons
        startButton = new Button("Start");
        exitButton = new Button("Exit");

        //Difficulty VBox
        VBox difficultyBox = new VBox(10);
        difficultyBox.setAlignment(Pos.CENTER);

        difficultyBox.getChildren().addAll(
                history,
                geography,
                club_combo,
                missing_starter,
                guess_the_score,
                over_under,
                gossip,
                transfer_history,
                logo_quiz,
                top_five
        );

        history.setMinWidth(200);
        geography.setMinWidth(200);
        club_combo.setMinWidth(200);
        missing_starter.setMinWidth(200);
        guess_the_score.setMinWidth(200);
        over_under.setMinWidth(200);
        gossip.setMinWidth(200);
        transfer_history.setMinWidth(200);
        logo_quiz.setMinWidth(200);
        top_five.setMinWidth(200);

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
        club_combo.setStyle("-fx-text-fill: white;");
        missing_starter.setStyle("-fx-text-fill: white;");
        guess_the_score.setStyle("-fx-text-fill: white;");
        over_under.setStyle("-fx-text-fill: white;");
        gossip.setStyle("-fx-text-fill: white;");
        transfer_history.setStyle("-fx-text-fill: white;");
        logo_quiz.setStyle("-fx-text-fill: white;");
        top_five.setStyle("-fx-text-fill: white;");

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
            GameManager gameManager = new GameManager();
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
