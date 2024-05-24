package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FourOfAKindHandlerTest {

    FourOfAKindHandler fourOfAKindHandler = new FourOfAKindHandler();

    @Test
    public void shouldBeAbleToGiveFourOfAKindAsABestHand() {
        // arrange
        Hand fourOfAKindHand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "2"),
                new Card("C", "2"),
                new Card("S", "2"),
                new Card("H", "K")
        );
        fourOfAKindHand.setCards(cards);

        // act
        Rank result = fourOfAKindHandler.evaluateHand(fourOfAKindHand);

        // assert
        assertEquals(Rank.FOUROFAKIND, result);
    }
}