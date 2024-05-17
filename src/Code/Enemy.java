package Code;

public class Enemy{
    private String imgPath;
    private int xCord, yCord;
    private String lootID;
    private int damage, healthPoints;

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

    @Override
    public String toString() {
        return "{imgPath:"+imgPath +",xCord:"+xCord+",yCord:"+yCord+",lootID:"+lootID+",damage:"+damage+",healthPoints:"+healthPoints+"}";
    }
}
