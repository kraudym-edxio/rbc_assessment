package nightclubmanagement;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class NightClubAdmission {

    public static void main(String[] args) {
        NightClub club = new NightClub();   //initialize NightClub

        // Create and add 2000 guests ready to go
        IntStream.rangeClosed(1, 2000)
                .mapToObj(i -> new Guest("Guest " + i))
                .forEach(club::addGuestToWaitlist);

        club.admitGuests();     // Admit guests who are ready to go into the nightclub

        // Create and add 4000 guests to waitlist using Java Streams
        IntStream.rangeClosed(2001, 6000)
                .mapToObj(i -> new Guest("Guest " + i))
                .forEach(club::addGuestToWaitlist);

        System.out.println("Number of admitted guests: " + club.getCurrentCapacity());
        System.out.println("Number of guests left on waitlist: " + club.getWaitlistSize());

    }
}