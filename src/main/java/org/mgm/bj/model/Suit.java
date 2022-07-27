package org.mgm.bj.model;

/**
 * Suit class represents the type of the card.
 * @author avipokhrel
 */
public enum Suit {
    Hearts(0), Clubs(1), Spades(2), Diamonds(3);

    private int value;

    Suit(int value) {
       this.value = value;
    }

    /**
     * This method gets the Suit type based on value.
     * @param value
     * @return
     */
    public static Suit getSuit(int value) {
        if (value == 0) {
            return Suit.Hearts;
        } else if (value == 1) {
            return Suit.Clubs;
        } else if (value == 2) {
            return Suit.Spades;
        } else if (value == 3) {
            return Suit.Diamonds;
        } else {
            return null;
        }
    }
}
