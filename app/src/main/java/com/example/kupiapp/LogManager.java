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
    public String StartLog(String name)
    {
        String s = "";
        s+= "[" + getCurrentTimestamp() + "]";
        s+= " Запуск: " + name + "\n";

        SaveData.Savedlogs +=s;
        return s;
    }
    public String Launch(int choose, int start, int end)
    {
        String s = "";
        if (choose == 1) {
             s = "";
            s+= "[" + getCurrentTimestamp() + "]";
            s+= " Диапазон поиска от " + start + " до " + end + "\n";

            s += "[" + getCurrentTimestamp() + "]";
            s += " Поиск запущен" + "\n";
            SaveData.Savedlogs +=s;
            return s;
        }
        else {
            s += "[" + getCurrentTimestamp() + "]";
            s += " Поиск завершён" + "\n";
            SaveData.Savedlogs +=s;
            return s;
        }
    }

    public String LogNum(int num)
    {
        String s = "";
        s+= "[" + getCurrentTimestamp() + "]";
        s+= " " + num + "\n";
        SaveData.Savedlogs +=s;
        return s;
    }
    public String SetError(int choose)
    {
        String s = "";
        s+= "[" + getCurrentTimestamp() + "]";
        if (choose == 1)
            s+= " Ошибка: введите диапазон корректно\n";
        else
            s+= " Ошибка: выберите задачу\n";
        SaveData.Savedlogs +=s;
        return s;
    }
}
