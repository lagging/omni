package com.creditsaison.omni.commons;

import javax.validation.Validation;
import java.util.Optional;

public class RequestValidation {
    public RequestValidation() {
    }

    public static <T> Optional<String> validate(T request) {
        return Optional.ofNullable(Validation.buildDefaultValidatorFactory().getValidator().validate(request, new Class[0])).filter((constraintViolations) -> {
            return constraintViolations.size() != 0;
        }).flatMap((constraintViolations) -> {
            return constraintViolations.stream().findAny();
        }).map((tConstraintViolation) -> {
            return tConstraintViolation.getPropertyPath() + " is Invalid";
        });
    }
}
