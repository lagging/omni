package com.creditsaison.omni.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StatusValidator.class)
@Documented
public @interface ValidStatus {

    String message() default "{Status.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
