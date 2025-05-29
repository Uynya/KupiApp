package com.example.kupiapp;

import android.util.Patterns;

public class Validation {
    public Boolean CheckRightPatter(String email){
        if (!email.isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return false;
        else
            return true;
    }
    public Boolean CheckRightLength(String text, int maxLength){
        if (text.length() > maxLength || text.isEmpty())
            return false;
        else
            return true;
    }
}
