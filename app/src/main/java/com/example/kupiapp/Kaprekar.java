package com.example.kupiapp;

import android.widget.TextView;

public class Kaprekar {
    private TextView logTextView;
    public Kaprekar(TextView logTextView) {
        this.logTextView = logTextView;
    }
    LogManager logM = new LogManager(logTextView);

    public void findKaprekarNumbers(int start, int end) {

        for (int number = start; number <= end; number++) {
            if (isKaprekar(number)) {
                logTextView.append(logM.LogNum(number));
            }
        }
    }
    private boolean isKaprekar(int number) {
        long square = (long) number * number;
        String squareStr = String.valueOf(square);

        for (int i = 1; i < squareStr.length(); i++) {
            String leftStr = squareStr.substring(0, squareStr.length() - i);
            String rightStr = squareStr.substring(squareStr.length() - i);

            if (Integer.parseInt(rightStr) == 0)
                continue;

            long left = leftStr.isEmpty() ? 0 : Long.parseLong(leftStr);
            long right = Long.parseLong(rightStr);
            if (left + right == number)
                    return true;
        }
        return false;
    }
}
