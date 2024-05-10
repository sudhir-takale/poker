package com.amaap.poker.domain.service;

import com.amaap.poker.domain.model.entity.Hand;


public interface HandRankHandler {
    void setSuccessor(HandRankHandler successor);
    String evaluateHand(Hand hand);
}



