package Code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Hlavni menu
 */
public class MainMenu extends JPanel {

    /**
     * Konstruktor
     */
    public MainMenu()
    {
        setPreferredSize(new Dimension(720, 540));

        repaint();
    }

    /**
     * Metoda ktera hleda obrazek pro background hlavniho menu
     * @return background hlavniho menu
     */
    BufferedImage getImg(){
        BufferedImage _img;
        try {
            _img = ImageIO.read(getClass().getResourceAsStream("/images/MainMenuBackgroundImage.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return _img;
    }

    /**
     * Metoda pro kresleni hlavniho menu
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(getImg(), 0,0,720,540, null);
    }
}
