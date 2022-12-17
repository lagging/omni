package com.creditsaison.omni.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FacilityTypeValidator.class)
@Documented
public @interface ValidFacilityType {
    String message() default "{FacilityType.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
