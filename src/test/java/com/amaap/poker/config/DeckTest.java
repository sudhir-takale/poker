package com.amaap.poker.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeckTest {

    Deck deck = new Deck();

    @Test
    public void shouldHaveFiftyTwoCards() {
//        act
        List<String> cardDeck = deck.getCardDeck();
//        assert
        Assertions.assertEquals(52, cardDeck.size());
    }

    @Test
    public void shouldHaveUniqueCards() {
//        act
        List<String> cardDeck = deck.getCardDeck();
        Set<String> uniqueCards = new HashSet<>(cardDeck);
//        assert
        Assertions.assertEquals(52, uniqueCards.size());
    }

    @Test
    public void shouldContainAllSuitRanks() {
        List<String> cardDeck = deck.getCardDeck();
        String[] suits = {"H", "D", "C", "S"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits) {
            for (String rank : ranks) {
                String card = suit + rank;
//                assert
                Assertions.assertTrue(cardDeck.contains(card));
            }
        }
    }

    @Test
    public void shouldNotContainDuplicates() {
//        act
        List<String> cardDeck = deck.getCardDeck();
        Set<String> uniqueCards = new HashSet<>(cardDeck);
//        assert
        Assertions.assertEquals(cardDeck.size(), uniqueCards.size());
    }

}
