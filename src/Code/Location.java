package Code;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class with every information about location
 */
public class Location implements Serializable {
    private String locationID;
    private String name;
    private String imageOfLocationPath;
    private ArrayList<String> nextLocations = new ArrayList<>();
    private ArrayList<Enemy> enemiesOnLocation = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return imageOfLocationPath;
    }

    public void setImageOfLocationPath(String imageOfLocationPath) {
        this.imageOfLocationPath = imageOfLocationPath;
    }

    public void addNextLocation(String locationID)
    {
        nextLocations.add(locationID);
    }

    public ArrayList<String> getNextLocations() {
        return nextLocations;
    }

    public String getLocationID(){
        return locationID;
    }
    public void setLocationID(String ID){
        locationID = ID;
    }

    public ArrayList<Enemy> getEnemiesOnLocation() {
        return enemiesOnLocation;
    }

    public void setEnemiesOnLocation(ArrayList<Enemy> enemiesOnLocation) {
        this.enemiesOnLocation = enemiesOnLocation;
    }
}
