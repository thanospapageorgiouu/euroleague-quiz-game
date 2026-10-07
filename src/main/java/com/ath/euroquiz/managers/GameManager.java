package com.ath.euroquiz.managers;

import com.ath.euroquiz.enums.Category;
import com.ath.euroquiz.loaders.JsonQuestionLoader;
import com.ath.euroquiz.models.Player;
import com.ath.euroquiz.models.Question;

import java.util.*;

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

        for (Category category : Category.values()){
            List<Question> q = JsonQuestionLoader.loadQuestions(category);
            questions.put(category, q);
        }
    }

    public Question getRandomQuestion(Category category, int value){
        List<Question> tempCategoryQuestions = questions.get(category);
        List<Question> categoryQuestions = new ArrayList<Question>();
        for (Question q : tempCategoryQuestions){
            if(q.getValue() == value){
                categoryQuestions.add(q);
            }
        }
        Random random = new Random();
        int index = random.nextInt(categoryQuestions.size());
        Question returnQuestion = categoryQuestions.get(index);
        tempCategoryQuestions.remove(index);
        return returnQuestion;
    }
}
