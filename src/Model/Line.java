package Model;

import java.awt.*;

public class Line extends Shapes {

    /**
     * The Constant SHAPE_TYPE indicate the the shape type.
     */
    public static final String SHAPE_TYPE = "Line";

    /**
     * Initialise Line shape.
     * @param x1 is the start x coordinate
     * @param y1 is the start y coordinate
     * @param x2 is the end x coordinate
     * @param y2 is the end y coordinate
     */
    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        if ((getColor() != null) && !getColor().equals(null)) {
            g2d.setColor(super.getColor());
        }
        g2d.drawLine(x1, y1, x2, y2);
    }
}
