package Code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Hrac
 */
public class Player extends Entity {
    GamePanel gp;

    public boolean upPressed, downPressed, leftPressed, rightPressed, hit, use;

    protected int healthPoints = 20, damage = 1, speed = 5;

    protected int posX = 250, posY = 250;

    /**
     * Konstruktor
     * @param gamePanel
     */
    public Player(GamePanel gamePanel){
        this.gp = gamePanel;
    }
    public Player(){

    }

    /**
     * Metoda pro vyber obrazku
     */

    private int flip = 1,offset = 0;


    public void Draw(Graphics2D g2)
    {
        BufferedImage _image = null;

        if(upPressed && posX > 128) posX -= speed;
        if(downPressed && posX < 476) posX += speed;
        if(leftPressed && posY > -56) {posY -= speed; flip = -1; offset = 112;}
        if(rightPressed && posY < 660) {posY += speed; flip = 1; offset = 0;}

        if(use && posY < -46 && gp.game.getCurrentLocation().getNextLocations().get(1) != null) {
            gp.game.setCurrentLocation(gp.game.getCurrentLocation().getNextLocations().get(1));
            posY = 650;
        }
        if(use && posY > 650 && gp.game.getCurrentLocation().getNextLocations().get(0) != null) {
            gp.game.setCurrentLocation(gp.game.getCurrentLocation().getNextLocations().get(0));
            posY = -46;
        }

        _image = idle;
        g2.drawImage(_image, posY + offset,posX,  (int) (gp.tileSize * 2 * flip), gp.tileSize * 2, null);
    }
}
