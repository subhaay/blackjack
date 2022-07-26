package org.mgm.bj.model;

public class Card {
    private boolean used;
    private int cardValue;
    private Suit suit;

    public Card(Suit suit, int cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
    }

    public void markAsUsedCard() {
        this.used = false;
    }

    public int getCardValue() {
        return cardValue;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        String[] faceValues = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        return faceValues[cardValue - 1] + " " + suit;
    }
}
