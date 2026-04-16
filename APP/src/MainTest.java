import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};
        assertThrows(IllegalStateException.class, () -> {
            MainTest.searchBogie(arr, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101", "BG205"};
        assertDoesNotThrow(() -> MainTest.searchBogie(arr, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertTrue(MainTest.searchBogie(arr, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertFalse(MainTest.searchBogie(arr, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};
        assertTrue(MainTest.searchBogie(arr, "BG101"));
    }

    private static boolean searchBogie(String[] arr, String bg101) {
        return false;
    }
}