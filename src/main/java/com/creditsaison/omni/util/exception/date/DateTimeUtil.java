package com.creditsaison.omni.util.exception.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public class DateTimeUtil {

    public static Date getDateFromString(String inputDate, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = dateFormat.parse(inputDate);
        } catch (ParseException e) {

        }
        return date;
    }

    public static Long getEpochDateFromString(String inputDate, String format){
        Long epochDate = null;
        Date date = getDateFromString(inputDate, format);
        if (Objects.nonNull(date)){
            epochDate = date.getTime();
        }
        return epochDate;
    }

}
