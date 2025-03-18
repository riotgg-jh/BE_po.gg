package com.riot.pogg.duofinder.category;

public enum CategoryType {
    SOLO_RANK("솔로랭크"),
    FLEX_RANK("자유랭크"),
    NORMAL("일반");

    private final String displayName;

    CategoryType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
