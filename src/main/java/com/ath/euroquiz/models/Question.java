package com.ath.euroquiz.models;

import com.ath.euroquiz.enums.QuestionType;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> answers;
    private String correctAnswer;
    private int value;
    private QuestionType type;

    public Question(String questionText, List<String> answers, String correctAnswer, int value) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.value = value;
    }

    public Question() {}

    //Getters
    public String getQuestionText(){return questionText;}
    public List<String> getAnswers(){return answers;}
    public String getCorrectAnswer(){return correctAnswer;}
    public int getValue(){return value;}
    public QuestionType getType(){return type;}
}