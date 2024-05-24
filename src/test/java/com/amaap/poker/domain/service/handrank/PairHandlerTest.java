package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;
import com.amaap.poker.domain.service.HandRankHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairHandlerTest {

    PairHandler pairHandler = new PairHandler();

    @Test
    public void shouldBeAbleToGivePairAsABestHand() {
        // arrange
        Hand pairHand = new Hand();
        List<Card> cards = Arrays.asList(
                new Card("H", "2"),
                new Card("D", "2"),
                new Card("H", "8"),
                new Card("C", "J"),
                new Card("S", "K")
        );
        pairHand.setCards(cards);

        // act
        Rank result = pairHandler.evaluateHand(pairHand);

        // assert
        assertEquals(Rank.PAIR, result);
    }
}