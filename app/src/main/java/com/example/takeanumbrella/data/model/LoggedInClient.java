package com.example.takeanumbrella.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInClient {

    private final Long userId;
    private final String displayName;

    public LoggedInClient(Long userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}