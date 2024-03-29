package com.amaap.poker.domain.service.rank;

import java.util.List;

public class HighCard {
    public static String getHighCard(List<String> cards) {
        char bestHand = cards.get(cards.size() - 1).charAt(1);
        return getBestHighCard(bestHand);
    }

    public static String getBestHighCard(char bestHand) {
        if (bestHand == 'K') return "king";
        else if (bestHand == 'J') return "jack";
        else if (bestHand == 'A') return "ace";
        else if (bestHand == 'Q') return "queen";
        else if (bestHand == 'T') return "ten";
        else return String.valueOf(bestHand);
    }
}
