package com.amaap.poker.service;

import com.amaap.poker.PokerModule;
import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.service.exception.InvalidCardException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CardServiceTest {

    @Inject
    CardService cardService;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new PokerModule());
        cardService = injector.getInstance(CardService.class);
    }

    @Test
    void shouldBeAbleToCreateANewCardWithSuitAndValue() throws InvalidCardException {
        // arrange
        String suit = "H";
        String value = "5";
        Card expected = new Card(suit, value);

        // act
        Card actual = cardService.create(suit, value);

        // assert
        assertEquals(expected, actual);

    }

    @Test
    void shouldThrowExceptionIfEmptyCardSuitIsPassed() {
        // arrange
        String suit = "";
        String value = "5";

        assertThrows(InvalidCardException.class, () -> cardService.create(suit, value));

    }

    @Test
    void shouldBeAbleToGetAllCards() throws InvalidCardException {
        // arrange
        cardService.create("H", "5");
        cardService.create("H", "2");

        // act
        List<Card> cards = cardService.getAllCards();

        // assert
        assertEquals(2, cards.size());


    }

}