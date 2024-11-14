public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    // Constructors
    public Plot() {
        this(0, 0, 1, 1); // Default constructor
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot other) {
        this(other.x, other.y, other.width, other.depth);
    }

    // Getter and Setter methods
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Method to check if this plot overlaps with another plot
    public boolean overlaps(Plot plot) {
        return !(x + width <= plot.x || plot.x + plot.width <= x ||
                 y + depth <= plot.y || plot.y + plot.depth <= y);
    }

    // Method to check if this plot encompasses another plot
    public boolean encompasses(Plot plot) {
        return x <= plot.x && y <= plot.y &&
               x + width >= plot.x + plot.width &&
               y + depth >= plot.y + plot.depth;
    }

    // toString method in the specified format
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}