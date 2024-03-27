package com.amaap.poker.domain.service;

import com.amaap.poker.domain.service.exception.CardNotFoundException;
import com.amaap.poker.domain.service.exception.InvalidCardDeckException;
import com.amaap.poker.domain.service.validator.CardDeckValidator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HandEvaluator {
    public String getBestHand(List<String> cards) throws CardNotFoundException, InvalidCardDeckException {

        if (!CardDeckValidator.validate(cards)) {
            throw new InvalidCardDeckException("Card Deck is not Valid check number of cards!");
        }


        Collections.sort(cards, new Comparator<String>() {
            @Override
            public int compare(String card1, String card2) {
                return card1.charAt(1) - card2.charAt(1);
            }
        });

        if (isStraightFlush(cards)) {
            return "straight-flush";
        } else if (isFlush(cards)) {
            return "flush";
        } else if (isPair(cards)) {
            return "pair";
        } else if (isFourOfAKind(cards)) {
            return "four-of-a-kind";
        } else if (isTwoPair(cards)) {
            return "two-pair";
        } else if (isFullHouse(cards)) {
            return "full-house";
        } else if (isStraight(cards)) {
            return "straight";
        } else if (isThreeOfAKind(cards)) {
            return "three-of-a-kind";
        } else {
            return "high-card-" + getHighCard(cards);
        }
    }


    private boolean isStraightFlush(List<String> cards) {
        return false;
    }

    private boolean isFourOfAKind(List<String> cards) {
        return false;


    }

    private boolean isFullHouse(List<String> cards) {
        return false;


    }

    private boolean isFlush(List<String> cards) {
        return false;
    }

    private boolean isStraight(List<String> cards) {

        return false;

    }

    private boolean isThreeOfAKind(List<String> cards) {

        return false;

    }

    private boolean isTwoPair(List<String> cards) {
        return false;
    }

    private boolean isPair(List<String> cards) {
        return false;

    }

    private String getHighCard(List<String> cards) {
        return null;
    }


}
