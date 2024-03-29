package com.amaap.poker.domain;

import com.amaap.poker.domain.model.Hand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HandTest {
    Hand hand = Hand.getInstance();


    @Test
    public void shouldAddCardToHand() {
//        act
        List<String> cards = hand.getCards();
        hand.getCards().add("H2");
//        assert
        Assertions.assertEquals(1, cards.size());
        Assertions.assertEquals("H2", cards.get(0));
    }

}
