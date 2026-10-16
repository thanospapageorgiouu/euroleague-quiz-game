package com.ath.euroquiz;

import com.ath.euroquiz.views.MainMenuView;
import javafx.application.Application;
import javafx.stage.Stage;

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