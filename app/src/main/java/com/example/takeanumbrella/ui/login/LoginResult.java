package com.example.takeanumbrella.ui.login;

import androidx.annotation.Nullable;

import com.example.takeanumbrella.ui.userview.ClientView;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private ClientView success;
    @Nullable
    private Integer error;

    LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    LoginResult(@Nullable ClientView success) {
        this.success = success;
    }

    @Nullable
    ClientView getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}