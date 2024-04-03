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

    public boolean upPressed, downPressed, leftPressed, rightPressed, hit;

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

    int flip = 1,offset = 0;


    public void Draw(Graphics2D g2)
    {
        BufferedImage _image = null;

        if(upPressed && posX > 128) posX -= speed;
        if(downPressed && posX < 524) posX += speed;
        if(leftPressed && posY > -30) {posY -= speed; flip = -1; offset = 128;}
        if(rightPressed && posY < 660) {posY += speed; flip = 1; offset = 0;}

        _image = idle;

        if(flip == -1){
            offset = 128;
        }
        g2.drawImage(_image, posY + offset,posX,  (int) (gp.tileSize * 2 * flip), gp.tileSize * 2, null);
    }
}
