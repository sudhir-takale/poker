package com.amaap.poker.service;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.repository.HandRepository;
import com.google.inject.Inject;

import java.util.List;

public class HandService {
    private final CardService cardService;
    private final HandRepository handRepository;

    @Inject
    public HandService(CardService cardService, HandRepository handRepository) {
        this.cardService = cardService;
        this.handRepository = handRepository;
    }

    public Hand create() {
        List<Card> cards = cardService.getCards();
        Hand hand = new Hand();
        hand.setCards(cards);
        return handRepository.add(hand);
    }

    public List<Hand> getAllHand() {
        return handRepository.getHandList();
    }
}
