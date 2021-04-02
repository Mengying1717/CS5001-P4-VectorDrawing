package Model;

import java.awt.*;
import java.io.Serializable;

public abstract class Shapes implements Serializable {

    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    protected int width;
    protected int height;
    protected Color color;
    private boolean fill = false;

    /**
     * Initialise a shape with black color.
     * @param x1 is the start x coordinate
     * @param y1 is the start y coordinate
     * @param x2 is the end x coordinate
     * @param y2 is the end y coordinate
     */
    public Shapes(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.width = 0;
        this.height = 0;
        this.color = Color.BLACK;

    }

    /**
     * An abstract method that draw shape.
     * @param g graphic to draw on
     */
    public abstract void draw(Graphics g);

    /**
     * get the initial x of the point.
     * @return x number
     */
    public int getX1() {
        return this.x1;
    }

    /**
     * get the initial y of the point.
     * @return y2 number
     */
    public int getY2() {
        return this.y2;
    }

    /**
     * get the initial x of the point.
     * @return x2 number
     */
    public int getX2() {
        return this.x2;
    }

    /**
     * get the initial y of the point.
     * @return y number
     */
    public int getY1() {
        return this.y1;
    }

    /**
     * get the width of the shape.
     * @return width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * get the height of the shape.
     * @return height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * getter.
     * @return color
     */

    public Color getColor() {
        return this.color;
    }

    /**
     * A setter method for the color of the Shapes
     * @param color the color to set for the Shapes
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * getter.
     * @return the boolean value of fill
     */
    public boolean isFill() {
        return fill;
    }

    /**
     * setter.
     * @param fill is the condition about whether the shape is filled.
     */
    public void setFill(boolean fill) {
        this.fill = fill;
    }
}
