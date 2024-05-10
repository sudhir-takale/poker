package com.amaap.poker.repository;

import com.amaap.poker.domain.model.entity.Hand;

import java.util.List;

public interface HandRepository {
    Hand add(Hand hand);

    List<Hand> getHandList();
}
