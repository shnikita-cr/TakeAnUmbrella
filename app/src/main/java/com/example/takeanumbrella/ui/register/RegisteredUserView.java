package com.example.takeanumbrella.ui.register;

public class RegisteredUserView {
    private final String displayName;
    //... other data fields that may be accessible to the UI

    RegisteredUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}
