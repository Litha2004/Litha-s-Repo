import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BarChart extends JPanel implements ImageObserver {
    public static final int XMAX = 400;
    public static final int XSTART = 60;
    public static final int[] YMAX = { 220, 320, 420, 520 };

    // Hard code an array of 4 colors
    private final Color[] colors = { Color.BLUE, new Color(150, 150, 0), Color.DARK_GRAY, Color.MAGENTA };
    private int[][] data;
    private int barSize;

    public BarChart(int[][] dArray) {
        this.data = new int[dArray.length][dArray[0].length];
        for (int i = 0; i < dArray.length; i++) {
            System.arraycopy(dArray[i], 0, data[i], 0, dArray[i].length);
        }
        barSize = (XMAX - 20) / data[0].length;
    }

    // Method to set a new data array
    public void setArray(int[][] dArray) {
        for (int i = 0; i < dArray.length; i++) {
            System.arraycopy(dArray[i], 0, data[i], 0, dArray[i].length);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    // Method to draw the bar chart
    public void draw(Graphics g) {
        for (int i = 0; i < data.length; i++) {
            int xStart = XSTART;
            g.setColor(colors[i]);
            g.drawString("Row " + i, xStart - 50, YMAX[i]);

            for (int j = 0; j < data[i].length; j++) {
                g.fillRect(xStart, YMAX[i] - data[i][j], barSize - 5, data[i][j]);
                g.drawString("" + data[i][j], xStart, YMAX[i] + 15);
                xStart += barSize;
            }
        }
    }

    // Main method to test and display the bar chart
    public static void main(String[] args) {
        int[][] sampleData = {
                {50, 70, 90, 30},
                {40, 60, 80, 100},
                {90, 20, 50, 70},
                {60, 80, 110, 40}
        };

        JFrame frame = new JFrame("Bar Chart");
        BarChart chart = new BarChart(sampleData);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chart);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return true;
    }
}