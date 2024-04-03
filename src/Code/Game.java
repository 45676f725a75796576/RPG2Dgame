package Code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Trida, spoustici a ridici hru
 */
public class Game {

    public Game(){
        BufferedImage _img = img();

        JFrame window = new JFrame();
        window.setSize(720,540);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("RPG game");
        window.setIconImage(_img);

        MainMenu menu = new MainMenu();
        GamePanel gamePanel = new GamePanel();
        JButton startButton = new JButton();

        startButton.setText("START");

        menu.add(startButton);

        window.add(menu);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.add(gamePanel);
                gamePanel.startGameThread();
                menu.setVisible(false);
            }
        });
    }

    public BufferedImage img(){
        try {
            return ImageIO.read(getClass().getResourceAsStream("/images/knight.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
