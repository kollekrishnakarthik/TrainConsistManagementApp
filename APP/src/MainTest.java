import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // -------------------------------
    // Helper Methods (UC10)
    // -------------------------------

    private List<Bogie> createBogiesMultiple() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 54),
                new Bogie("First Class", 36)
        );
    }

    private List<Bogie> createBogiesSingle() {
        return Collections.singletonList(new Bogie("Sleeper", 72));
    }

    private List<Bogie> createBogiesEmpty() {
        return Collections.emptyList();
    }

    // -------------------------------
    // UC10: Stream & Reduce Test Cases
    // -------------------------------

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = createBogiesMultiple();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        assertEquals(162, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = createBogiesMultiple();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        assertEquals(162, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = createBogiesSingle();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = createBogiesEmpty();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = createBogiesMultiple();
        List<Integer> capacities = bogies.stream()
                .map(Bogie::getCapacity)
                .toList();
        assertEquals(Arrays.asList(72, 54, 36), capacities);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = createBogiesMultiple();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        int manualSum = 0;
        for (Bogie b : bogies) {
            manualSum += b.getCapacity();
        }

        assertEquals(manualSum, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>(createBogiesMultiple());
        List<Bogie> before = new ArrayList<>(bogies);

        bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(before, bogies);
    }

    // -------------------------------
    // UC11: REGEX VALIDATION TEST CASES
    // -------------------------------

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(MainTest.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(MainTest.isValidTrainId("TRAIN12"));
        assertFalse(MainTest.isValidTrainId("TRN12A"));
        assertFalse(MainTest.isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(MainTest.isValidTrainId("TRN-123"));
        assertFalse(MainTest.isValidTrainId("TRN-12345"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(MainTest.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(MainTest.isValidCargoCode("PET-ab"));
        assertFalse(MainTest.isValidCargoCode("PET123"));
        assertFalse(MainTest.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        equals(MainTest.isValidCargoCode("PET-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(MainTest.isValidTrainId(""));
        assertFalse(MainTest.isValidCargoCode(""));
    }

    private static BooleanSupplier isValidCargoCode(String string) {
        return null;
    }

    private static boolean isValidTrainId(String string) {
        return false;
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(MainTest.isValidTrainId("TRN-1234X"));
        assertFalse(MainTest.isValidCargoCode("PET-ABC"));
    }
}