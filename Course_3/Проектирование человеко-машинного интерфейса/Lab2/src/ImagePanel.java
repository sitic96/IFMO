import javax.swing.*;
import java.awt.*;

/**
 * Created by sitora on 26.09.16.
 */
class ImagePanel extends JPanel {

    private Image image;

    public ImagePanel(String image) {
        this(new ImageIcon(image).getImage());
    }

    public ImagePanel(Image image) {

        this.image = image;
    }

    public Image getImage(){
        return this.image;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, 400, 400);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

}

