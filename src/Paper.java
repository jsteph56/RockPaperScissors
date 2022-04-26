public class Paper extends Object {
    protected static String imageLocation;

    private int dx;
    private int dy;

    public Paper(int x, int y) {
        super(x, y, imageLocation);
    }

    public void move() {

    }

    public int distanceFromObjects(Object object) {
        return 0;
    }
}
