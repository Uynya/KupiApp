package com.example.kupiapp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegAct extends AppCompatActivity {
    TextInputLayout emailLayout, passwordLayout, passwordLayout2, nameLayout;
    TextInputEditText emailEditText, passwordEditText, passwordEditText2, nameEditText;
    TextView errorMsg;
    Boolean checkEmail = false; Boolean checkPass = false; Boolean checkName = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);

        emailLayout = findViewById(R.id.emailReg);
        passwordLayout = findViewById(R.id.passwordReg);
        passwordLayout2 = findViewById(R.id.passwordReg2);
        nameLayout = findViewById(R.id.nameReg);
        emailEditText = findViewById(R.id.emailRegText);
        passwordEditText = findViewById(R.id.passwordRegText);
        passwordEditText2 = findViewById(R.id.passwordReg2Text);
        nameEditText = findViewById(R.id.nameRegText);
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
                    emailLayout.setError("");
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
                    passwordLayout.setError("");
                    checkPass = false;
                }
            }
        });
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String name = s.toString().trim();
                if (valid.CheckRightLength(name, nameLayout.getCounterMaxLength())) {
                    nameLayout.setError(null);
                    checkName = true;
                } else {
                    nameLayout.setError("");
                    checkName = false;
                }
            }
        });
        passwordEditText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = s.toString().trim();
                if (password.equals(passwordEditText.getText().toString())) {
                    passwordLayout2.setError(null);
                    checkPass = true;
                } else {
                    passwordLayout2.setError("Пароли не совпадают!");
                    checkPass = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void OnClick(View view) {
        if (checkName && checkName && checkPass) {
            SharedPreferences sharedPref = getSharedPreferences("my_data", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("email", emailEditText.getText().toString());
            editor.putString("password", passwordEditText.getText().toString());
            editor.putString("username", nameEditText.getText().toString());
            editor.apply();

            Intent intent = new Intent(getApplicationContext(), MainAct.class);
            startActivity(intent);

        }
        else
            errorMsg.setText("Ошибка ввода данных!");

    }
    public void AutoLink(View view) {
        Intent intent = new Intent(getApplicationContext(), AutoAct.class);
        startActivity(intent);
    }
}
