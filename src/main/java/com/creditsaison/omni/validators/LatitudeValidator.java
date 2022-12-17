package com.creditsaison.omni.validators;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LatitudeValidator implements ConstraintValidator<ValidLatitude, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s)) {
            return false;
        }
        boolean isValid = true;
        try {
            Double latitude = Double.valueOf(s);
            if (latitude < -90 || latitude > 90) {
                isValid = false;
            }
        } catch (Exception exception) {
            isValid = false;
        }
        return isValid;
    }
}
