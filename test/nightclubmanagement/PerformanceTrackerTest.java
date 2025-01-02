package nightclubmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Queue;
import java.util.ArrayDeque;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTrackerTest {
    private PerformanceTracker performanceTracker;
    private NightClub nightClub;

    @BeforeEach
    public void setUp() {
        performanceTracker = new PerformanceTracker();
        nightClub = new NightClub();
    }

    @Test
    public void testLogDay() {
        assertEquals(0, performanceTracker.getPerformanceLogs().size());

        Queue<Guest> queue = new ArrayDeque<>();
        queue.add(new Guest("John Doe", "male"));
        nightClub.admitDirectGuests(queue);

        performanceTracker.logDay(nightClub);

        assertEquals(1, performanceTracker.getPerformanceLogs().size());
        assertEquals(1, performanceTracker.getPerformanceLogs().getFirst().get("currentGuests"));
    }

    @Test
    public void testToString() {
        Queue<Guest> queue = new ArrayDeque<>();
        queue.add(new Guest("John Doe", "male"));
        nightClub.admitDirectGuests(queue);
        performanceTracker.logDay(nightClub);

        String expectedLog = "Performance Metrics { " +
                "Current Guests = " + nightClub.getCurrentCapacity() + ", " +
                "Waitlist Size = " + nightClub.getWaitlistSize() + ", " +
                "Processed WaitList Size = " + nightClub.getProcessedWaitListSize() + ", " +
                "Total Income = $" + String.format("%.2f", nightClub.getTotalIncome()) + ", " +
                "Peak Hours = " + nightClub.getPeakHour() + " }";

        assertEquals(expectedLog, performanceTracker.toString());
    }

    @Test
    public void testLogWithoutEntry() {
        assertEquals("No performance logs yet!", performanceTracker.toString());
    }
}