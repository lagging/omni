package com.creditsaison.omni.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateFormatValidator.class)
public @interface ValidDateFormat {
    String message() default "{DateFormat.invalid provide in \"MM/dd/yyyy hh:mm:ss a\" format }";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
