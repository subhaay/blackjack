package service;

public class DealerStrategy {
    public static boolean hitTill16(int score) {
        return score <= 16;
    }

    public static boolean riskyStrategy(int score) {
        return score <= 17;
    }
}
