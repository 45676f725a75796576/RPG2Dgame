package Code;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Thief extends Player {
    public Thief(GamePanel panel) {
        super(panel);
        healthPoints = 10;
        damage = 1;
        speed = 7;
    }
    public Thief() {
        healthPoints = 10;
        damage = 1;
        speed = 7;
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/images/thief.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
