package com.example.takeanumbrella.ui.register;

import androidx.annotation.Nullable;

import com.example.takeanumbrella.ui.userview.ClientView;

public class RegisterResult {
    @Nullable
    private ClientView success;

    @Nullable
    private Integer error;

    RegisterResult(@Nullable Integer error) {
        this.error = error;
    }

    RegisterResult(@Nullable ClientView success) {
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
