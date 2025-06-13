package com.example.kupiapp;


import android.widget.TextView;

public class Zuckerman {
    private TextView logTextView;
    public Zuckerman(TextView logTextView) {
        this.logTextView = logTextView;
    }
    LogManager logM = new LogManager(logTextView);
    public void findZuckermanNumbers(int start, int end) {

        for (int number = start; number <= end; number++) {
            if (isZuckerman(number)) {
                logTextView.append(logM.LogNum(number));
            }
        }
    }
    private boolean isZuckerman(int number) {

        if (number == 0)
            return false;
        int product = getProductOfDigits(number);
        if (product == 0)
            return false;
        return number % product == 0;
    }

    private int getProductOfDigits(int number) {

        int product = 1;
        int n = Math.abs(number);
        if (n == 0)
            return 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 0) return 0;
            product *= digit;
            n /= 10;
        }
        return product;
    }
}
