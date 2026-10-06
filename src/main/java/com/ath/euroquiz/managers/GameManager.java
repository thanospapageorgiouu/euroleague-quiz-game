package com.ath.euroquiz.managers;

import com.ath.euroquiz.enums.Category;
import com.ath.euroquiz.loaders.JsonQuestionLoader;
import com.ath.euroquiz.models.Player;
import com.ath.euroquiz.models.Question;
import java.util.Random;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class GameManager {
    public Player player1 = new Player("Player 1");
    public Player player2 = new Player("Player 2");

    public Player currentPlayer;
    private Map<Category, List<Question>> questions;

    public GameManager(String playerName1, String playerName2){
        player1.setName(playerName1);
        player2.setName(playerName2);
        currentPlayer = player1;
        questions = new HashMap<>();

        for (Category catergory : Category.values()){
            List<Question> q = JsonQuestionLoader.loadQuestions(catergory);
            questions.put(catergory, q);
        }
    }

    public Question getRandomQuestion(Category category){
        List<Question> categoryQuestions = questions.get(category);
        Random random = new Random();
        int index = random.nextInt(categoryQuestions.size());
        Question returnQuestion = categoryQuestions.get(index);
        categoryQuestions.remove(index);
        return returnQuestion;
    }
}
