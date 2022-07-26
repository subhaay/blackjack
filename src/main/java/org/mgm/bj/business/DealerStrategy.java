package org.mgm.bj.business;

import org.mgm.bj.model.Card;
import org.mgm.bj.model.Hand;

public class DealerStrategy {
    public static boolean hitTill16(int score) {
        return score <= 16;
    }

    public static boolean hitOnSoft17(Hand hand) {
        int total = 0;
        for (Card card : hand.getCardList()) {
            int cardValue = card.getCardValue();
            if (cardValue >= 11 && cardValue <= 13) {
                cardValue = 10;
            }
            total += cardValue;
        }
        if (hand.isAce() && total + 10 <= 21) {
            return true;
        }
        return false;
    }
}
