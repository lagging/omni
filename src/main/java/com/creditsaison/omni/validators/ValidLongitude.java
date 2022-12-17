package com.creditsaison.omni.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LongitudeValidator.class)
@Documented
public @interface ValidLongitude {

    String message() default "{Longitude.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
