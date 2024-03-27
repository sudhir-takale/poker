package com.amaap.poker;

import com.amaap.poker.domain.Hand;
import com.amaap.poker.domain.service.HandEvaluator;
import com.amaap.poker.domain.service.exception.CardNotFoundException;
import com.amaap.poker.domain.service.exception.InvalidCardDeckException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokerManagerTest {
    @Mock
    HandEvaluator handEvaluatorMock;
    @Mock
    Hand hand;
    @InjectMocks
    PokerManager pokerManager;


    @Test
    void shouldBeAbleToCreateHand() {
//        arrange & act
        Hand hand = new Hand();
//        assert
        Assertions.assertNotNull(hand);
    }

    @Test
    void shouldBeAbleToEmptyListOfCardsOfHand() {
//        act
        when(hand.getCards()).thenReturn(new ArrayList<>());
        List<String> expectedCards = hand.getCards();
//        assert
        Assertions.assertTrue(expectedCards.isEmpty());
    }

    @Test
    void shouldBeAbleToAddCardsInCardsList() {
//        act
        hand.getCards().add("D8");
        hand.getCards().add("CK");
        when(hand.getCards()).thenReturn(Arrays.asList("D8", "CK"));
        List<String> expectedCards = hand.getCards();
//        assert
        Assertions.assertEquals(2, expectedCards.size());
        Assertions.assertEquals(Arrays.asList("D8", "CK"), expectedCards);
    }

    @Test
    void shouldBeAbleToAllocateCardToHand() {
//        act
        when(hand.getCards()).thenReturn(Arrays.asList("CK", "D7", "C7", "DK", "SA"));
        List<String> actualCards = hand.getCards();
        List<String> expectedCards = Arrays.asList("CK", "D7", "C7", "DK", "SA");
//        assert
        Assertions.assertEquals(expectedCards, actualCards);
        Assertions.assertEquals(5, expectedCards.size());
    }

    @Test
    void shouldBeAbleToEvaluateTheBestHand() throws InvalidCardDeckException, CardNotFoundException {
        // arrange
        List<String> mockedHandCards = new ArrayList<>();
        mockedHandCards.add("S2");
        mockedHandCards.add("H3");
        mockedHandCards.add("D4");
        mockedHandCards.add("H5");
        mockedHandCards.add("C6");
        when(hand.getCards()).thenReturn(mockedHandCards);
        String expectedBestHand = "high-card-6";
        when(handEvaluatorMock.getBestHand(mockedHandCards)).thenReturn(expectedBestHand);
        // act
        String actualBestHand = pokerManager.getBestHand();
        // assert
        Assertions.assertEquals(expectedBestHand, actualBestHand);
    }
}
