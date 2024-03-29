package com.amaap.poker.domain.service;

import com.amaap.poker.domain.Ranking;
import com.amaap.poker.domain.service.exception.CardNotFoundException;
import com.amaap.poker.domain.service.exception.InvalidCardDeckException;
import com.amaap.poker.domain.service.rank.*;
import com.amaap.poker.domain.service.validator.CardDeckValidator;

import java.util.List;

public class HandEvaluator {
    private static int getValue(char rank) {
        String order = "23456789TJQKA";
        return order.indexOf(rank);
    }

    public String getBestHand(List<String> cards) throws CardNotFoundException, InvalidCardDeckException {

        if (!CardDeckValidator.validate(cards)) {
            throw new InvalidCardDeckException("Card Deck is not Valid check number of cards!");
        }

        cards.sort((card1, card2) -> {
            char rank1 = card1.charAt(1);
            char rank2 = card2.charAt(1);
            return getValue(rank1) - getValue(rank2);
        });


        if (StraightFlush.isStraightFlush(cards)) {
            return Ranking.STRAIGHT_FLUSH.toString().toLowerCase();
        } else if (Flush.isFlush(cards)) {
            return Ranking.FLUSH.toString().toLowerCase();
        } else if (Pair.isPair(cards)) {
            return Ranking.PAIR.toString().toLowerCase();
        } else if (FourOfKind.isFourOfAKind(cards)) {
            return Ranking.FOUR_OF_A_KIND.toString().toLowerCase();
        } else if (TwoPair.isTwoPair(cards)) {
            return Ranking.TWO_PAIR.toString().toLowerCase();
        } else if (FullHouse.isFullHouse(cards)) {
            return Ranking.FUll_HOUSE.toString().toLowerCase();
        } else if (Straight.isStraight(cards)) {
            return Ranking.STRAIGHT.toString().toLowerCase();
        } else if (ThreeOfAKind.isThreeOfAKind(cards)) {
            return Ranking.THREE_OF_A_KIND.toString().toLowerCase();
        } else {
            return Ranking.HIGH_CARD.toString().toLowerCase() + "_" + HighCard.getHighCard(cards);
        }
    }
}
