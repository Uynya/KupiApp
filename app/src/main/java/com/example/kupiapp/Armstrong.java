package com.example.kupiapp;

import android.widget.TextView;

public class Armstrong {
    private TextView logTextView;
    public Armstrong(TextView logTextView) {
        this.logTextView = logTextView;
    }
    LogManager logM = new LogManager(logTextView);
    public void findArmstrongNumbers(int start, int end) {

        for (int number = start; number <= end; number++) {
            if (isArmstrong(number)) {
                logTextView.append(logM.LogNum(number));
            }
        }
    }
    private boolean isArmstrong(int number) {
        int power = getDigitCount(number);
        int sum = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, power);
            temp /= 10;
        }

        return sum == number;
    }
    private int getDigitCount(int number) {
        int count = 0;
        int temp = number;
        do {
            temp /= 10;
            count++;
        } while (temp > 0);
        return count;
    }
}
