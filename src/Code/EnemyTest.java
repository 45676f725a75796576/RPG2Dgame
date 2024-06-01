package Code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    @Test
    void attack() {
        Player player = new Player();
        Enemy enemy = new Enemy();
        enemy.setyCord(250);
        enemy.setxCord(250);
        enemy.setDamage(1);
        for (int i = 0; i < 21; i++) {
            enemy.Attack(player);
        }
        Assertions.assertEquals(19, player.healthPoints);
    }
}