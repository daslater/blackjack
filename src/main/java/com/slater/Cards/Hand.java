package com.slater.Cards;

import com.slater.Cards.Card;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand(Card card1, Card card2) {
        cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getValue() {
        int value = 0;
        for (Card card : cards) {
            value += card.getRank().getValue();
        }

        int i = numAces();
        while (value > 21 && i > 0) {
            value -= 10;
            i--;
        }

        return value;
    }

    public boolean isBusted() {
        return getValue() > 21;
    }

    private int numAces() {
        int numAces = 0;
        for (Card card : cards) {
            if (card.getRank() == Rank.ACE){
                numAces++;
            }
        }

        return numAces;
    }

}
