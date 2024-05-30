package Code;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Read and write class, after writing location needs edit of line with nextLocations.
 * Wrong: nextLocations=["x","y"]
 * Correct: nextLocations=x,y
 * Line enemiesOnLocation doesn't need to be edited.
 */
public class LocationReadWrite {
    // dont use it pls
    public static void Write(Location location)
    {
        try {
            Gson g = new Gson();
            PrintStream p = new PrintStream("src/Locations/" + location.getName() + ".txt");
            p.println("locationID=" + location.getLocationID());
            p.println("imageOfLocationPath=" + location.getImg());
            p.println("nextLocations=" + location.getNextLocations());
            p.println("enemiesOnLocation=" + g.toJson(location.getEnemiesOnLocation()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Location Read(String locationPath){
        Location result = new Location();
        try{
            File l = new File(locationPath);
            Scanner sc = new Scanner(l);
            String[] s;
            while(sc.hasNextLine()){
                s = sc.nextLine().split("=");
                if(s[0].equalsIgnoreCase("name")) result.setName(s[1]);
                else if(s[0].equalsIgnoreCase("locationID")) result.setLocationID(s[1]);
                else if(s[0].equalsIgnoreCase("imageOfLocationPath")) result.setImageOfLocationPath(s[1]);
                else if(s[0].equalsIgnoreCase("nextLocations")) {
                    s = s[1].split(",");
                    for (int i = 0; i < s.length; i++) {
                        result.addNextLocation(s[i]);
                    }
                } else if (s[0].equalsIgnoreCase("enemiesOnLocation")) {
                    Gson g = new Gson();
                    Enemy[] enemies = g.fromJson(s[1], Enemy[].class);
                    result.setEnemiesOnLocation(new ArrayList<>(Arrays.asList(enemies)));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
