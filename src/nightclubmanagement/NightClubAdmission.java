package nightclubmanagement;

import java.util.ArrayDeque;
import java.util.Queue;

public class NightClubAdmission {

    public static void main(String[] args) {
        NightClub club = new NightClub();
        PerformanceTracker tracker = new PerformanceTracker();

        club.setPeakHour("12:30AM - 1:30AM");

        //2000 people who are ready to go (to be directly admitted), as per testing specifications
        Queue<Guest> outsideGuests = new ArrayDeque<>();
        for (int i = 0; i < 2000; i++) {
            outsideGuests.add(new Guest("Guest" + i));
        }
        System.out.println("Outside Queue: " + outsideGuests.size());

        club.admitDirectGuests(outsideGuests);

        //4000 people who are on waitlist, as per testing specifications
        for (int i = 2000; i < 6000; i++) {
            club.addGuestToWaitlist(new Guest("Guest" + i));
        }
        System.out.println("Waitlist: " + club.getWaitlistSize());

        tracker.logDay(club);
        System.out.println(tracker + "\n");

        //Have some guests leave to affect the capacity
        club.decreaseCurrentCapacityBy(250);
        System.out.println("Club capacity after 250 guests leave: " + club.getCurrentCapacity() + '\n');

        //Admit waitlist guests to determine how processedWaitList and waitlist are affected
        club.admitWaitlistGuests(club.getWaitlist());
        System.out.println("Club capacity after admitting guests from waitlist: " + club.getCurrentCapacity());
        tracker.logDay(club);
        System.out.println(tracker + "\n");

        //Add more guests to the waitlist
        for (int i = 6000; i < 8500; i++) {
            club.addGuestToWaitlist(new Guest("Guest" + i));
        }
        System.out.println("Waitlist after 2500 additions: " + club.getWaitlistSize() + '\n');

        club.admitWaitlistGuests(club.getWaitlist());
        System.out.println("Club capacity after admitting guests from waitlist: " + club.getCurrentCapacity());
        tracker.logDay(club);
        System.out.println(tracker);
    }
}