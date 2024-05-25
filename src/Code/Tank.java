package Code;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Tank extends Player{
    public Tank(GamePanel panel){
        super(panel);
        healthPoints = 12;
        damage = 2;
        speed = 3;
    }
    public Tank(){
        healthPoints = 12;
        damage = 2;
        speed = 3;
        try {
            idle = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tank.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
