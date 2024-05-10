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
#### What I used to solve this problem 
  - Used visitor design pattern as it fits perfectly within the problem
  - Used Google Guice for dependency injection for testcases as well as main classes 



## Domain :
### Model
    - Hand
        - id
        - List<String> cards
    - Card
        - id
        - card
        

### Service
  - Calculate best hand 

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
          - isStraightFlush(List<string> cards)

#### Controller

- CardController - creates cards 
    - createANewCard() - it will create a new card with card type and rank
    - getCard() - to get cards
  
- HandController - to create a hand
    - createHand() - assign cards to hand
    - evaluateBestHand()

#### Service
- CardService - perform operations related with cards
  - createCard() - to create a new card
  - getCard() - to get cards
  
- HandService - assign cards to hand and create a new hand
  - evaluateBestHand() - to evaluate best hand and it will gives the best hand
  - getCardsForHand()

#### Repository
- CardRepository - stores the cards 
- HandRepository - stores the hand information

#### Database
- used fake in memory database to store the data
