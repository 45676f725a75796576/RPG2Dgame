package Code;

import javax.swing.*;
import java.awt.*;

public class EndMenu extends JPanel {
    public EndMenu(){
        setPreferredSize(new Dimension(720,520));
        setBackground(Color.BLACK);
        repaint();
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);

        g2.drawString("You have succesfully helped a novice hero with his first feat. Many adventures and achievements still await him, but you turn off the game. There is nothing further. Only potato.", 20,20);
    }
}
