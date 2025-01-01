package nightclubmanagement;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NightClub {
    private final int MAX_CAPACITY = 7000;
    private final double ADMISSION_FEE = 10;
    private int currentCapacity = 0;
    private double totalIncome = 0;
    private String peakHour = "";
    private Queue<Guest> waitlist;
    private ArrayList<Guest> processedWaitlist;

    public NightClub() {
        waitlist = new ArrayDeque<>();
        processedWaitlist = new ArrayList<>();
    }

    public void admitDirectGuests(Queue<Guest> outsideQueue) {
        while (currentCapacity < MAX_CAPACITY && !outsideQueue.isEmpty()) {
            outsideQueue.poll();
            currentCapacity++;
            totalIncome += ADMISSION_FEE;
        }
    }

    public void admitWaitlistGuests(Queue<Guest> waitlist) {
        while (currentCapacity < MAX_CAPACITY && !waitlist.isEmpty()) {
            processedWaitlist.add(waitlist.poll());
            currentCapacity++;
            totalIncome += ADMISSION_FEE;
        }
    }

    public void addGuestToWaitlist(Guest guest) {
        waitlist.add(guest);
    }

    public void decreaseCurrentCapacityBy(int guests) {
        if (currentCapacity - guests < 0) {
            throw new IllegalArgumentException("Number of guests leaving exceeds current capacity");
        } else {
            currentCapacity -= guests;
        }
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public Queue<Guest> getWaitlist() {
        return waitlist;
    }

    public int getWaitlistSize() {
        return waitlist.size();
    }

    public ArrayList<Guest> getProcessedWaitList() {
        return processedWaitlist;
    }

    public int getProcessedWaitListSize() {
        return processedWaitlist.size();
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public String getPeakHour() {
        return peakHour;
    }

    public void setPeakHour(String peakHour) {
        this.peakHour = peakHour;
    }
}