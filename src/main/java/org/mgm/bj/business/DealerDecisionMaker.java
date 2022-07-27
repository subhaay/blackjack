package org.mgm.bj.business;

import org.mgm.bj.model.Hand;

/**
 * DealerDecisionMaker class wraps list of dealers strategy and lets you configure it.
 * @author avipokhrel
 */
public class DealerDecisionMaker {
    /**
     * Gets dealers strategy.
     * @param hand
     * @return
     */
    public static boolean getStrategy(Hand hand) {
        return getDealerComplexStrategy(hand);
    }

    /**
     * This method will return a complex dealer's strategy.
     * @param hand
     * @return
     */
    private static boolean getDealerComplexStrategy(Hand hand) {
        if (hand.getTotal() == 17) {
            return DealerStrategy.hitOnSoft17(hand);
        }
        return DealerStrategy.hitTill16(hand.getTotal());
    }

    /**
     * This method will return a simple dealer's strategy.
     * @param hand
     * @return
     */
    private static boolean getDealerSimpleStrategy(Hand hand) {
        return DealerStrategy.hitTill16(hand.getTotal());
    }
}
