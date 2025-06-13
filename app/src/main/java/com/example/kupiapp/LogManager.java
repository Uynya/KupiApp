package com.example.kupiapp;

import android.icu.text.SimpleDateFormat;
import android.widget.TextView;

import java.util.Date;
import java.util.Locale;

public class LogManager {

    private TextView logTextView;

    public LogManager(TextView logTextView) {
        this.logTextView = logTextView;
    }
    private String getCurrentTimestamp() {

        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd, HH:mm:ss.SSS", Locale.getDefault());
        return sdf.format(new Date());
    }
    public String StartLog(String name, int start, int end)
    {
        String s = "";
        s+= "[" + getCurrentTimestamp() + "]";
        s+= " Запуск: " + name + "\n";

        s+= "[" + getCurrentTimestamp() + "]";
        s+= " Диапазон поиска от " + start + " до " + end + "\n";

        return s;
    }
    public String Launch()
    {
        String s = "";
        s+= "[" + getCurrentTimestamp() + "]";
        s+= " Поиск запущен" + "\n";
        return s;
    }

    public String LogNum(int num)
    {
        String s = "";
        s+= "[" + getCurrentTimestamp() + "]";
        s+= " " + num + "\n";
        return s;
    }
}
