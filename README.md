![image](https://github.com/sudhir-takale/poker/assets/93988135/b2deaf07-eb87-41c9-870c-2f8c22139308)

# Poker Best Hand Extension

Change the poker program to include following new hand rankings: <br>

- Straight flush: All cards in the same suit, and in sequence
- Two pair: Two pairs of cards have the same rank <br>

### The new hand rankings are:

1. Straight flush: All cards in the same suit, and in sequence
2. Four of a kind: Four of the cards have the same rank
3. Full House: Three cards of one rank, the other two of another rank
4. Flush: All cards in the same suit
5. Straight: All cards in sequence (aces can be high or low, but not both at once)
6. Three of a kind: Three of the cards have the same rank
7. Two pair: Two pairs of cards have the same rank
8. Pair: Two cards have the same rank
9. High card: None of the above conditions are met. <br>

### Modification:

High card rule should return the highest card as well,<br>
Example ["S2" "D5" "C7" "ST" "HA"] should return, "high-card-ace"


------------------------------------------------------------------------------------------------------

- Classes :
    - Hand
        - states
        - List<String> cards

    - BestHandCalculator
        - evaluateBestHand(list<string> cards)
        - all methods to check for the best hand
    - Service
        - Calculate all best hand separately
          Rank:
        - TwoPair
            - isTwoPair(list<string> cards)
        - Pair()
            - isPair(list<string> cards)
        - Straight
            - isStraight(list<string> cards)
        - Flush
            - isFlush(list<string> cards)
        - StraightFlush
          isStraightFlush(List<string> cards)
    - PokerManager
        - allocateCards
        - getBestHand(List<String>cards)
    - Ranking enum
        - store rank

- Process :
- Create configurations for 52 cards
    - fill the cards list randomly
- create hand classes
    - method to fill cards
- create enum Ranking which stores the ranking of the cards
- evaluateBestHand(list<string> cards)
    - has separate class to calculate rak
- displayTheBestHand

-------------------------------------------------------------------------------------------------------------
