import Code.Enemy;
import Code.Game;
import Code.Location;
import Code.LocationReadWrite;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Main trida, spousti celou hru
 */
public class Main {
    public static void main(String[] args) {
        try {
            new Game();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}