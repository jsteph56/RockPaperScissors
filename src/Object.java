import java.awt.event.KeyEvent;
import java.util.ArrayList;

public abstract class Object extends Sprite {
    protected static int numScissors = 0;
    protected static int numPaper = 0;
    protected static int numRock = 0;
    
    private static ArrayList<Object> allObjects = new ArrayList<>();

    public Object(int x, int y, String imageLocation) {
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

    public ArrayList<Object> getAllObjects() {
        return allObjects;
    }
    
    public abstract void move();

    public abstract int distanceFromObjects(Object object);
}
