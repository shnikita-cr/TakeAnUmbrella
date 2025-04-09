package com.example.takeanumbrella.ui.register;

import androidx.annotation.Nullable;

import com.example.takeanumbrella.ui.userview.UserView;

public class RegisterResult {
    @Nullable
    private UserView success;
  
    @Nullable
    private Integer error;

    RegisterResult(@Nullable Integer error) {
        this.error = error;
    }

    RegisterResult(@Nullable UserView success) {
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
