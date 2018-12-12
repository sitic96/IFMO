import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by sitora on 25.09.16.
 */
public class Panel extends JFrame {
    private GridBagLayout layout = new GridBagLayout();
    private JPanel panel = new JPanel(layout);
    private GridBagConstraints c = new GridBagConstraints();

    final BufferedImage originalImage;
    final BufferedImage img;
    private final String path;

    public Panel(String pathToImage) {
        super("Lab1");
        this.setSize(1000, 800);
        this.setResizable(false);
        setContentPane(panel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        path = pathToImage;
        addLabel("Lab#1", 0, 0, c);
        addLabel("Original", 0, 1, c);
        addLabel("Result", 1, 1, c);

        originalImage = this.getImage();
        showImage(originalImage, 0, 2, c);
        img = doWork(-1);
        saveResult("test", img);
        showImage(img, 1, 2, c);

        addFileChooser(0, 3, c);

        this.pack();
        setVisible(true);
    }

    private void addFileChooser(int x, int y, GridBagConstraints c) {
        JButton button = new JButton("Показать JFileChooser");
        button.setAlignmentX(CENTER_ALIGNMENT);

        button.addActionListener(e -> {
            JFileChooser fileopen1 = new JFileChooser();
            int ret1 = fileopen1.showDialog(null, "Открыть файл");
            if (ret1 == JFileChooser.APPROVE_OPTION) {
                File file = fileopen1.getSelectedFile();
                for (int i=0;i<panel.getComponentCount();i++){
                    if(panel.getComponent(i)instanceof ImagePanel){
                        panel.remove(i);
                        i--;
                    }
                }
                showImage(getImage(file), 0, 2, c);
                showImage(doWork(getImage(file)), 1, 2, c);
                this.invalidate();
                this.validate();
                this.repaint();
            }
        });

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = x;
        c.gridy = y;
        panel.add(button, c);
    }

    private BufferedImage getImage() {
        BufferedImage tempImage;
        try {
            tempImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
        return tempImage;
    }

    private BufferedImage getImage(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * public for testing getRGB/setRGB time
     **/
    public BufferedImage doWork(BufferedImage temp, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                temp.setRGB(i, j, temp.getRGB(i, j) & 0xFFFF00FF);
            }
        }
        return temp;
    }

    /**
     * public for testing second time
     **/
    public int[][] doWork(int[][] pixels) {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                pixels[i][j] = pixels[i][j] & 0xFFFF00FF;
            }
        }
        return pixels;
    }

    private BufferedImage doWork(BufferedImage image) {
        return doWork(image, image.getWidth(), image.getHeight());
    }

    private BufferedImage createImage(int[][] array) {
        BufferedImage bufferedImage = new BufferedImage(array.length, array.length, BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array.length; col++) {
                bufferedImage.setRGB(row, col, array[row][col]);
            }
        }
        return bufferedImage;
    }

    private BufferedImage doWork(int size) {
        BufferedImage temp = getImage();

        int width, height;
        if (size <= 0) {
            width = temp.getWidth();
            height = temp.getHeight();
        } else {
            width = size;
            height = size;
        }
        return doWork(temp, width, height);
    }

    private void saveResult(String name, BufferedImage image) {
        File outputfile = new File(name + ".bmp");
        try {
            ImageIO.write(image, "bmp", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showImage(BufferedImage image, int x, int y, GridBagConstraints c) {
        ImagePanel ip = new ImagePanel(image);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = x;
        c.gridy = y;
        ip.setPreferredSize(new Dimension(400, 400));
        panel.add(ip, c);
    }

    private void addLabel(String text, int x, int y, GridBagConstraints c) {
        JLabel label = new JLabel(text);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = x;
        c.gridy = y;
        panel.add(label, c);
    }
}
