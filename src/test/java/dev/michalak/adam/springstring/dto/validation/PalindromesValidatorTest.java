package dev.michalak.adam.springstring.dto.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintValidatorContext;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PalindromesValidatorTest {
    @Mock private ConstraintValidatorContext context;
    private PalindromesValidator palindromesValidator;

    @BeforeEach
    void setUp() {
        palindromesValidator = new PalindromesValidator();
    }

    @Test
    void isValid_allPalindromes_shouldReturnTrue() {
        var input = List.of("bab", "babbab");

        boolean actual = palindromesValidator.isValid(input, context);

        assertTrue(actual);
    }

    @Test
    void isValid_someNotPalindromes_shouldReturnFalseAndCallContextWithMessage() {
        var input = List.of("ba", "babbab");
        String message = "Error message";

        when(context.buildConstraintViolationWithTemplate(any()))
                .thenReturn(mock(ConstraintValidatorContext.ConstraintViolationBuilder.class));
        when(context.getDefaultConstraintMessageTemplate()).thenReturn(message);
        boolean actual = palindromesValidator.isValid(input, context);

        assertFalse(actual);
        verify(context).buildConstraintViolationWithTemplate(message);
    }
}
