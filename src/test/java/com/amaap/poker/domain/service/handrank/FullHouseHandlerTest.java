package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FullHouseHandlerTest {
    FullHouseHandler fullHouseHandler = new FullHouseHandler();

    @Test
    public void shouldBeAbleToGiveFullHouseAsABestHand() {
        // arrange
        Hand fullHouseHand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "2"),
                new Card("C", "2"),
                new Card("S", "3"),
                new Card("H", "3")
        );
        fullHouseHand.setCards(cards);

        // act
        Rank result = fullHouseHandler.evaluateHand(fullHouseHand);

        // assert
        assertEquals(Rank.FULLHOUSE, result);
    }
}