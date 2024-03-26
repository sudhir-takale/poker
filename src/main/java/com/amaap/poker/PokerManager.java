package com.amaap.poker;

import com.amaap.poker.domain.Hand;

import java.util.Arrays;

public class PokerManager {
    private Hand hand;

    public PokerManager(Hand hand) {
        this.hand = hand;
    }

    public boolean allocateCards() {
        hand.getCards().addAll(Arrays.asList("CK", "D7", "C7", "DK", "SA"));
        return true;
    }
}
