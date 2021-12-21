package dev.michalak.adam.springstring.dto.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

@Documented
@Constraint(validatedBy = PalindromesValidator.class)
@Target({FIELD, METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PalindromesConstraint {
    String message() default "There are strings in the request that are not palindromes";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
