package com.ath.euroquiz.views;

import com.ath.euroquiz.managers.GameManager;
import com.ath.euroquiz.models.Question;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BaseQuestionView {
    protected Stage stage;
    protected GameManager gameManager;
    protected Question question;
    protected BoardView boardView;
    protected Scene scene;

    public BaseQuestionView(Stage stage, GameManager gameManager, Question question, BoardView boardView){
        this.stage = stage;
        this.gameManager = gameManager;
        this.question = question;
        this.boardView = boardView;
    }

    public Scene getScene(){
        return scene;
    }
}