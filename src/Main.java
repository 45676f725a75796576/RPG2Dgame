import Code.Game;

import java.io.FileNotFoundException;

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