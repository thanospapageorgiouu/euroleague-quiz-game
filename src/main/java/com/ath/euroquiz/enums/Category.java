package com.ath.euroquiz.enums;

public enum Category {
    HISTORY("history_questions.json"),
    GEOGRAPHY("geography_questions.json"),
    MVP("mvp_questions.json");

    private final String fileName;

    Category(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
