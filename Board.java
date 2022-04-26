import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable {
    private final int B_WIDTH = 1240;
    private final int B_HEIGHT = 780;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;
    
    private Image scissors;
    private Thread animator;
    private int x, y;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;
    }

    private void loadImage() {
        ImageIcon icon = new ImageIcon("resources/scissors.png");
        scissors = icon.getImage();
    }

    private void drawScissors(Graphics g) {
        g.drawImage(scissors, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawScissors(g);
    }

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

    private void cycle() {
        x += 1;
        y += 1;

        if (y > B_HEIGHT) {
            x = INITIAL_X;
            y = INITIAL_Y;
        }
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;

        beforeTime  = System.currentTimeMillis();

        while (true) {
            cycle();
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
