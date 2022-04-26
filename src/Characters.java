import java.util.ArrayList;
import java.awt.Rectangle;

public abstract class Characters extends Sprite {
    protected static int numScissors = 0;
    protected static int numPaper = 0;
    protected static int numRock = 0;
    
    private static ArrayList<Characters> allObjects = new ArrayList<>();

    public Characters(int x, int y, String imageLocation) {
        super(x, y);
        allObjects.add(this);

        if (this instanceof Scissors) {
            numScissors++;
        } else if (this instanceof Rock) {
            numRock++;
        } else {
            numPaper++;
        }
        
        initObject(imageLocation);
    }

    private void initObject(String imageLocation) {
        loadImage(imageLocation);
        getimageDimensions();
    }

    public static ArrayList<Characters> getAllObjects() {
        return allObjects;
    }
    
    public double distanceFromObjects(Characters chr) {
        double yDistance = (chr.getY() - this.getY()) * (chr.getY() - this.getY());
        double xDistance = (chr.getX() - this.getX()) * (chr.getX() - this.getX());

        return Math.sqrt(yDistance + xDistance);
    }
    
    public abstract void move();
}
