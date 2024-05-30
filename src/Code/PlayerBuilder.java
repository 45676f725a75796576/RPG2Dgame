package Code;

/**
 * Class, which creates object of player using input String.
 */
public class PlayerBuilder {
    public static Player builder(String heroClass){
        Player hero;
        switch (heroClass){
            case "thief" -> hero = new Thief();
            case "mage" -> hero = new Mage();
            case "tank" -> hero = new Tank();
            default -> hero = new Knight();
        }
        return hero;
    }
}
