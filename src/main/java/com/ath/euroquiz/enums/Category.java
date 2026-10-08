package com.ath.euroquiz.enums;

import com.ath.euroquiz.enums.QuestionType;

public enum Category {
    HISTORY("History", "history_questions.json", QuestionType.MULTIPLE_CHOICE),
    GEOGRAPHY("Geography", "geography_questions.json", QuestionType.MULTIPLE_CHOICE),
    GOSSIP("Gossip", "gossip_questions.json", QuestionType.MULTIPLE_CHOICE),

    CLUB_COMBO("Club Combo", "club_combo_questions.json", QuestionType.MULTI_IMAGE_TEXT),
    TRANSFER_HISTORY("Transfer History", "transfer_history_questions.json", QuestionType.MULTI_IMAGE_TEXT),

    GUESS_THE_SCORE("Guess the score", "guess_the_score_questions.json", QuestionType.GUESS_SCORE),

    LOGO_QUIZ("Logo Quiz", "logo_quiz_questions.json", QuestionType.IMAGE_TEXT),
    MISSING_STARTER("Missing starter", "missing_starter_questions.json", QuestionType.IMAGE_TEXT),

    OVER_UNDER("Over/Under", "over_under_questions.json", QuestionType.OVER_UNDER),

    TOP_FIVE("Top 5", "top_five_questions.json" ,QuestionType.TOP_FIVE);

    private String displayName;
    private final String fileName;
    private final QuestionType questionType;

    Category(String DisplayName, String fileName, QuestionType questionType) {
        this.displayName = DisplayName;
        this.fileName = fileName;
        this.questionType = questionType;
    }

    public String getDisplayName() {
        return displayName;
    }
    public String getFileName() {
        return fileName;
    }
    public QuestionType getQuestionType() {return questionType;}
}
