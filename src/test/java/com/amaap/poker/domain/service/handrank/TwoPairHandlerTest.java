package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TwoPairHandlerTest {

    TwoPairHandler twoPairHandler = new TwoPairHandler();

    @Test
    public void shouldBeAbleToGiveTwoPairAsABestHand() {
        // arrange
        Hand twoPairHand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "2"),
                new Card("H", "8"),
                new Card("C", "8"),
                new Card("S", "K")
        );
        twoPairHand.setCards(cards);

        // act
        Rank result = twoPairHandler.evaluateHand(twoPairHand);

        // assert
        assertEquals(Rank.TWOPAIR, result);
    }

}