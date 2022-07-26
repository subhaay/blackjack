import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class BlackjackTest {
    @Test
    void testMainMethodInvalid() throws FileNotFoundException {
        String data = "stand";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String[] args = {"a"};
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("src/main/java/Blackjack.java"));
        System.setIn(fips);
        Blackjack.main(args);
        System.setIn(original);
    }

    @Test
    void testMainMethodExceedPlayer() throws FileNotFoundException {
        String data = "hit";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String[] args = {"4"};
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("src/main/java/Blackjack.java"));
        System.setIn(fips);
        Blackjack.main(args);
        System.setIn(original);
    }

}
