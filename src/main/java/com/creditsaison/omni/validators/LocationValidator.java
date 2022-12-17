package com.creditsaison.omni.validators;

import com.creditsaison.omni.pojos.Location;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocationValidator implements ConstraintValidator<ValidLocation, Location> {

    @Override
    public boolean isValid(Location location, ConstraintValidatorContext constraintValidatorContext) {
        if (location == null){
            return false;
        }
        Double latitude = location.getLatitude();
        Double longitude = location.getLongitude();
        if (latitude == null || longitude == null){
            return false;
        }
        if (latitude < -90 || latitude > 90){
            return false;
        }

        if (longitude < -180 || longitude > 180){
            return false;
        }
        return true;
    }
}
