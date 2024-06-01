package Code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    Location l = new Location();

    @Test
    void getName() {
        l.setName("x");
        Assertions.assertEquals("x", l.getName());
    }

    @Test
    void setName() {
        l.setName("y");
        Assertions.assertEquals("y", l.getName());
    }

    @Test
    void addNextLocation() {
        l.addNextLocation("1");
        Assertions.assertEquals("[1]", l.getNextLocations().toString());
    }

    @Test
    void getNextLocations() {
        l.addNextLocation("1");
        Assertions.assertEquals("[1]", l.getNextLocations().toString());
    }
}