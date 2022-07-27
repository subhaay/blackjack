package org.mgm.bj.model;

/**
 * Card represent card values.
 * @author avipokhrel
 */
public class Card {
    private boolean used;
    private int cardValue;
    private Suit suit;

    /**
     * Setup Card with suit and card value.
     * @param suit
     * @param cardValue
     */
    public Card(Suit suit, int cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
    }

    /**
     * This method marks card as used.
     */
    public void markAsUsedCard() {
        this.used = false;
    }

    /**
     * This method gets the card value.
     * @return
     */
    public int getCardValue() {
        return cardValue;
    }

    /**
     * Gets the Suit.
     * @return
     */
    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        String[] faceValues = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        return faceValues[cardValue - 1] + " " + suit;
    }
}
