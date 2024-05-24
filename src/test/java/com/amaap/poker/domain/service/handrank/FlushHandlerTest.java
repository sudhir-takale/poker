package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlushHandlerTest {

    FlushHandler flushHandler = new FlushHandler();


    @Test
    public void shouldBeAbleToGiveFlushAsABestHand() {
        // arrange
        Hand flushHand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "2"),
                new Card("H", "5"),
                new Card("H", "8"),
                new Card("H", "J"),
                new Card("H", "K")
        );
        flushHand.setCards(cards);

        // act
        Rank result = flushHandler.evaluateHand(flushHand);

        // assert
        assertEquals(Rank.FLUSH, result);
    }


}