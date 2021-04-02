package Model;

import java.awt.*;
import java.awt.geom.Path2D;

public class Hexagon extends Shapes {

    /**
     * The Constant SHAPE_TYPE indicate the the shape type.
     */
    public static final String SHAPE_TYPE = "Hexagon";

    private final double half = 0.5;
    private final double quarter = 0.25;
    private final double threequarter = 0.75;
    private Shape shape;


    /**
     * Initialise Hexagon shape.
     * @param x1 is the start x coordinate
     * @param y1 is the start y coordinate
     * @param x2 is the end x coordinate
     * @param y2 is the end y coordinate
     */
    public Hexagon(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {

        shape = new Path2D.Double();
        double width = x2 - x1;
        double height = y2 - y1;
        Path2D.Double path = new Path2D.Double();
        path.moveTo(x1 + (quarter * width), y1);
        path.lineTo(x1 + (threequarter * width), y1);
        path.lineTo(x2, y1 + (half * height));
        path.lineTo(x1 + (threequarter * width), y2);
        path.lineTo(x1 + (quarter * width), y2);
        path.lineTo(x1, y1 + (half * height));
        path.lineTo(x1 + (quarter * width), y1);
        path.closePath();
        shape = path;

        Graphics2D g2d = (Graphics2D)g;
        if ((getColor() != null) && !getColor().equals(null)) {
            g2d.setColor(super.getColor());
        }
        if (isFill()) {
            g2d.fill(shape);
        }
        g2d.draw(shape);
    }
}
