import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 60};
        MainTest.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] arr = {24, 56, 60, 70, 72};
        MainTest.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] arr = {72, 56, 56, 24};
        MainTest.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 56, 72}, arr);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] arr = {50};
        MainTest.bubbleSort(arr);
        assertArrayEquals(new int[]{50}, arr);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] arr = {40, 40, 40};
        MainTest.bubbleSort(arr);
        assertArrayEquals(new int[]{40, 40, 40}, arr);
    }

    private static void bubbleSort(int[] arr) {
    }
}