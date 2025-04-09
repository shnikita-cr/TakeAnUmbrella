package com.example.takeanumbrella.ui.login;

import androidx.annotation.Nullable;

import com.example.takeanumbrella.ui.userview.UserView;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private UserView success;
    @Nullable
    private Integer error;

    LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    LoginResult(@Nullable UserView success) {
        this.success = success;
    }

    @Nullable
    UserView getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}