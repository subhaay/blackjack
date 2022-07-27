package org.mgm.bj.business;

import org.mgm.bj.model.Card;
import org.mgm.bj.model.Hand;

/**
 * This class represents list of Dealer's Strategy.
 * @author avipokhrel
 */
public class DealerStrategy {
    /**
     * This method gets the strategy with score less than 16.
     * @param score
     * @return
     */
    public static boolean hitTill16(int score) {
        return score <= 16;
    }

    /**
     * This method will return true on dealer soft 17.
     * @param hand
     * @return
     */
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
