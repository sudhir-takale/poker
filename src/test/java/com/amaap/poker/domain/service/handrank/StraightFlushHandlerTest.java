package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StraightFlushHandlerTest {

    StraightFlushHandler straightFlushHandler = new StraightFlushHandler();

    @Test
    public void shouldBeAbleToGiveStraightFlushAsABestHand() {
        // arrange
        Hand straightFlushHand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "9"),
                new Card("H", "10"),
                new Card("H", "J"),
                new Card("H", "Q"),
                new Card("H", "K")
        );
        straightFlushHand.setCards(cards);

        // act
        Rank result = straightFlushHandler.evaluateHand(straightFlushHand);

        // assert
        assertEquals(Rank.STRAIGHTFLUSH, result);
    }
}
