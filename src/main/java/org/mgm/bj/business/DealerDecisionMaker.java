package org.mgm.bj.business;

import org.mgm.bj.model.Hand;

public class DealerDecisionMaker {

    public static boolean getStrategy(Hand hand) {
        return getDealerComplexStrategy(hand);
    }

    private static boolean getDealerComplexStrategy(Hand hand) {
        if (hand.getTotal() == 17) {
            return DealerStrategy.hitOnSoft17(hand);
        }
        return DealerStrategy.hitTill16(hand.getTotal());
    }
    
    private static boolean getDealerSimpleStrategy(Hand hand) {
        return DealerStrategy.hitTill16(hand.getTotal());
    }
}
