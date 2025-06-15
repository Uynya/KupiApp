package com.example.kupiapp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainAct extends AppCompatActivity {
    TextInputLayout startLayout, endLayout;
    TextInputEditText startEditText, endEditText;
    TextView logView;
    Boolean checkDiap = false; int choose = 1;
    Validation valid = new Validation(); LogManager logM = new LogManager(logView);
    MaterialButton one, two, three, four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        startLayout = findViewById(R.id.DiapBegin);
        endLayout = findViewById(R.id.DiapEnd);
        startEditText = findViewById(R.id.DiapBeginText);
        endEditText = findViewById(R.id.DiapEndText);
        logView = findViewById(R.id.Log);

        one = findViewById(R.id.One);
        two = findViewById(R.id.Two);
        three = findViewById(R.id.Three);
        four = findViewById(R.id.Four);

        one.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.click)));
        logView.append(logM.StartLog("Числа Цукермана"));

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
        if (!startEditText.getText().toString().isEmpty() && !endEditText.getText().toString().isEmpty() &&
                Integer.parseInt(startEditText.getText().toString()) < Integer.parseInt(endEditText.getText().toString())) {
            String log = logM.StartLog("Числа Цукермана");
            logView.append(log);
            choose = 1;
            one.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.click)));
            two.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
            three.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
            four.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));

        }
        else {
            String log = logM.SetError(1);
            logView.append(log);
        }
    }
    public void TaskTwo(View view) {
        if (!startEditText.getText().toString().isEmpty() && !endEditText.getText().toString().isEmpty() &&
                Integer.parseInt(startEditText.getText().toString()) < Integer.parseInt(endEditText.getText().toString())) {
            String log = logM.StartLog("Числа Нивена");
            logView.append(log);
            choose = 2;
            one.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
            two.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.click)));
            three.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
            four.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
        }
        else {
            String log = logM.SetError(1);
            logView.append(log);
        }
    }
    public void TaskThree(View view) {
        if (!startEditText.getText().toString().isEmpty() && !endEditText.getText().toString().isEmpty() &&
                Integer.parseInt(startEditText.getText().toString()) < Integer.parseInt(endEditText.getText().toString())) {
            String log = logM.StartLog("Числа Армстронга");
            logView.append(log);
            choose = 3;
            one.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
            two.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
            three.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.click)));
            four.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
        }
        else {
            String log = logM.SetError(1);
            logView.append(log);
        }
    }
    public void TaskFour(View view) {
        if (!startEditText.getText().toString().isEmpty() && !endEditText.getText().toString().isEmpty() &&
                Integer.parseInt(startEditText.getText().toString()) < Integer.parseInt(endEditText.getText().toString())) {
            String log = logM.StartLog("Числа Капрекара");
            logView.append(log);
            choose = 4;
            one.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
            two.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
            three.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
            four.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.click)));
        }
        else {
            String log = logM.SetError(1);
            logView.append(log);
        }
    }
    public void Start(View view) {
        if (!startEditText.getText().toString().isEmpty() && !endEditText.getText().toString().isEmpty()) {
            switch (choose) {
                case 0:
                    String log = logM.SetError(2);
                    logView.append(log);
                    break;
                case 1:
                    Zuckerman zuck = new Zuckerman(logView);
                    logView.append(logM.Launch(1, Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString())));
                    zuck.findZuckermanNumbers(Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString()));
                    logView.append(logM.Launch(2, Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString())));
                    one.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
                    choose = 0;
                    break;
                case 2:
                    Niven niv = new Niven(logView);
                    logView.append(logM.Launch(1, Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString())));
                    niv.findNivenNumbers(Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString()));
                    logView.append(logM.Launch(2, Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString())));
                    two.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
                    choose = 0;
                    break;
                case 3:
                    Armstrong arm = new Armstrong(logView);
                    logView.append(logM.Launch(1, Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString())));
                    arm.findArmstrongNumbers(Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString()));
                    logView.append(logM.Launch(2, Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString())));
                    three.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
                    choose = 0;
                    break;
                case 4:
                    Kaprekar kar = new Kaprekar(logView);
                    logView.append(logM.Launch(1, Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString())));
                    kar.findKaprekarNumbers(Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString()));
                    logView.append(logM.Launch(2, Integer.parseInt(startEditText.getText().toString()),
                            Integer.parseInt(endEditText.getText().toString())));
                    four.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.main)));
                    choose = 0;
                    break;
            }
        }
        else {
            String log = logM.SetError(1);
            logView.append(log);
        }
    }
    public void Clear(View view) {
        logView.setText("");
    }


    public void History(View view) {
        Intent intent = new Intent(getApplicationContext(), HisAct.class);
        startActivity(intent);
    }
}
