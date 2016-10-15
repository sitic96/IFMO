import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by sitora on 13.10.16.
 */
public class MainFrame extends JFrame implements KeyListener {
    private GridLayout gridLayout = new GridLayout();
    private JPanel mainPanel = new JPanel(gridLayout);
    private final int x = 100;
    private int y = 100;
    private final Color RECTANGLE_COLOR = Color.orange;
    private final Color LINE_COLOR = Color.black;
    private final BasicStroke stroke;

    public MainFrame(float thickness) {
        super("Main Frame");
        this.setSize(500, 500);
        setContentPane(mainPanel);
        super.setBackground(Color.pink);

        stroke = new BasicStroke(thickness);
        addKeyListener(this);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private final int width = 100;
    private int height = 100;

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paint(g2);
        g2.setStroke(stroke);
        if (y < 100 && y > 0) {
            g2.setColor(RECTANGLE_COLOR);
            g2.fillRect(x, this.height - (this.height - y), x, y);
            g2.setColor(LINE_COLOR);
            g2.drawRect(x, this.height - (this.height - y), x, y);

            g2.setColor(RECTANGLE_COLOR);
            g2.fillRect(x, (int) this.getSize().getHeight() - 100, width, height - Math.abs(y));
            g2.setColor(LINE_COLOR);
            g2.drawRect(x, (int) this.getSize().getHeight() - 100, width, height - Math.abs(y));
        } else if (y <= 0) {
            y = (int) this.getSize().getHeight() - 100 - Math.abs(y);
            g2.setColor(RECTANGLE_COLOR);
            g2.fillRect(x, y, width, height);
            g2.setColor(LINE_COLOR);
            g2.drawRect(x, y, width, height);
        } else if (y > this.getSize().getHeight() - 100 && y < 500) {
            g2.setColor(RECTANGLE_COLOR);
            g2.fillRect(x, y - ((int) this.getSize().getHeight() - 100), x, y - ((int) this.getSize().getHeight() - 100));
            g2.setColor(LINE_COLOR);
            g2.drawRect(x, y - ((int) this.getSize().getHeight() - 100), x, y - ((int) this.getSize().getHeight() - 100));

            g2.setColor(RECTANGLE_COLOR);
            g2.fillRect(x, (int) this.getSize().getHeight() - 100, width, height - (y - ((int) this.getSize().getHeight() - 100)));
            g2.setColor(LINE_COLOR);
            g2.drawRect(x, (int) this.getSize().getHeight() - 100, width, height - (y - ((int) this.getSize().getHeight() - 100)));
        } else if (y >= 500) {
            y = 100;
            g2.setColor(RECTANGLE_COLOR);
            g2.fillRect(x, y, width, height);
            g2.setColor(LINE_COLOR);
            g2.drawRect(x, y, width, height);
        } else {
            g2.setColor(RECTANGLE_COLOR);
            g2.fillRect(x, y, width, height);
            g2.setColor(LINE_COLOR);
            g2.drawRect(x, y, width, height);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.moveUp();
        }
    }

    private void moveUp() {
        y -= 10;
        repaint();
    }

    private void moveDown() {
        y += 10;
        repaint();
    }
}
