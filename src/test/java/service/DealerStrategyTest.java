package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DealerStrategyTest {
    @Test
    void testRiskyStrategyValid() {
        assertTrue(DealerStrategy.riskyStrategy(17));
    }

    @Test
    void testRiskyStrategyInValid() {
        assertFalse(DealerStrategy.riskyStrategy(18));
    }

    @Test
    void testHitTill16Valid() {
        assertTrue(DealerStrategy.hitTill16(16));
    }

    @Test
    void testHitTill16InValid() {
        assertFalse(DealerStrategy.hitTill16(17));
    }
}
