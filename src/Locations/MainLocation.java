package Locations;

import Code.Location;

public class MainLocation extends Location {
    public MainLocation(){
        imgPath = "src/images/location1.png";
        setLocationInLeft(new Location("src/images/location2.png"));
        getLocationInLeft().setLocationInRight(this);
        getLocationInLeft().setLocationInLeft(new Gate());
    }
}
