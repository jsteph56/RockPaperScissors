import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable {
    private final int B_WIDTH = 1024;
    private final int B_HEIGHT = 780;
    private final int DELAY = 25;
    
    private boolean inGame;
    private Timer timer;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        Random rand = new Random();

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setBackground(Color.black);
        inGame = true;

        Scissors scissors1 = new Scissors(rand.nextInt(1024), rand.nextInt(768));
        Scissors scissors2 = new Scissors(rand.nextInt(1024), rand.nextInt(768));
        Rock rock1 = new Rock(rand.nextInt(1024), rand.nextInt(768));

        System.out.println(Characters.numScissors);
        System.out.println(Characters.numRock);
        System.out.println(Characters.numPaper);

        //timer = new Timer(DELAY, this);
        //timer.start();
    }

    private void drawObjects(Graphics g) {
        for (Characters chr : Characters.getAllObjects()) {
            g.drawImage(chr.getImage(), chr.getX(), chr.getY(), this);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (inGame) {
            drawObjects(g);
        } else {
            //drawGameOver(g);
        }
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;

        beforeTime  = System.currentTimeMillis();

        while (true) {
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                String msg = String.format("Thread interruped: %s", e.getMessage());
                JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}
