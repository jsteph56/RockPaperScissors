import java.awt.EventQueue;
import javax.swing.JFrame;

public class Application extends JFrame {
    
    public Application() {
        initUI();
    }

    private void initUI() {
        add(new Board());
        setSize(1240, 780);

        setTitle("Rock - Paper - Scissors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application exe = new Application();
            exe.setVisible(true);
        });
    }
}
