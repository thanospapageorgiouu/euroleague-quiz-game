package com.ath.euroquiz.enums;

public enum Category {
    HISTORY("History", "history_questions.json"),
    GEOGRAPHY("Geography", "geography_questions.json"),
    CLUB_COMBO("Club Combo", "club_combo_questions.json"),
    GOSSIP("Gossip", "gossip_questions.json"),
    GUESS_THE_SCORE("Guess the score", "guess_the_score_questions.json"),
    LOGO_QUIZ("Logo Quiz", "logo_quiz_questions.json"),
    MISSING_STARTER("Missing starter", "missing_starter_questions.json"),
    OVER_UNDER("Over/Under", "over_under_questions.json"),
    TOP_FIVE("Top 5", "top_five_questions.json"),
    TRANSFER_HISTORY("Transfer History", "transfer_history_questions.json");

    private String displayName;
    private final String fileName;

    Category(String DisplayName, String fileName) {
        this.displayName = DisplayName;
        this.fileName = fileName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getFileName() {
        return fileName;
    }
}
