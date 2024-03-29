package com.amaap.poker.domain.service.validator;

import com.amaap.poker.domain.service.exception.CardNotFoundException;
import com.amaap.poker.domain.service.exception.InvalidCardDeckException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class CardDeckValidatorTest {
    @Test
    void shouldThrowCardNotFoundExceptionWhenListOfCardsIsEmpty() {
//       act & assert
        Assertions.assertThrows(CardNotFoundException.class, () -> CardDeckValidator.validate(new ArrayList<>()), "Card Deck can't be Empty !");
    }

    @Test
    void shouldThrowInvalidCardDeckExceptionWhenListOfCardsIsEmpty() {
//       act & assert
        Assertions.assertThrows(InvalidCardDeckException.class, () -> CardDeckValidator.validate(Arrays.asList("S2", "D5", "HA")), "Card Deck is not Valid, check number of cards!");
    }

    @Test
    void shouldThrowInvalidCardDeckExceptionWhenListOfCardSizeIsNotEqualToFive() {
//       act & assert
        Assertions.assertThrows(InvalidCardDeckException.class, () -> CardDeckValidator.validate(Arrays.asList("S2", "D5", "HA")), "Card Deck is not Valid, check number of cards!");
    }

    @Test
    void shouldReturnTrueWhenListOfCardSizeIsEqualToFive() throws InvalidCardDeckException, CardNotFoundException {
//       act
        boolean result = CardDeckValidator.validate(Arrays.asList("S2", "D5", "HA", "D5", "HA"));
//       assert
        Assertions.assertTrue(result);

    }


}