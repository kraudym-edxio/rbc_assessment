package nightclubmanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuestTest {

    @Test
    public void testGetName() {
        Guest guest = new Guest("John Doe", "Male");
        assertEquals("John Doe", guest.getName());
    }

    @Test
    public void testIsVIP() {
        Guest guest = new Guest("John Doe", 1, 25, "Male", true);
        assertTrue(guest.isVIP());
    }
}