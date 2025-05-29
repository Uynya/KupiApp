package com.example.kupiapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AutoAct extends AppCompatActivity {

    TextInputLayout emailLayout, passwordLayout;
    TextInputEditText emailEditText, passwordEditText;
    TextView errorMsg;
    Boolean checkEmail = false;
    Boolean checkPass = false;
    String UserEmail;
    String UserPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            UserEmail = arguments.get("email").toString();
            UserPass = arguments.get("password").toString();
        }

        emailLayout = findViewById(R.id.emailAuto);
        passwordLayout = findViewById(R.id.passwordAuto);
        emailEditText = findViewById(R.id.emailAutoText);
        passwordEditText = findViewById(R.id.passwordAutoText);
        errorMsg = findViewById(R.id.ErrorMsg);
        Validation valid = new Validation();

        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = s.toString().trim();
                if (!valid.CheckRightPatter(email)){
                    emailLayout.setError("Введите корректный email");
                    checkEmail = false;
                }
                else{
                    emailLayout.setError(null);
                    checkEmail = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String email = s.toString().trim();
                if (valid.CheckRightLength(email, emailLayout.getCounterMaxLength()))
                    checkEmail = true;
                else {
                    emailLayout.setError("Электронная почта не может содержать больше "
                            + emailLayout.getCounterMaxLength() + " символов");
                    checkEmail = false;
                }
            }
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String password = s.toString().trim();
                if (valid.CheckRightLength(password, passwordLayout.getCounterMaxLength())) {
                    passwordLayout.setError(null);
                    checkPass = true;
                } else {
                    passwordLayout.setError("Пароль не может содержать больше "
                            + passwordLayout.getCounterMaxLength() + " символов");
                    checkPass = false;
                }
            }
        });
    }

    public void OnClick(View view) {
        if ((checkPass && checkEmail) && (UserEmail == emailEditText.getText().toString()) &&
                (UserPass == passwordEditText.getText().toString()) ) {
            Intent intent = new Intent(getApplicationContext(), MainAct.class);
            startActivity(intent);
        }
        else errorMsg.setText("Ошибка ввода данных или пользователь не найден!");
    }

    public void RegLink(View view) {
        Intent intent = new Intent(getApplicationContext(), RegAct.class);
        startActivity(intent);
    }
}