package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighCardHandlerTest {

    HighCardHandler highCardHandler = new HighCardHandler();

    @Test
    public void shouldBeAbleToGiveHighCardAsABestHand() {
        // arrange
        Hand highCardHand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "4"),
                new Card("C", "7"),
                new Card("S", "9"),
                new Card("H", "K")
        );
        highCardHand.setCards(cards);

        // act
        Rank result = highCardHandler.evaluateHand(highCardHand);

        // assert
        assertEquals(Rank.HIGHCARD, result);
    }

}