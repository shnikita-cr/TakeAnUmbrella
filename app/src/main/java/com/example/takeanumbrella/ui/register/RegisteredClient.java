package com.example.takeanumbrella.ui.register;

public class RegisteredClient {

    private final Long userId;
    private final String displayName;

    public RegisteredClient(Long userId, String displayName) {
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