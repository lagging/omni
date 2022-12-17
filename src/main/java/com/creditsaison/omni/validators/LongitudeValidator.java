package com.creditsaison.omni.validators;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LongitudeValidator implements ConstraintValidator<ValidLongitude, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s)) {
            return false;
        }
        boolean isValid = true;
        try {
            Double longitude = Double.valueOf(s);
            if (longitude < -180 || longitude > 180){
                return false;
            }
        } catch (Exception exception) {
            isValid = false;
        }
        return isValid;
    }
}
