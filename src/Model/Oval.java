package Model;

import java.awt.*;

public class Oval extends Rectangle {

    /**
     * The Constant SHAPE_TYPE indicate the the shape type.
     */
    public static final String SHAPE_TYPE = "Circle";


    /**
     * Initialise Oval shape.
     * @param x1 is the start x coordinate
     * @param y1 is the start y coordinate
     * @param x2 is the end x coordinate
     * @param y2 is the end y coordinate
     */
    public Oval(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        if ((getColor() != null) && !getColor().equals(null)) {
            g2d.setColor(super.getColor());
        }
        if (isFill()) {
            g2d.fillOval(x1, y1, Math.min(Math.abs(y1 - y2), Math.abs(x1 - x2)), Math.min(Math.abs(y1 - y2), Math.abs(x1 - x2)));
        }
        g2d.drawOval(x1, y1, Math.min(Math.abs(y1 - y2), Math.abs(x1 - x2)), Math.min(Math.abs(y1 - y2), Math.abs(x1 - x2)));
    }
}
