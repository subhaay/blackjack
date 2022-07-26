import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;


public class BlackjackTest {
    @Test
    void testMainMethod() throws FileNotFoundException {
        String data = "stand";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String[] args = {"1", "stand"};
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("src/main/java/Blackjack.java"));
        System.setIn(fips);
        Blackjack.main(args);
        System.setIn(original);
    }
}
