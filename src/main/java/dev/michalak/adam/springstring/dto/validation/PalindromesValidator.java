package dev.michalak.adam.springstring.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class PalindromesValidator implements ConstraintValidator<PalindromesConstraint, List<String>> {

    @Override
    public boolean isValid(List<String> palindromes, ConstraintValidatorContext context) {
        boolean allPalindromes = palindromes.stream().allMatch(this::isPalindrome);

        if (!allPalindromes) {
            addConstraintViolation(context);
        }
        return allPalindromes;
    }

    private boolean isPalindrome(String text){
        String reversed = new StringBuilder(text).reverse().toString();

        return text.equals(reversed);
    }

    private void addConstraintViolation(ConstraintValidatorContext context) {
        String message = context.getDefaultConstraintMessageTemplate();

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}
