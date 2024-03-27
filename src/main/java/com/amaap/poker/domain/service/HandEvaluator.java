package com.amaap.poker.domain.service;

import com.amaap.poker.domain.service.exception.CardNotFoundException;
import com.amaap.poker.domain.service.exception.InvalidCardDeckException;
import com.amaap.poker.domain.service.validator.CardDeckValidator;

import java.util.*;

public class HandEvaluator {
    private static int getValue(char rank) {
        String order = "23456789TJQKA";
        return order.indexOf(rank);
    }

    public String getBestHand(List<String> cards) throws CardNotFoundException, InvalidCardDeckException {

        if (!CardDeckValidator.validate(cards)) {
            throw new InvalidCardDeckException("Card Deck is not Valid check number of cards!");
        }

        cards.sort(new Comparator<String>() {
            @Override
            public int compare(String card1, String card2) {
                char rank1 = card1.charAt(1);
                char rank2 = card2.charAt(1);
                return getValue(rank1) - getValue(rank2);
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
        boolean isStraight = isStraight(cards);
        Map<Character, Integer> score = new HashMap<>();
        for (String card : cards) {
            char secondChar = card.charAt(0);
            score.put(secondChar, score.getOrDefault(secondChar, 0) + 1);
        }
        boolean isStraightFlush = score.containsValue(5);
        return (isStraight && isStraightFlush);
    }

    private boolean isFourOfAKind(List<String> cards) {
        return false;


    }

    private boolean isFullHouse(List<String> cards) {
        return false;


    }

    private boolean isFlush(List<String> cards) {
        Map<Character, Integer> score = new HashMap<>();
        for (String card : cards) {
            char secondChar = card.charAt(0);
            score.put(secondChar, score.getOrDefault(secondChar, 0) + 1);
        }
        return score.containsValue(5);
    }

    private boolean isStraight(List<String> cards) {
        Set<Integer> distinctValues = new HashSet<>();

        for (String card : cards) {
            int value = card.charAt(1);
            if (!distinctValues.contains(value)) {
                distinctValues.add(value);
            }
        }
        if (distinctValues.size() == 5) {
            List<Integer> sortedValues = new ArrayList<>(distinctValues);
            Collections.sort(sortedValues);
            for (int i = 0; i < 4; i++) {
                if (sortedValues.get(i + 1) - sortedValues.get(i) != 1) {
                    return false;
                }
            }
            return true;
        }
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
        char bestHand = cards.get(cards.size() - 1).charAt(1);
        return String.valueOf(bestHand);
    }


}
