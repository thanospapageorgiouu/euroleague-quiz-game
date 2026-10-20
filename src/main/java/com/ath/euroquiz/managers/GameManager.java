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

    //TopFive Exclusive fields
    private Map<String, Integer> givenAnswers = new HashMap();
    private int correctAnswersCount = 0;
    private int falseAnswersCount = 0;
    private boolean wrongAnswerUsed = false;

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

    public boolean answerQuestion(Question question, String answer){
        //Answer check
        boolean correct = answer.trim().equalsIgnoreCase(question.getCorrectAnswer().trim());
        if (correct){
            currentPlayer.setScore(currentPlayer.getScore() + question.getValue());
        }
        //Switch turn
        if(currentPlayer == player1){
            currentPlayer = player2;
        }else{
            currentPlayer = player1;
        }
        return correct;
    }

    public int answerQuestionInt(Question question, String answerPre){
        //13 for 5/5
        String answer = answerPre.trim().toLowerCase();
        if (givenAnswers.containsKey(answer)){
            if(givenAnswers.get(answer) >= 1 && givenAnswers.get(answer) <= 5){
                //Returns 10 for 2nd time given same correct answer
                return 10;
            }else if(givenAnswers.get(answer) == -1){
                //Returns 11 for second time given same wrong answer
                return 11;
            }
        }else{
            for (int i = 0; i < question.getAnswers().size(); i++){
                if (question.getAnswers().get(i).trim().equalsIgnoreCase(answer.trim())){
                    givenAnswers.put(answer, i + 1);
                    correctAnswersCount++;
                    return i+1;
                }
            }
            if (!wrongAnswerUsed){
                givenAnswers.put(answer, -1);
                wrongAnswerUsed = true;
                falseAnswersCount++;
                return -1;
            }else{
                //Returns 12 for 2nd wrong given answer - question ends
                falseAnswersCount++;
                return 12;
            }
        }
        return 0;
    }

    public void resetTopFiveState(){
        givenAnswers.clear();
        correctAnswersCount = 0;
        falseAnswersCount = 0;
        wrongAnswerUsed = false;
    }

    public void finishTopFiveQuestion(){
        if (correctAnswersCount == 5){
            currentPlayer.setScore(currentPlayer.getScore() + 300);
        }else if (correctAnswersCount == 4){
            currentPlayer.setScore(currentPlayer.getScore() + 100);
        }
        if(currentPlayer == player1){
            currentPlayer = player2;
        }else{
            currentPlayer = player1;
        }
    }

    public boolean checkFinished(){
        return correctAnswersCount == 5 || falseAnswersCount == 2;
    }
}
