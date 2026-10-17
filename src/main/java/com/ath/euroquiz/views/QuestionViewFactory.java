package com.ath.euroquiz.views;

import com.ath.euroquiz.enums.Category;
import com.ath.euroquiz.enums.QuestionType;
import com.ath.euroquiz.managers.GameManager;
import com.ath.euroquiz.models.Question;
import javafx.stage.Stage;

public class QuestionViewFactory {
    public static BaseQuestionView create(Stage stage, GameManager gameManager, Question question, BoardView boardView, Category category){
        switch (category.getQuestionType()) {
            case MULTIPLE_CHOICE -> {
                return new MultipleChoiceView(stage, gameManager, question, boardView);
            }
            case IMAGE_TEXT -> {
                return new ImageTextView(stage, gameManager, question, boardView);
            }
            case MULTI_IMAGE_TEXT -> {
                return new MultiImageTextView(stage, gameManager, question, boardView);
            }
			case OVER_UNDER -> {
                return new OverUnderView(stage, gameManager, question, boardView);
            }
			case GUESS_SCORE -> {
                return new GuessScoreView(stage, gameManager, question, boardView);
            }
            default -> {
                throw new UnsupportedOperationException(String.valueOf(category.getQuestionType()));
            }
        }
    }
}
