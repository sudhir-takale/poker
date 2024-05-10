package com.amaap.poker.service;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.repository.CardRepository;
import com.amaap.poker.service.exception.InvalidCardException;
import com.amaap.poker.service.validator.CardValidator;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardService {

    private final CardRepository cardRepository;

    @Inject
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card create(String suit, String value) throws InvalidCardException {

        if (!CardValidator.validate(suit, value)) throw new InvalidCardException("Invalid card " + value);
        Card card = new Card(suit, value);

        return cardRepository.save(card);
    }

    public List<Card> getAllCards() {
        return cardRepository.getAllCards();
    }

    public List<Card> getCards() {
        List<Card> allCards = getAllCards();
        Collections.shuffle(allCards);
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < Math.min(5, allCards.size()); i++) {
            cards.add(allCards.get(i));
        }
        return cards;
    }
}
