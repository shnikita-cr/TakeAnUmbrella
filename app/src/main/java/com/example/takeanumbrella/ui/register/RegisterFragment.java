package com.example.takeanumbrella.ui.register;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.takeanumbrella.R;
import com.example.takeanumbrella.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {
    ProgressBar loadingProgressBar;
    private RegisterViewModel registerViewModel;
    private FragmentRegisterBinding binding;
    private TextView clientName;
    private TextView clientPhone;
    private TextView clientEmail;
    private TextView clientPassword;
    private TextView clientPasswordRepeat;
    private Button registerButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerViewModel = new ViewModelProvider(this, new RegisterModelFactory())
                .get(RegisterViewModel.class);
        clientName = binding.registerName;
        clientPhone = binding.registerPhone;
        clientEmail = binding.registerEmail;
        clientPassword = binding.registerPassword;
        clientPasswordRepeat = binding.registerPasswordRepeat;
        registerButton = binding.registerButton;
        loadingProgressBar = binding.loading;

        registerViewModel.getRegisterFormState().observe(getViewLifecycleOwner(), new Observer<RegisterFormState>() {
            @Override
            public void onChanged(@Nullable RegisterFormState registerFormState) {
                if (registerFormState == null) {
                    return;
                }
                registerButton.setEnabled(registerFormState.isDataValid());
                if (registerFormState.getNameError() != null) {
                    clientName.setError(getString(registerFormState.getNameError()));
                }
                if (registerFormState.getPhoneError() != null) {
                    clientPhone.setError(getString(registerFormState.getPhoneError()));
                }
                if (registerFormState.getEmailError() != null) {
                    clientEmail.setError(getString(registerFormState.getEmailError()));

                }
                if (registerFormState.getPasswordError() != null) {
                    clientPassword.setError(getString(registerFormState.getPasswordError()));
                }
                if (registerFormState.getPasswordRepeatError() != null) {
                    clientPasswordRepeat.setError(getString(registerFormState.getPasswordRepeatError()));
                }
            }
        });

        registerViewModel.getRegisterResult().observe(getViewLifecycleOwner(), new Observer<RegisterResult>() {
            @Override
            public void onChanged(@Nullable RegisterResult registerResult) {
                if (registerResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (registerResult.getError() != null) {
                    showRegisterFailed(registerResult.getError());
                }
                if (registerResult.getSuccess() != null) {
                    updateUiWithUser(registerResult.getSuccess());
                }
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                registerViewModel.registerDataChanged(
                        clientName.getText().toString(),
                        clientPhone.getText().toString(),
                        clientEmail.getText().toString(),
                        clientPassword.getText().toString(),
                        clientPasswordRepeat.getText().toString()
                );
            }
        };
        clientName.addTextChangedListener(afterTextChangedListener);
        clientPassword.addTextChangedListener(afterTextChangedListener);
        clientPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    registerViewModel.register(
                            clientName.getText().toString(),
                            clientPhone.getText().toString(),
                            clientEmail.getText().toString(),
                            clientPassword.getText().toString()
                    );
                }
                return false;
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                registerViewModel.register(
                        clientName.getText().toString(),
                        clientPhone.getText().toString(),
                        clientEmail.getText().toString(),
                        clientPassword.getText().toString()
                );
            }
        });
    }

    private void updateUiWithUser(RegisteredUserView model) {
        String welcome = getString(R.string.welcome_register) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        if (getContext() != null && getContext().getApplicationContext() != null) {
            Toast.makeText(getContext().getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
        }
    }

    private void showRegisterFailed(@StringRes Integer errorString) {
        if (getContext() != null && getContext().getApplicationContext() != null) {
            Toast.makeText(
                    getContext().getApplicationContext(),
                    errorString,
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}