package model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Hand {
    protected ArrayList<Card> cardList = new ArrayList<>();

    public void addCardToHand(Card card) {
        this.cardList.add(card);
    }

    public String getCardToString() {
        return this.cardList.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public int getTotal() {
        int total = 0;
        for (Card card: this.cardList) {
            int cardValue = card.cardValue;
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

    private boolean isAce() {
        for (Card card: this.cardList) {
            if (card.cardValue == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isBusted() {
        return getTotal() > 21;
    }
}

