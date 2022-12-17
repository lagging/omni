package com.creditsaison.omni.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateFormatValidator implements ConstraintValidator<ValidDateFormat, String> {

    @Override
    public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = true;
        String format = "MM/dd/yyyy hh:mm:ss a";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            dateFormat.parse(date);
        } catch (ParseException e) {
            isValid = false;
        }
        return isValid;
    }
}
