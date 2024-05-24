package com.amaap.poker.repository.db;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.repository.db.impl.FakeInMemoryDatabase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryDatabaseTest {

    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();

    @Test
    void shouldBeAbleToSaveCard() {
        // arrange
        Card saved = new Card("H", "2");

        // act
        Card card = inMemoryDatabase.save(saved);

        // assert
        assertEquals(card, saved);

    }

    @Test
    void shouldBeAbleToGetCardById() {
        // arrange
        int id = 1;
        inMemoryDatabase.save(new Card("H", "2"));

        // act
        Card card = inMemoryDatabase.getCard(0);

        // assert
        assertEquals("H", card.getSuit());
    }

    @Test
    void shouldBeAbleToGetAllCards() {
        // arrange
        inMemoryDatabase.save(new Card("H", "4"));
        inMemoryDatabase.save(new Card("H", "4"));
        inMemoryDatabase.save(new Card("H", "4"));
        inMemoryDatabase.save(new Card("H", "4"));

        // act
        List<Card> cards = inMemoryDatabase.getAllCards();

        // assert
        assertEquals(4, cards.size());
    }


    @Test
    void shouldBeAbleToSaveHand() {
        // arrange
        Hand hand = new Hand();

        // act
        Hand hand2 = inMemoryDatabase.insert(hand);

        // assert
        assertEquals(hand2, hand);
    }

    @Test
    void shouldBeAbleToGetAllHands() {
        // arrange
        inMemoryDatabase.insert(new Hand());
        inMemoryDatabase.insert(new Hand());
        inMemoryDatabase.insert(new Hand());

        // act
        List<Hand> hands = inMemoryDatabase.getHandList();

        // assert
        assertEquals(3, hands.size());
    }
}