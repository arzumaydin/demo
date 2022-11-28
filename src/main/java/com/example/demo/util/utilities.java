package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class utilities {
    public static Date stringToDate(String s){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            return formatter.parse(s);
        }
        catch (ParseException p){
            System.err.print("Error parsing string.");
            p.printStackTrace();
        }
        return null;
    }
    public static String dateToString(Date d){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        return formatter.format(d);
    }
}
