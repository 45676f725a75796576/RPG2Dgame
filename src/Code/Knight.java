package Code;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Knight extends Player{
    /**
     * Konstruktor
     *
     * @param gamePanel
     */


    public Knight(GamePanel gamePanel) {
        super(gamePanel);
        healthPoints = 10;
        speed = 5;
        damage = 2;
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/images/knight.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Knight(){
        healthPoints = 20;
        speed = 5;
        damage = 2;
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/images/knight.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
