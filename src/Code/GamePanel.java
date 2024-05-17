package Code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Code.GamePanel ridi co vidi hrac
 */
public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int scale = 3;

    public int tileSize = originalTileSize * scale;

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    private int idle = 0;

    private int FPS = 30;

    private KeyHandler keyH = new KeyHandler();
    private Thread gameThread;

    private Player player = PlayerBuilder.builder("thief");
    Game game;

    private Location currentLocation;

    private BufferedImage bg;

    int score = 0;

    public GamePanel(Game game1)
    {
        game = game1;
        currentLocation = game.getCurrentLocation();
        player.gp = this;
        Random r = new Random();
        this.setPreferredSize(new Dimension(720, 540));
        this.setBackground(Color.getHSBColor(0.33f,1.0f,0.21f));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        TryGetBG();
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void TryGetBG(){
        try {
            bg = ImageIO.read(new File(currentLocation.getImg()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null)
        {
            update();

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){remainingTime = 0;}

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update()
    {
        player.upPressed = keyH.upPressed;
        player.downPressed = keyH.downPressed;
        player.leftPressed = keyH.leftPressed;
        player.rightPressed = keyH.rightPressed;
        player.hit = keyH.hit;
        player.use = keyH.use;
        if(!currentLocation.getClass().equals(game.getCurrentLocation())){
            currentLocation = game.getCurrentLocation();
            TryGetBG();
        }
        for (Enemy enemy : currentLocation.getEnemiesOnLocation()) {
            enemy.setxCord(enemy.getxCord() + (int) (5 * ));
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.drawImage(bg, 0,0,720,540, null);

        player.Draw(g2);

        g2.setColor(Color.WHITE);
        g2.drawString("money: " + score, 100, 100);

        for (int i = 0; i < currentLocation.getEnemiesOnLocation().size(); i++) {
            try {
                g2.drawImage(ImageIO.read(new File(currentLocation.getEnemiesOnLocation().get(i).getImgPath())), currentLocation.getEnemiesOnLocation().get(i).getxCord(),currentLocation.getEnemiesOnLocation().get(i).getyCord(), tileSize * 2,tileSize * 2,null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        g2.dispose();

    }
}
