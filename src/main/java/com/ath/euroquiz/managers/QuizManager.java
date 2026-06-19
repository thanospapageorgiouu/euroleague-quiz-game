package com.ath.euroquiz.managers;

import com.ath.euroquiz.models.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class QuizManager {
    private List<Question> quizQuestions;

     public QuizManager(List<Question> allQuestions, int questionCount) {
         quizQuestions = new ArrayList<>(allQuestions);
         Collections.shuffle(quizQuestions);
         if(quizQuestions.size() > questionCount) {
             quizQuestions =  quizQuestions.subList(0, questionCount);
         }
     }

     //getters
    public List<Question> getQuizQuestions() {
        return quizQuestions;
    }
}
