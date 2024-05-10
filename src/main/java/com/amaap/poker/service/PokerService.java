package com.amaap.poker.service;

import com.amaap.poker.domain.model.entity.Card;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class PokerService {

    private final CardService cardService;
    private final HandService handService;

    @Inject
    public PokerService(CardService cardService, HandService handService) {
        this.cardService = cardService;
        this.handService = handService;
    }

    public List<Card> getCards() {
        List<Card> allCards = cardService.getAllCards();
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < Math.min(5, allCards.size()); i++) {
            cards.add(allCards.get(i));
        }
        return cards;
    }
}
