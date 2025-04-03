package com.example.takeanumbrella.ui.register;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.takeanumbrella.R;
import com.example.takeanumbrella.data.model.LoggedInUser;
import com.example.takeanumbrella.data.model.RegisterRepository;
import com.example.takeanumbrella.data.model.Result;

public class RegisterViewModel extends ViewModel {
    private final MutableLiveData<RegisterFormState> registerFormState = new MutableLiveData<>();
    private final MutableLiveData<RegisterResult> registerResult = new MutableLiveData<>();
    private final RegisterRepository registerRepository;

    RegisterViewModel(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    LiveData<RegisterFormState> getRegisterFormState() {
        return registerFormState;
    }

    LiveData<RegisterResult> getRegisterResult() {
        return registerResult;
    }

    public void register(
            String name,
            String phone,
            String email,
            String password) {
        // can be launched in a separate asynchronous job
        Result<RegisteredUser> result = registerRepository.register(
                name,
                phone,
                email,
                password);
        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            registerResult.setValue(new RegisterResult(new RegisteredUserView(data.getDisplayName())));
        } else {
            registerResult.setValue(new RegisterResult(R.string.login_failed));
        }
    }

    public void registerDataChanged(String name, String phone, String email, String password, String passwordRepeat) {
        if (!isNameValid(name)) {
            registerFormState.setValue(new RegisterFormState(R.string.invalid_username,
                    null,
                    null,
                    null,
                    null));
        } else if (!isPasswordValid(password)) {
            registerFormState.setValue(new RegisterFormState(null,
                    null,
                    null,
                    R.string.invalid_password,
                    null));
        } else {
            registerFormState.setValue(new RegisterFormState(true));
        }
    }

    private boolean isNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }

    private boolean isPasswordMatchValid(String password, String passwordRepeat) {
        return password != null && password.equals(passwordRepeat);
    }

    public void register() {

    }
}
