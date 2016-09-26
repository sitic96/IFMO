import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by sitora on 26.09.16.
 */
public class PanelTest {
    private BufferedImage[] images;
    private Integer name = 0;
    private BufferedImage image;

    @Before
    public void setUp() throws Exception {
        images = new BufferedImage[10];
        for (BufferedImage image : images) {
            name += 100;
            this.image = getImage("src/images/" + name + ".bmp");
            testWithoutGetSet();
            testWithGetSet();
        }

    }

    private BufferedImage getImage(String path) {
        BufferedImage tempImage;
        try {
            tempImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
        return tempImage;
    }

    private Panel panel = new Panel("src/images/rainbow.bmp");

    @Test
    public void testWithoutGetSet() {
        System.out.println("Without:");
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] result = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                result[row][col] = image.getRGB(col, row);
            }
        }
        long start = System.nanoTime();
        panel.doWork(result);
        long end = System.nanoTime() - start;

        System.out.println(name + " " + end);
    }

    @Test
    public void testWithGetSet() {
        System.out.println("With:");
            long start = System.nanoTime();
            panel.doWork(image, name, name);
            long end = System.nanoTime()-start;
            System.out.println(name+" "+ end);
        }
    }
