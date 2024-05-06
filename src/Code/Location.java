package Code;

import java.awt.image.BufferedImage;

public class Location {
    public Location(){

    }
    private Location locationInRight, locationInLeft;
    private BufferedImage img;

    // region get&set
    public Location getLocationInRight() {
        return locationInRight;
    }
    public void setLocationInRight(Location locationInRight) {
        this.locationInRight = locationInRight;
    }
    public Location getLocationInLeft() {
        return locationInLeft;
    }
    public void setLocationInLeft(Location locationInLeft) {
        this.locationInLeft = locationInLeft;
    }
    public BufferedImage getImg() {
        return img;
    }
    public void setImg(BufferedImage img) {
        this.img = img;
    }
    // endregion
}
