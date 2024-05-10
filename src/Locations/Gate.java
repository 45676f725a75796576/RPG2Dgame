package Locations;

import Code.Location;

public class Gate extends Location {
    public Gate() {
        setImg("src/images/gate.png");
        setLocationInRight(new Location("src/images/location2.png"));
    }
}
