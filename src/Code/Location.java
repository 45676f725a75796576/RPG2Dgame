package Code;

public class Location {
    public Location(){

    }
    private Location locationInRight, locationInLeft;
    protected String imgPath;

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
    public String getImg() {
        return imgPath;
    }
    public void setImg(String img) {
        this.imgPath = img;
    }
    // endregion
}
