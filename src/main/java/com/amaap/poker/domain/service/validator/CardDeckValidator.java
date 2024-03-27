package com.amaap.poker.domain.service.validator;

import com.amaap.poker.domain.service.exception.CardNotFoundException;
import com.amaap.poker.domain.service.exception.InvalidCardDeckException;

import java.util.List;

public class CardDeckValidator {
    public static boolean validate(List<String> cards) throws CardNotFoundException, InvalidCardDeckException {
        if (cards.isEmpty()) throw new CardNotFoundException("Card deck Can't be Empty!");
        else if (cards.size() != 5) throw new InvalidCardDeckException("Card Deck is not Valid check number of cards!");

        return true;
    }
}
