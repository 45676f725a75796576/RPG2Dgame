package Code;

import items.Air;
import items.IronArmor;
import items.Item;
import quests.QuestPattern;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Class, initializing game.aa
 */
public class Game {
    private QuestPattern currentQuest;
    private final Item[] inventory = new Item[200];
    private Location currentLocation;
    private final HashMap<String, Location> locations;
    private Player player = PlayerBuilder.builder("knight");
    private final Game g = this;
    private JFrame window;

    public static void main(String[] args){
        try {
            new Game();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Game() throws FileNotFoundException {
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new Air();
        }
        locations = new HashMap<>();
        Scanner sc = new Scanner(new File("src/Locations/LocationConfig.txt"));
        while(sc.hasNextLine()){
            Location l = LocationReadWrite.Read(sc.nextLine());
            locations.put(l.getLocationID(), l);
        }
        currentLocation = locations.get("0");

        window = new JFrame();
        window.setSize(720,540);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("RPG game");
        window.setIconImage(img());

        MainMenu menu = new MainMenu();
        final GamePanel gamePanel = new GamePanel(g, player);
        JButton thiefButton = new JButton();
        JButton knightButton = new JButton();
        JButton tankButton = new JButton();
        JButton wizardButton = new JButton();

        thiefButton.setText("START AS THIEF");
        knightButton.setText("START AS KNIGHT");
        tankButton.setText("START AS TANK");
        wizardButton.setText("START AS WIZARD");


        menu.add(thiefButton);
        menu.add(knightButton);
        menu.add(wizardButton);
        menu.add(tankButton);

        window.add(menu);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        thiefButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player = PlayerBuilder.builder("thief");
                player.gp = gamePanel;
                gamePanel.setPlayer(player);
                window.add(gamePanel);
                gamePanel.startGameThread();
                menu.setVisible(false);
            }
        });
        knightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player = PlayerBuilder.builder("knight");
                gamePanel.setPlayer(player);
                player.gp = gamePanel;
                window.add(gamePanel);
                gamePanel.startGameThread();
                menu.setVisible(false);
            }
        });
        wizardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player = PlayerBuilder.builder("mage");
                gamePanel.setPlayer(player);
                player.gp = gamePanel;
                window.add(gamePanel);
                gamePanel.startGameThread();
                menu.setVisible(false);
            }
        });
        tankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player = PlayerBuilder.builder("tank");
                gamePanel.setPlayer(player);
                player.gp = gamePanel;
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

    public Location getCurrentLocation() {
        return currentLocation;
    }
    public void setCurrentLocation(String ID) {
        this.currentLocation = locations.get(ID);
    }

    public void addItemToInventory(String lootID){
        if(lootID.equalsIgnoreCase("1")){
            for (int i = 0; i < 200; i++) {
                if(inventory[i] instanceof Air) inventory[i] = new IronArmor();
            }
        }
    }

    public JFrame getWindow() {
        return window;
    }
}
