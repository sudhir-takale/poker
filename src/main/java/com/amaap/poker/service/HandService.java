package com.amaap.poker.service;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.repository.HandRepository;
import com.google.inject.Inject;

import java.util.List;

public class HandService {
    private final PokerService pokerService;
    private final HandRepository handRepository;

    @Inject
    public HandService(PokerService pokerService, HandRepository handRepository) {
        this.pokerService = pokerService;
        this.handRepository = handRepository;
    }

    public Hand create() {
        List<Card> cards = pokerService.getCards();
        Hand hand = new Hand();
        hand.setCards(cards);
        return handRepository.add(hand);
    }
}
