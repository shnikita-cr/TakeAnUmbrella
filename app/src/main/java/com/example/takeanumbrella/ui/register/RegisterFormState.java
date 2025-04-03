package com.example.takeanumbrella.ui.register;

import androidx.annotation.Nullable;

public class RegisterFormState {
    @Nullable
    private final Integer nameError;
    @Nullable
    private final Integer phoneError;
    @Nullable
    private final Integer emailError;
    @Nullable
    private final Integer passwordError;
    @Nullable
    private final Integer passwordRepeatError;
    private final boolean isDataValid;

    RegisterFormState(@Nullable Integer nameError, @Nullable Integer phoneError, @Nullable Integer emailError, @Nullable Integer passwordError, @Nullable Integer passwordRepeatError) {
        this.nameError = nameError;
        this.phoneError = phoneError;
        this.emailError = emailError;
        this.passwordError = passwordError;
        this.passwordRepeatError = passwordRepeatError;
        this.isDataValid = false;
    }

    RegisterFormState(boolean isDataValid) {
        this.nameError = null;
        this.phoneError = null;
        this.emailError = null;
        this.passwordError = null;
        this.passwordRepeatError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    public Integer getNameError() {
        return nameError;
    }

    @Nullable
    public Integer getPhoneError() {
        return phoneError;
    }

    @Nullable
    public Integer getEmailError() {
        return emailError;
    }

    @Nullable
    public Integer getPasswordError() {
        return passwordError;
    }

    @Nullable
    public Integer getPasswordRepeatError() {
        return passwordRepeatError;
    }

    boolean isDataValid() {
        return isDataValid;
    }
}
