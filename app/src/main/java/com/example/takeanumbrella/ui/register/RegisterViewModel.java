package com.example.takeanumbrella.ui.register;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.takeanumbrella.R;
import com.example.takeanumbrella.data.Client.Client;
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

    public void register(String name, String phone, String email, String password) {
        Result<Client> result = registerRepository.register(name, phone, email, password);
        if (result instanceof Result.Success) {
            Client client = ((Result.Success<Client>) result).getData();
            registerResult.setValue(new RegisterResult(new RegisteredUserView(client.getName())));
        } else {
            registerResult.setValue(new RegisterResult(R.string.registration_failed));
        }
    }

    public void registerDataChanged(String name, String phone, String email, String password, String passwordRepeat) {
        if (!isNameValid(name)) {
            registerFormState.setValue(new RegisterFormState(
                    R.string.invalid_name,
                    null,
                    null,
                    null,
                    null));
        } else if (!isPhoneValid(phone)) {
            registerFormState.setValue(new RegisterFormState(
                    null,
                    R.string.invalid_phone,
                    null,
                    null,
                    null));
        } else if (!isEmailValid(email)) {
            registerFormState.setValue(new RegisterFormState(
                    null,
                    null,
                    R.string.email_invalid,
                    null,
                    null));
        } else if (!isPasswordValid(password)) {
            registerFormState.setValue(new RegisterFormState(
                    null,
                    null,
                    null,
                    R.string.invalid_password,
                    null));
        } else if (!isPasswordsValid(password, passwordRepeat)) {
            registerFormState.setValue(new RegisterFormState(
                    null,
                    null,
                    null,
                    null,
                    R.string.invalid_passwordRepeat));
        } else {
            registerFormState.setValue(new RegisterFormState(true));
        }
    }

    private boolean isNameValid(String name) {
        return name != null && name.matches("^[A-Za-z][A-Za-z'\\-]+([ A-Za-z][A-Za-z'\\-]+)*");
    }

    private boolean isPhoneValid(String phone) {
        return phone != null && Patterns.PHONE.matcher(phone).matches();
    }

    private boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }
        if (email.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        } else {
            return !email.trim().isEmpty();
        }
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() >= 5;
    }

    private boolean isPasswordsValid(String password, String passwordRepeat) {
        return password.equals(passwordRepeat);
    }
}
