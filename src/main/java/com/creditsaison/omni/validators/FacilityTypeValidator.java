package com.creditsaison.omni.validators;

import com.creditsaison.omni.enums.FacilityType;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class FacilityTypeValidator implements ConstraintValidator<ValidFacilityType, String> {
    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(str)){
            return false;
        }
        FacilityType[] facilityTypes = FacilityType.values();
        for (FacilityType facilityType: facilityTypes){
            if (facilityType.getType().equals(str)){
                return true;
            }
        }
        return false;
    }
}
