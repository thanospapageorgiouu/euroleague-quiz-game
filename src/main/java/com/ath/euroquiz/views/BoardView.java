package com.ath.euroquiz.views;

import com.ath.euroquiz.enums.Category;
import com.ath.euroquiz.managers.GameManager;
import com.ath.euroquiz.models.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BoardView {

    private final Scene scene;

    public BoardView(Stage stage, GameManager gameManager) {

        BorderPane root = new BorderPane();
        Player player1 = gameManager.player1;
        Player player2 = gameManager.player2;

        // ---------- TOP ----------
        Label player1Name = new Label(player1.getName());
        Label player2Name = new Label(player2.getName());
        Label score = new Label(player1.getScore() + " - " + player2.getScore());

        player1Name.setStyle("-fx-font-size: 20;");
        player2Name.setStyle("-fx-font-size: 20;");
        score.setStyle("-fx-font-size: 20;");
        HBox topBox = new HBox(350);
        topBox.setAlignment(Pos.CENTER);

        topBox.getChildren().addAll(
                player1Name,
                score,
                player2Name
        );

        root.setTop(topBox);

        // ---------- CENTER ----------
        GridPane boardGrid = new GridPane();

        boardGrid.setAlignment(Pos.CENTER);
        boardGrid.setHgap(30);
        boardGrid.setVgap(30);

        root.setCenter(boardGrid);

        int x = 0;
        for(Category category : Category.values()) {
            VBox box = new VBox();
            box.setAlignment(Pos.TOP_CENTER);
            Label categoryName = new Label(category.getDisplayName());
            categoryName.setStyle("""
            -fx-text-fill: white;
            -fx-font-size: 18;
            -fx-font-weight: bold;
            """);
            box.getChildren().add(categoryName);
            box.setPrefSize(150, 250);
            box.setSpacing(10);
            box.setStyle("""
            -fx-background-color: #2d2d2d;
            -fx-border-color: gold;
            """);

            for (int i = 1; i <= 3; i++) {
                Button button = new Button(String.valueOf(i * 100));
                button.setStyle("""
                -fx-font-size: 20;
                -fx-background-color: gold
                """);
                box.getChildren().add(button);
            }

            boardGrid.add(box, x % 5, x % 2);
            x++;
        }

        // ---------- SCENE ----------
        scene = new Scene(root, 1200, 800);
    }

    public Scene getScene() {
        return scene;
    }
}