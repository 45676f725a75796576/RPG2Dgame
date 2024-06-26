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
 * Code.GamePanel painting game and makes everything move.
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

    private int score = 0;
    private long recoverAttack = 0;

    public GamePanel(Game game1, Player player1)
    {
        game = game1;
        player = player1;
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
            if(player.healthPoints <= 0) {
                break;
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
            if(enemy.getxCord() > player.posX) enemy.setxCord(enemy.getxCord() - 2);
            if(enemy.getxCord() < player.posX) enemy.setxCord(enemy.getxCord() + 2);
            if(enemy.getyCord() > player.posY) enemy.setyCord(enemy.getyCord() - 2);
            if(enemy.getyCord() < player.posY) enemy.setyCord(enemy.getyCord() + 2);
            enemy.Attack(player);
            if(enemy.getHealthPoints() <= 0) score += 10;
        }

        currentLocation.getEnemiesOnLocation().removeIf(enemy -> enemy.getHealthPoints() <= 0);

        recoverAttack-=1;
        if(player.hit && recoverAttack < 0){
            recoverAttack = player.getAttackSpeed();
            player.Attack(currentLocation.getEnemiesOnLocation());
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
                g2.drawImage(ImageIO.read(new File(currentLocation.getEnemiesOnLocation().get(i).getImgPath())), currentLocation.getEnemiesOnLocation().get(i).getyCord(),currentLocation.getEnemiesOnLocation().get(i).getxCord(), tileSize * 2,tileSize * 2,null);
                g2.setColor(Color.RED);
                g2.fillRect(100,70,20*player.healthPoints, 20);
                g2.fillRect(currentLocation.getEnemiesOnLocation().get(i).getyCord(), currentLocation.getEnemiesOnLocation().get(i).getxCord(), currentLocation.getEnemiesOnLocation().get(i).getHealthPoints() * 4, 10);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(score > 16){
            g2.setColor(Color.BLACK);
            g2.fillRect(0,0,800,600);
            g2.setColor(Color.WHITE);
            g2.drawString("You have succesfully helped a novice hero with his first feat. Many adventures and achievements still await him,", 20,20);
            g2.drawString(" but you turn off the game. There is nothing further. Only potato.",20,40);
            /*try {
                g2.drawImage(ImageIO.read(getClass().getResourceAsStream("src/images/R (13).jpg")), 50, 50, 100,100,null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

             */
        }

        g2.dispose();

    }

    public void setPlayer(Player player){
        this.player = player;
    }
}
