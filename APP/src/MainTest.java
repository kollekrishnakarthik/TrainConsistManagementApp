import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private List<GoodsBogie> validBogies() {
        return Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
    }

    private List<GoodsBogie> invalidCylindrical() {
        return Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal"),
                new GoodsBogie("Open", "Grain")
        );
    }

    private List<GoodsBogie> nonCylindricalOnly() {
        return Arrays.asList(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
    }

    private List<GoodsBogie> mixedWithViolation() {
        return Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
    }

    private List<GoodsBogie> emptyList() {
        return Collections.emptyList();
    }

    @Test
    void testSafety_AllBogiesValid() {
        assertTrue(MainTest.isTrainSafe(validBogies()));
    }

    private static boolean isTrainSafe(List<GoodsBogie> goodsBogies) {
        return false;
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        assertFalse(MainTest.isTrainSafe(invalidCylindrical()));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        assertTrue(MainTest.isTrainSafe(nonCylindricalOnly()));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        assertFalse(MainTest.isTrainSafe(mixedWithViolation()));
    }

    @Test
    void testSafety_EmptyBogieList() {
        assertTrue(MainTest.isTrainSafe(emptyList()));
    }
}