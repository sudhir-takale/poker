package com.amaap.poker.domain.service;

import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;
import com.amaap.poker.domain.service.handrank.*;

public class BestHandEvaluator {
    private HandRankHandler firstHandler;

    public BestHandEvaluator() {
        buildChain();
    }

    private void buildChain() {
        StraightFlushHandler straightFlushHandler = new StraightFlushHandler();
        FourOfAKindHandler fourOfAKindHandler = new FourOfAKindHandler();
        StraightHandler straightHandler = new StraightHandler();
        PairHandler pairHandler = new PairHandler();
        ThreeOfAKindHandler threeOfAKindHandler = new ThreeOfAKindHandler();
        TwoPairHandler twoPairHandler = new TwoPairHandler();
        FlushHandler flushHandler = new FlushHandler();
        FullHouseHandler fullHouseHandler = new FullHouseHandler();
        HighCardHandler highCardHandler = new HighCardHandler();

        firstHandler = straightFlushHandler;
        straightFlushHandler.setSuccessor(flushHandler);
        flushHandler.setSuccessor(pairHandler);
        pairHandler.setSuccessor(fourOfAKindHandler);
        fourOfAKindHandler.setSuccessor(twoPairHandler);
        twoPairHandler.setSuccessor(fullHouseHandler);
        fullHouseHandler.setSuccessor(straightHandler);
        straightHandler.setSuccessor(threeOfAKindHandler);
        threeOfAKindHandler.setSuccessor(highCardHandler);
    }

    public Rank evaluateHand(Hand hand) {

        return firstHandler.evaluateHand(hand);

    }

}
