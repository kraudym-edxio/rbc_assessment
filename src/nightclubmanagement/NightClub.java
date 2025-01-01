package nightclubmanagement;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class NightClub {
    private final int MAX_CAPACITY = 7000;
    private int currentCapacity = 0;
    private Queue<Guest> waitlist;
    private ArrayList<Guest> processedWaitlist;

    public NightClub() {
        waitlist = new ArrayDeque<>();
        processedWaitlist = new ArrayList<>();
    }

    public void addGuestToWaitlist(Guest guest) {
        waitlist.add(guest);
    }

    // Admit all possible guests from the waitlist
    public void admitGuests() {
        while (!waitlist.isEmpty() && currentCapacity < MAX_CAPACITY) {
            Guest nextGuest = waitlist.poll();
            processedWaitlist.add(nextGuest);
            currentCapacity++;
        }
    }

    // Admits a single guest from the waitlist
    public void admitOneGuest() {
        if (!waitlist.isEmpty() && currentCapacity < MAX_CAPACITY) {
            Guest nextGuest = waitlist.poll();
            processedWaitlist.add(nextGuest);
            currentCapacity++;
        }
    }

    // Simulates a guest leaving the club
    public void guestLeaves() {
        if(!processedWaitlist.isEmpty()) {
            processedWaitlist.removeFirst(); // remove the guest from the admitted list
            currentCapacity--; // update the current capacity
        }
    }

    public ArrayList<Guest> getProcessedWaitList() {
        return processedWaitlist;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int getWaitlistSize() {
        return waitlist.size();
    }
}