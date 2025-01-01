package nightclubmanagement;

import java.util.*;

public class PerformanceTracker {

    private List<Map<String, Object>> dailyPerformance;

    public PerformanceTracker() {
        this.dailyPerformance = new ArrayList<>();
    }

    public void logDay(NightClub nightClub) {
        Map<String, Object> dailyLog = new HashMap<>();
        dailyLog.put("currentGuests", nightClub.getCurrentCapacity());
        dailyLog.put("waitlist", nightClub.getWaitlistSize());
        dailyLog.put("processedWaitlist", nightClub.getProcessedWaitListSize());
        dailyLog.put("totalIncome", nightClub.getTotalIncome());
        dailyLog.put("peakHours", nightClub.getPeakHour());
        dailyPerformance.add(dailyLog);
    }

    public List<Map<String, Object>> getPerformanceLogs() {
        return dailyPerformance;
    }

    @Override
    public String toString() {
        if (dailyPerformance.isEmpty()) {
            return "No performance logs yet!";
        }

        Map<String, Object> latestLog = dailyPerformance.getLast();
        return "Performance Metrics { " +
                "Current Guests = " + latestLog.get("currentGuests") + ", " +
                "Waitlist Size = " + latestLog.get("waitlist") + ", " +
                "Processed WaitList Size = " + latestLog.get("processedWaitlist") + ", " +
                "Total Income = $" + String.format("%.2f", (double)latestLog.get("totalIncome")) + ", " +
                "Peak Hours = " + latestLog.get("peakHours")  + " }";
    }
}