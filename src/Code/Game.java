package Code;

import items.Air;
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
 * Trida, spoustici a ridici hru
 */
public class Game {
    private QuestPattern currentQuest;
    private Item[] inventory = new Item[200];
    private Location currentLocation;
    private HashMap<String, Location> locations;

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

        JFrame window = new JFrame();
        window.setSize(720,540);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("RPG game");
        window.setIconImage(img());

        MainMenu menu = new MainMenu();
        GamePanel gamePanel = new GamePanel(this);
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

    public Location getCurrentLocation() {
        return currentLocation;
    }
    public void setCurrentLocation(String ID) {
        this.currentLocation = locations.get(ID);
    }
}
