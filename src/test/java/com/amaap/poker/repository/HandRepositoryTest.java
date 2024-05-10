package com.amaap.poker.repository;

import com.amaap.poker.PokerModule;
import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.repository.impl.InMemoryHandRepository;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HandRepositoryTest {

    @Inject
    HandRepository handRepository;

    @BeforeEach
    void setup() {
        Injector injector = Guice.createInjector(new PokerModule());
        handRepository = injector.getInstance(InMemoryHandRepository.class);
    }


    @Test
    void shouldBeAbleToSavaHandToRepository() {
        // arrange
        Hand hand = new Hand();
        hand.setCards(Arrays.asList(new Card("H", "5"), new Card("S", "6")));

        // act
        Hand actual = handRepository.add(hand);

        // assert
        assertNotNull(actual);
        assertEquals("H", actual.getCards().get(0).getSuit());
    }

    @Test
    void shouldBeAbleToGetAllHand() {
        // arrange
        Hand hand = new Hand();
        Hand hand2 = new Hand();
        hand.setCards(Arrays.asList(new Card("H", "5"), new Card("S", "6")));
        hand2.setCards(Arrays.asList(new Card("H", "5"), new Card("S", "6")));
        handRepository.add(hand);
        handRepository.add(hand2);

        // act
        List<Hand> hands = handRepository.getHandList();

        // assert
        assertEquals(2, hands.size());


    }


}