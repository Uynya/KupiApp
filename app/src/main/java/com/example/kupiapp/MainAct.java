package com.example.kupiapp;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainAct extends AppCompatActivity {
    TextInputLayout startLayout, endLayout;
    TextInputEditText startEditText, endEditText;
    TextView logView;
    Boolean checkDiap = false;
    int choose = 0;
    Validation valid = new Validation();
    LogManager logM = new LogManager(logView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        startLayout = findViewById(R.id.DiapBegin);
        endLayout = findViewById(R.id.DiapEnd);
        startEditText = findViewById(R.id.DiapBeginText);
        endEditText = findViewById(R.id.DiapEndText);
        logView = findViewById(R.id.Log);


        startEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String number = s.toString().trim();
                if (valid.CheckRightLength(number, startLayout.getCounterMaxLength())) {
                    startLayout.setError(null);
                    checkDiap= true;
                } else {
                    startLayout.setError("");
                    checkDiap = false;
                }
            }
        });
        endEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String number = s.toString().trim();
                if (valid.CheckRightLength(number, endLayout.getCounterMaxLength())) {
                    endLayout.setError(null);
                    checkDiap= true;
                } else {
                    endLayout.setError("");
                    checkDiap = false;
                }
            }
        });


    }

    public void TaskOne(View view) {
        if (!startEditText.getText().toString().isEmpty() && !endEditText.getText().toString().isEmpty()) {
            logView.append(logM.StartLog("Числа Цукермана", Integer.parseInt(startEditText.getText().toString()),
                    Integer.parseInt(endEditText.getText().toString())));
            choose = 1;
        }
        else
            logView.append("Ошибка: введите диапазон" + "\n");
    }

    public void Clear(View view) {
        logView.setText("");
    }

    public void Start(View view) {
        if (!startEditText.getText().toString().isEmpty() && !endEditText.getText().toString().isEmpty()) {
            switch (choose) {
                case 0:
                    logView.append("Ошибка: выберите задачу" + "\n");
                    break;
                case 1:
                    Zuckerman zuck = new Zuckerman(logView);
                    logView.append(logM.Launch());
                    zuck.findZuckermanNumbers(Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString()));
            }
        }
        else
            logView.append("Ошибка: введите диапазон" + "\n");
    }
}
