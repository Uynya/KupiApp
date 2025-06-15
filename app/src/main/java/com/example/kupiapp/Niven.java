package com.example.kupiapp;

import android.widget.TextView;

public class Niven {
    private TextView logTextView;
    public Niven(TextView logTextView) {
        this.logTextView = logTextView;
    }
    LogManager logM = new LogManager(logTextView);
    public void findNivenNumbers(int start, int end) {

        for (int number = start; number <= end; number++) {
            if (isNiven(number)) {
                logTextView.append(logM.LogNum(number));
            }
        }
    }
    private boolean isNiven(int number) {

        int sum = getSumOfDigits(number);
        if (sum == 0)
            return false;
        if (number % sum == 0)
            return true;
        else
            return false;
    }

    private int getSumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
