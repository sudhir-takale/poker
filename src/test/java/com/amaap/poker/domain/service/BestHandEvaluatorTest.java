package com.amaap.poker.domain.service;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestHandEvaluatorTest {

    BestHandEvaluator bestHandEvaluator = new BestHandEvaluator();

    @Test
    void shouldBeAbleToEvaluateBestHandThreeOfAKind() {
        // arrange
        Hand threeOfAKindHand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "2"),
                new Card("C", "2"),
                new Card("S", "3"),
                new Card("H", "K")
        );
        threeOfAKindHand.setCards(cards);

        // act
        Rank result = bestHandEvaluator.evaluateHand(threeOfAKindHand);

        // assert
        assertEquals(Rank.THREEOFAKIND, result);
    }

    @Test
    void shouldBeAbleToEvaluateBestHand() {
        // arrange
        Hand threeOfAKindHand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "2"),
                new Card("D", "7"),
                new Card("S", "4"),
                new Card("H", "K")
        );
        threeOfAKindHand.setCards(cards);

        // act
        Rank result = bestHandEvaluator.evaluateHand(threeOfAKindHand);

        // assert
        assertEquals(Rank.PAIR, result);
    }
}

