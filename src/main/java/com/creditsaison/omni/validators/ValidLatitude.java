package com.creditsaison.omni.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LatitudeValidator.class)
@Documented
public @interface ValidLatitude {

    String message() default "{Latitude.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
