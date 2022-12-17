package com.creditsaison.omni.validators;

import com.creditsaison.omni.enums.Status;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusValidator implements ConstraintValidator<ValidStatus, String>{

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(str)){
            return false;
        }
        Status[] statuses = Status.values();
        for (Status status: statuses){
            if (status.toString().equals(str)){
                return true;
            }
        }
        return false;
    }
}
