package Code;

/**
 * Class of enemy, there is its information and attack behaviour.
 */
public class Enemy{
    private String imgPath;
    private int xCord, yCord;
    private String lootID;
    private int damage, healthPoints;
    private long attackSpeed = 20, l = 0;

    public Enemy(String imgPath, int xCord, int yCord, String lootID, int damage, int healthPoints) {
        this.imgPath = imgPath;
        this.xCord = xCord;
        this.yCord = yCord;
        this.lootID = lootID;
        this.damage = damage;
        this.healthPoints = healthPoints;
    }

    public Enemy() {
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getxCord() {
        return xCord;
    }

    public void setxCord(int xCord) {
        this.xCord = xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public void setyCord(int yCord) {
        this.yCord = yCord;
    }

    public String getLootID() {
        return lootID;
    }

    public void setLootID(String lootID) {
        this.lootID = lootID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public String toString() {
        return "{imgPath:"+imgPath +",xCord:"+xCord+",yCord:"+yCord+",lootID:"+lootID+",damage:"+damage+",healthPoints:"+healthPoints+"}";
    }
    public void Attack(Player player){
        l++;
            if(Math.abs(this.getxCord() - player.posX) < 15 &&
                    Math.abs(this.getyCord() - player.posY) < 30 &&
                    l>attackSpeed) {
                l = 0;
                player.healthPoints -= damage;
            }
    }
}
