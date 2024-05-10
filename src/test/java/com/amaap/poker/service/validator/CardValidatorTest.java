package com.amaap.poker.service.validator;

import org.junit.jupiter.api.Test;

import static com.amaap.poker.service.validator.CardValidator.validate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CardValidatorTest {

    @Test
    void shouldReturnFalseIfInvalidSuitIsPassed() {
        // act & assert
        assertFalse(validate("sdafds", "4"));
        assertFalse(validate("233", "4"));
        assertFalse(validate("!!!", "4"));
        assertFalse(validate(")))", "4"));
        assertFalse(validate("z", "4"));
        assertFalse(validate("4", "4"));
        assertFalse(validate("-", "4"));
        assertFalse(validate("//", "4"));
        assertFalse(validate("aa", "4"));
        assertFalse(validate("//", "4"));
        assertFalse(validate("jkh", "4"));
        assertFalse(validate("n", "4"));
    }

    @Test
    void shouldReturnTrueIfValidSuitAndValueIsPassed() {
        // act & assert
        assertTrue(validate("H", "6"));
        assertTrue(validate("D", "6"));
        assertTrue(validate("S", "6"));
        assertTrue(validate("S", "A"));
    }

    @Test
    void shouldReturnFalseIfInvalidValueIsPassed() {
        // act & assert
        assertFalse(validate("H", ""));
        assertFalse(validate("H", "s"));
        assertFalse(validate("H", "41"));
        assertFalse(validate("H", "#"));
        assertFalse(validate("H", "00"));
        assertFalse(validate("H", "KL"));
        assertFalse(validate("H", "AA"));
        assertFalse(validate("H", "//"));
        assertFalse(validate("H", "Z"));
        assertFalse(validate("H", "G"));
        assertFalse(validate("H", "LL"));
        assertFalse(validate("H", "QQ"));
    }
}