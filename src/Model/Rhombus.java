package Model;

import java.awt.*;
import java.awt.geom.Path2D;

public class Rhombus extends Shapes {

    /**
     * The Constant SHAPE_TYPE indicate the the shape type.
     */
    public static final String SHAPE_TYPE = "Rhombus";

    private Shape shape;

    /**
     * Initialise Rhombus shape.
     * @param x1 is the start x coordinate
     * @param y1 is the start y coordinate
     * @param x2 is the end x coordinate
     * @param y2 is the end y coordinate
     */
    public Rhombus(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        Polygon polygon = new Polygon();
        polygon.addPoint(Math.min(x1, x2), (y1 + y2) / 2);
        polygon.addPoint((x1 + x2) / 2, Math.max(y1, y2));
        polygon.addPoint(Math.max(x1, x2), (y1 + y2) / 2);
        polygon.addPoint((x1 + x2) / 2, Math.min(y1, y2));
        shape = polygon;

        Graphics2D g2d = (Graphics2D) g;
        if ((getColor() != null) && !getColor().equals(null)) {
            g2d.setColor(super.getColor());
        }
        if (isFill()) {
            g2d.fill(shape);
        }
        g2d.draw(shape);
    }
}