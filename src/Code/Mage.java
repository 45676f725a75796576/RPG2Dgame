package Code;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Mage extends Player {
    public Mage (GamePanel panel) {
        super(panel);
        healthPoints = 8;
        damage = 2;
        speed = 5;
    }
    public Mage () {
        healthPoints = 8;
        damage = 2;
        speed = 5;
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/images/mage.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
