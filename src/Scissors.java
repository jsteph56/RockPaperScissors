import java.util.PriorityQueue;

public class Scissors extends Characters {
    protected static String imageLocation = "resources/scissors.png";

    private int dx;
    private int dy;

    public Scissors(int x, int y) {
        super(x, y, imageLocation);
    }

    public void move() {
        PriorityQueue<Characters> objDistances = new PriorityQueue<>();
        double minDistance = Double.MAX_VALUE;
        Characters closest = null;

        for (Characters chr : Characters.getAllObjects()) {
            if (chr instanceof Scissors) continue;
            double temp = this.distanceFromObjects(chr);

            if (temp < minDistance) {
                minDistance = temp;
                closest = chr;
            }
        }

        if (closest instanceof Rock) {
            //logic to move away form Rock
        } else if (closest instanceof Paper) {
            //logic to move towards Paper
        }
    }
}
