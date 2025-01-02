package nightclubmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class NightClubTest {
    private NightClub nightClub;

    @BeforeEach
    public void setUp() {
        nightClub = new NightClub();
    }

    @Test
    public void testAdmitWaitlistGuests() {
        Queue<Guest> waitlist = new ArrayDeque<>();
        Guest guest = new Guest("John Doe");
        waitlist.add(guest);
        nightClub.addGuestToWaitlist(guest);
        nightClub.admitWaitlistGuests(waitlist);
        assertEquals(1, nightClub.getProcessedWaitListSize());
    }

    @Test
    public void testTotalIncomeAfter50Guests() {
        Queue<Guest> guestQueue = new ArrayDeque<>();
        for (int i = 0; i < 50; i++) {
            Guest guest = new Guest("Guest" + i, "gender");
            guestQueue.add(guest);
        }

        nightClub.admitDirectGuests(guestQueue);
        double expectedIncome = 50 * 10;
        double actualIncome = nightClub.getTotalIncome();
        assertEquals(expectedIncome, actualIncome);
    }
}