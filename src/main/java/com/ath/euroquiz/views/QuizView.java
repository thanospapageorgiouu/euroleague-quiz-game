package com.ath.euroquiz.views;

import com.ath.euroquiz.enums.Difficulty;
import com.ath.euroquiz.loaders.JsonQuestionLoader;
import com.ath.euroquiz.models.Question;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.ath.euroquiz.models.Player;
import java.util.List;
import com.ath.euroquiz.managers.QuizManager;

import java.util.ArrayList;

public class QuizView {
    private Player player;
    private Label questionLabel;
    private Label scoreLabel;
    private Stage stage;
    private Scene scene;
    private int currentQuestionIndex;
    private Button nextButton;
    private Question currentQuestion;
    private Difficulty difficulty;
    private boolean questionAnswered = false;

    private List<Question> questions;
    private ArrayList<Button> buttons;
    private static int score;

    public QuizView(Stage stage, Player player, Difficulty difficulty) {
        this.stage = stage;
        this.player = player;
        this.difficulty = difficulty;

        buttons = new ArrayList<Button>();
        currentQuestionIndex = 0;
        player.setScore(0);

        scoreLabel = new Label("Score: " + score);
        nextButton = new Button("Next");
        nextButton.setVisible(false);

        //Question List creation
        loadQuestions(difficulty);

        //Take first question
        currentQuestion = questions.get(currentQuestionIndex);

        // Question Label
        questionLabel = new Label();
        questionLabel.setStyle("-fx-font-size: 22px;");

        // Answer Buttons
        Button answer1 = new Button();
        Button answer2 = new Button();
        Button answer3 = new Button();
        Button answer4 = new Button();

        buttons.add(answer1);
        buttons.add(answer2);
        buttons.add(answer3);
        buttons.add(answer4);

        updateQuestion();

        nextButton.setOnAction(e -> {
            if (currentQuestionIndex != questions.size() - 1){
                currentQuestionIndex++;
                currentQuestion = questions.get(currentQuestionIndex);
                updateQuestion();
            }else{
                ResultView resultView = new ResultView(stage, player, questions.size());
                stage.setScene(resultView.getScene());
            }
        });

        //answer checking
        for(Button button : buttons){
            button.setOnAction(e -> {checkAnswer(button, currentQuestion.getCorrectAnswer(), questionLabel, nextButton);});
        }

        // Layout
        VBox layout = new VBox(20);
        layout.setStyle("-fx-background-color: #1a1a1a;");

        questionLabel.setStyle(
                "-fx-font-size: 24px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        scoreLabel.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-text-fill: gold;"
        );

        for(Button button : buttons){
            button.setPrefWidth(300);

            button.setStyle(
                    "-fx-font-size: 16px;" +
                            "-fx-background-color: #2d2d2d;" +
                            "-fx-text-fill: white;"
            );
        }

        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(
                questionLabel,
                scoreLabel,
                answer1,
                answer2,
                answer3,
                answer4,
                nextButton
        );

        // Scene
        scene = new Scene(layout, 1280, 720);
    }

    public Scene getScene() {
        return scene;
    }

    //other methods
    private void checkAnswer(Button button, String correctAnswer, Label questionLabel, Button nextButton) {
        if (!questionAnswered){
            if(button.getText().equals(correctAnswer)){
                questionLabel.setText("Correct!");
                player.incrementScore();
                scoreLabel.setText("Score: " + player.getScore());
            }else{
                questionLabel.setText("Wrong!\nCorrect answer: " + correctAnswer);
            }
            questionAnswered = true;
            nextButton.setVisible(true);
        }
    }

    private void updateQuestion() {
        questionAnswered = false;
        questionLabel.setText(currentQuestion.getQuestionText());
        buttons.get(0).setText(currentQuestion.getAnswers().get(0));
        buttons.get(1).setText(currentQuestion.getAnswers().get(1));
        buttons.get(2).setText(currentQuestion.getAnswers().get(2));
        buttons.get(3).setText(currentQuestion.getAnswers().get(3));
        nextButton.setVisible(false);
    }

    private void loadQuestions(Difficulty difficulty){
        questions = JsonQuestionLoader.loadQuestions(difficulty);
        QuizManager quizManager = new QuizManager(questions, 10);
        questions = quizManager.getQuizQuestions();
    }
}