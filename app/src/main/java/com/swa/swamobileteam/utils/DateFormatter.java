package com.swa.swamobileteam.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import timber.log.Timber;

public class DateFormatter {
    private Locale locale = new Locale("ru");
    private SimpleDateFormat dateIn = new SimpleDateFormat("EEE MM dd HH:mm:ss zzz yyyy", locale);
    private SimpleDateFormat dateOut = new SimpleDateFormat("HH:mm", locale);

    public DateFormatter(){}

    public DateFormatter(String dateOut) {
        this.dateOut = new SimpleDateFormat(dateOut, locale);
    }

    public DateFormatter(String dateIn, String dateOut) {
        this.dateIn = new SimpleDateFormat(dateIn, locale);
        this.dateOut = new SimpleDateFormat(dateOut, locale);
    }

    public String getFormattedDate(String dateStr) {
        if (dateStr.isEmpty()) {
            return "";
        }
        Date date = null;
        try {
            Timber.d(dateStr);
            date = dateIn.parse(dateStr);
        } catch (ParseException e) {
            Timber.e(e);
        }
        return dateOut.format(date);
    }


}
