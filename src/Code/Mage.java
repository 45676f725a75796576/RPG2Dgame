package Code;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;

public class Mage extends Player {
    public Mage (GamePanel panel) {
        super(panel);
        healthPoints = 8;
        damage = 2;
        speed = 5;
        attackSpeed = 30;
    }
    public Mage () {
        healthPoints = 8;
        damage = 2;
        speed = 5;
        attackSpeed = 30;
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/images/mage.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Attack(ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {
                enemy.setHealthPoints(enemy.getHealthPoints() - damage);
        }
    }
}
