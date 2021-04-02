package Model;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class Star extends Shapes {

    /**
     * The Constant SHAPE_TYPE indicate the the shape type.
     */
    public static final String SHAPE_TYPE = "Star";

    /**
     * Initialise Star shape.
     * @param x1 is the start x coordinate
     * @param y1 is the start y coordinate
     * @param x2 is the end x coordinate
     * @param y2 is the end y coordinate
     */
    public Star(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        int width = Math.abs(x1 - x2);
        int height = Math.abs(y1 - y2);
        int max = Math.max(width, height);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        //The ten top point of the star
        Point2D.Double pA=new Point2D.Double(0, 1);
        Point2D.Double pB=new Point2D.Double(-0.95106, 0.30902);
        Point2D.Double pC=new Point2D.Double(-0.58779, -0.80902);
        Point2D.Double pD=new Point2D.Double(0.58779, -0.80902);
        Point2D.Double pE=new Point2D.Double(0.95106, 0.30902);
        Point2D.Double pF=new Point2D.Double(0, -0.38197);
        Point2D.Double pG=new Point2D.Double(0.36328, -0.11804);
        Point2D.Double pH=new Point2D.Double(0.22452, 0.30902);
        Point2D.Double pI=new Point2D.Double(-0.22452, 0.30902);
        Point2D.Double pJ=new Point2D.Double(-0.36328, -0.11804);

        Point2D.Double[] points= { pA,pI,pB,pJ,pC,pF,pD,pG,pE,pH };

        Rectangle rect=new Rectangle(x1, y1, max, max);
        int radius_x = rect.width / 2;
        int radius_y = rect.height / 2;

        for(Point2D.Double point:points) {
            point.x = rect.getCenterX() + radius_x * point.x;
            point.y = rect.getCenterY() - radius_y * point.y;
        }

        if ((getColor() != null) && !getColor().equals(null)) {
            g2d.setPaint(this.color);
        }
        if (isFill()) {
            Path2D outline = new Path2D.Double();
            outline.moveTo(points[0].x, points[0].y);
            for(int i = 1;i < points.length; i++)
            {
                outline.lineTo(points[i].x, points[i].y);
            }
            outline.closePath();
            g2d.fill(outline);
        }

        Path2D outline = new Path2D.Double();
        outline.moveTo(points[0].x, points[0].y);
        for(int i = 1;i < points.length; i++)
        {
            outline.lineTo(points[i].x, points[i].y);
        }
        outline.closePath();
        g2d.draw(outline);
    }
}
