import java.awt.event.KeyEvent;
import java.util.ArrayList;

public abstract class Object extends Sprite {
    private static ArrayList<Object> allObjects;

    public Object(int x, int y, String imageLocation) {
        super(x, y);
        allObjects.add(this);
        
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
}
