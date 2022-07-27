package org.mgm.bj.model;

import java.util.ArrayList;

/**
 * Deck is a set of cards used throughout the black jack game
 * @author avipokhrel
 */
public class Deck {
    private ArrayList<Card> cardList;
    private int usedCardIndex;

    /**
     * Gets the list of cards.
     * @return
     */
    public ArrayList<Card> getCardList() {
        return this.cardList;
    }

    public void setDeckWithCards(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }

    /**
     * This method picks a card from the deck.
     * @return
     */
    public Card dealACard() {
        // if usedCardIndex is the same size as cardList then you do not have any more cards to deal with
        if (this.cardList.size() == this.usedCardIndex) {
            return null;
        }
        Card card = this.cardList.get(this.usedCardIndex);
        this.usedCardIndex = this.usedCardIndex + 1;
        card.markAsUsedCard();
        return card;
    }
}
