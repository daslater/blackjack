package com.slater.Cards;

import java.util.ArrayDeque;
import java.util.Random;

public class Deck {

    private static final int NUM_SUBDECKS = 1;
    private static final int TOTAL_CARDS_IN_DECK = NUM_SUBDECKS * 52;

    private ArrayDeque<Card> cards;

    public Deck() {
        cards = new ArrayDeque<>(TOTAL_CARDS_IN_DECK);
        for (int i = 0; i < NUM_SUBDECKS; i++) {
            for (Rank rank : Rank.values()) {
                for (Suit suit : Suit.values()) {
                    cards.push(new Card(rank, suit));
                }
            }
        }
        shuffle();
    }

    public void shuffle() {
        var rng = new Random();
        var shuffledDeck = new ArrayDeque<Card>(TOTAL_CARDS_IN_DECK);
        var cardArray = cards.toArray(new Card[0]);
        int cardsToShuffle = TOTAL_CARDS_IN_DECK;

        for (int i = 0; i < TOTAL_CARDS_IN_DECK; i++) {
            int shuffleIndex = rng.nextInt(cardsToShuffle);
            shuffledDeck.push(cardArray[shuffleIndex]);
            cardArray[shuffleIndex] = cardArray[--cardsToShuffle];
        }

        cards = shuffledDeck;
    }

    public ArrayDeque<Card> getCards() {
        return cards;
    }

    public Card dealCard() {
        return cards.pop();
    }

    public void retrieveCard(Card card) {
        cards.push(card);
    }

    public Hand dealHand() {
        return new Hand(cards.pop(), cards.pop());
    }

    public void retrieveHand(Hand hand) {
        for (Card card : hand.getCards()) {
            retrieveCard(card);
        }
    }

}
