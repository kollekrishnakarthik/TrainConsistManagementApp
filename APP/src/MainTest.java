import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // Sample data
    private List<Bogie> sampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 54),
                new Bogie("First Class", 36),
                new Bogie("Sleeper", 80)
        );
    }

    // Large dataset
    private List<Bogie> largeDataset() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("Sleeper", i % 100));
        }
        return list;
    }

    // Loop filtering test
    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = Main.filterWithLoop(sampleBogies());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    // Stream filtering test
    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = Main.filterWithStream(sampleBogies());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    // Compare loop and stream results
    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = Main.filterWithLoop(sampleBogies());
        List<Bogie> streamResult = Main.filterWithStream(sampleBogies());

        assertEquals(loopResult.size(), streamResult.size());
    }

    // Execution time test
    @Test
    void testExecutionTimeMeasurement() {
        long loopTime = Main.measureLoopTime(sampleBogies());
        long streamTime = Main.measureStreamTime(sampleBogies());

        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    // Large dataset test
    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> data = largeDataset();
        List<Bogie> result = Main.filterWithStream(data);

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }
}