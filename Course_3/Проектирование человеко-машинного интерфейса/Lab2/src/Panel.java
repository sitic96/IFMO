import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

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
        //img = doWork(-1);
        img = doSecondWork();
        saveResult("test", img);
        showImage(img, 1, 2, c);

        addFileChooser(0, 3, c);
        addButton("Save", 2, 3, c);
        addTextField(1, 3, c);

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
                for (int i = 0; i < panel.getComponentCount(); i++) {
                    if (panel.getComponent(i) instanceof ImagePanel) {
                        panel.remove(i);
                        i--;
                    }
                }
                showImage(getImage(file), 0, 2, c);
                showImage(doSecondWork(getImage(file)), 1, 2, c);
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

    private BufferedImage doSecondWork() {
        BufferedImage temp = getImage();
        return doSecondWork(temp);
    }

    private BufferedImage doSecondWork(BufferedImage temp){
        for (int i = 0; i < temp.getWidth(); i++) {
            for (int j = 0; j < temp.getHeight(); j++) {
                String line = Integer.toHexString(temp.getRGB(i, j));
                temp.setRGB(i, j, swapGB(line));
            }
        }
        return temp;
    }

    private Integer swapGB(String line) {
        String newLine = line.substring(0, line.length() - 4);
        newLine += line.substring(line.length() - 2, line.length());
        newLine += line.substring(line.length() - 4, line.length() - 2);
        int result=0;
        try {
            result = new BigInteger(newLine, 16).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BigInteger(newLine, 16).intValue();
    }

    private void saveResult(String name, BufferedImage image) {
        BufferedImage newBufferedImage = new BufferedImage(image.getWidth(),
                image.getHeight(), BufferedImage.TYPE_INT_RGB);
        newBufferedImage.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);

        File outputfile = new File("src/images/saved/" + name + ".bmp");
        try {
            ImageIO.write(newBufferedImage, "bmp", outputfile);
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

    private void addButton(String text, int x, int y, GridBagConstraints c) {
        JButton button = new JButton(text);
        ImagePanel element;
        button.addActionListener(e -> {
            int i = 0;
            for (Component comp : panel.getComponents()) {
                if (comp instanceof ImagePanel) {
                    if (i > 0) {
                        if (textField.getText() != null && textField.getText() != "") {
                            saveResult(textField.getText(), (BufferedImage) ((ImagePanel) comp).getImage());
                        } else {
                            saveResult("resultAfterSaveButtonClick", (BufferedImage) ((ImagePanel) comp).getImage());
                        }
                    }
                    i++;
                }
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = x;
        c.gridy = y;
        panel.add(button, c);
    }

    private TextField textField;

    private void addTextField(int x, int y, GridBagConstraints c) {
        textField = new TextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = x;
        c.gridy = y;
        panel.add(textField, c);
    }
}
