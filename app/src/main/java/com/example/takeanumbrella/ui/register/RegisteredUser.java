package com.example.takeanumbrella.ui.register;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class RegisteredUser {

    private final String userId;
    private final String displayName;

    public RegisteredUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}