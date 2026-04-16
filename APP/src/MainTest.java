import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

// Reusing Bogie class
class MainTest1 {
    String name;
    int capacity;
//
//    Bogie(String name, int capacity) {
//        this.name = name;
//        this.capacity = capacity;
//    }
}

public class MainTest {

    // Helper method for filtering
    private List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = filterBogies(list, 70);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("AC Chair", 70)
        );

        List<Bogie> result = filterBogies(list, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("First Class", 24)
        );

        List<Bogie> result = filterBogies(list, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 75)
        );

        List<Bogie> result = filterBogies(list, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("AC Chair", 50),
                new Bogie("First Class", 30)
        );

        List<Bogie> result = filterBogies(list, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 90),
                new Bogie("AC Chair", 80)
        );

        List<Bogie> result = filterBogies(list, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        List<Bogie> result = filterBogies(list, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 60));

        filterBogies(list, 70);

        assertEquals(2, list.size()); // original list unchanged
    }
}