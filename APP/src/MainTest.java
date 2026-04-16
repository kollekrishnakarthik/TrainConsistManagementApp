import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(MainTest.binarySearch(arr, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(MainTest.binarySearch(arr, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(MainTest.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(MainTest.binarySearch(arr, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] arr = {"BG101"};
        assertTrue(MainTest.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] arr = {};
        assertFalse(MainTest.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] arr = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(MainTest.binarySearch(arr, "BG205"));
    }

    private static boolean binarySearch(String[] arr, String bg205) {
        return false;
    }
}