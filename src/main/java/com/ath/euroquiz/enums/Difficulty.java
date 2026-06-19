package com.ath.euroquiz.enums;

public enum Difficulty {
    EASY("easy_questions.json"),
    MEDIUM("medium_questions.json"),
    HARD("hard_questions.json");

    private final String fileName;

    Difficulty(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
