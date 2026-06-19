package com.ath.euroquiz;

import com.ath.euroquiz.views.MainMenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

import com.ath.euroquiz.views.QuizView;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        MainMenuView menu = new MainMenuView(stage);

        stage.setTitle("EuroLeague Quiz Game");
        stage.setScene(menu.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}