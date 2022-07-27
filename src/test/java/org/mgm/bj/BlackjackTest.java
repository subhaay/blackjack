package org.mgm.bj;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

/**
 * BlackjackTest contains test cases for Blackjack.
 * @author avipokhrel
 */
public class BlackjackTest {

    private static String MAIN_CLASS_PATH = "src/main/java/org/mgm/bj/Blackjack.java";

    @Test
    void testMainMethodInvalid() throws FileNotFoundException {
        String data = "stand";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String[] args = {"a"};
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File(MAIN_CLASS_PATH));
        System.setIn(fips);
        Blackjack.main(args);
        System.setIn(original);
    }

    @Test
    void testMainMethodExceedPlayer() throws FileNotFoundException {
        String data = "hit";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String[] args = {"5"};
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(MAIN_CLASS_PATH);
        System.setIn(fips);
        Blackjack.main(args);
        System.setIn(original);
    }

 /*   void testMainMethodExceedPlayer2() throws FileNotFoundException {
        String data = "hit";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String[] args = {"1"};
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(MAIN_CLASS_PATH);
        System.setIn(fips);
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Blackjack.main(args);
        System.setIn(original);
    }*/


}
