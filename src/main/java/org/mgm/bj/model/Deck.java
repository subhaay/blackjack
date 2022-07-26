package org.mgm.bj.model;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cardList;
    private int usedCardIndex;

    public ArrayList<Card> getCardList() {
        return this.cardList;
    }

    public void setDeckWithCards(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }

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
