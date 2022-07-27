package org.mgm.bj.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Hand consists of a list of cards and total score.
 * @author avipokhrel
 */
public class Hand {

    protected ArrayList<Card> cardList = new ArrayList<>();

    public ArrayList<Card> getCardList() {
        return cardList;
    }

    public void setCardList(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }

    /**
     * This method add card to a hand.
     * @param card
     */
    public void addCardToHand(Card card) {
        this.cardList.add(card);
    }

    /**
     * This method returns the string representation of the list of cards.
     * @return
     */
    public String getCardToString() {
        return this.cardList.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    /**
     * This method calculates the total score in one hand.
     * @return int
     */
    public int getTotal() {
        int total = 0;
        for (Card card: this.cardList) {
            int cardValue = card.getCardValue();
            if (cardValue >= 11 && cardValue <= 13) {
                cardValue = 10;
            }
            total += cardValue;
        }
        if (isAce() && total + 10 <= 21) {
            return total + 10;
        }
        return total;
    }

    /**
     * This method finds if a hand has Ace card.
     * @return
     */
    public boolean isAce() {
        for (Card card: this.cardList) {
            if (card.getCardValue() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isBusted() {
        return getTotal() > 21;
    }
}

