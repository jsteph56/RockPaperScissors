public class Scissors extends Object {
    protected static String imageLocation = "resources/scissors.png";

    private int dx;
    private int dy;

    public Scissors(int x, int y) {
        super(x, y, imageLocation);
    }

    public void move() {

    }

    public int distanceFromObjects(Object object) {
        return 0;
    }
}
