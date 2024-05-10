package com.amaap.poker.domain.service;

import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;


public interface HandRankHandler {
    void setSuccessor(HandRankHandler successor);
    Rank evaluateHand(Hand hand);
}



