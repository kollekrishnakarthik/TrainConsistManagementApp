import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        MainTest.sortBogieNames(input);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"}, input);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        MainTest.sortBogieNames(input);
        assertArrayEquals(new String[]{"AC Chair", "General", "Luxury", "Sleeper"}, input);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair", "First Class", "General"};
        MainTest.sortBogieNames(input);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General"}, input);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        MainTest.sortBogieNames(input);
        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper", "Sleeper"}, input);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        MainTest.sortBogieNames(input);
        assertArrayEquals(new String[]{"Sleeper"}, input);
    }

    private static void sortBogieNames(String[] input) {
    }
}