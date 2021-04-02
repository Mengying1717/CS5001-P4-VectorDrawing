package test;

import Model.Ellipse;
import Model.Hexagon;
import Model.Line;
import Model.Oval;
import Model.Rectangle;
import Model.Rhombus;
import Model.Square;
import Model.Star;
import Model.Triangle;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class ModelTest {

    private Ellipse ellipse;
    private Hexagon hexagon;
    private Line line;
    private Oval oval;
    private Rectangle rectangle;
    private Rhombus rhombus;
    private Square square;
    private Star star;
    private Triangle triangle;

    @Before
    public void setUp() {
        ellipse = new Ellipse(25, 25, 50, 50);
        ellipse.setColor(Color.black);
        hexagon = new Hexagon(25, 25, 50, 50);
        hexagon.setColor(Color.blue);
        line = new Line(25, 25, 50, 50);
        line.setColor(Color.pink);
        oval = new Oval(25, 25, 50, 50);
        oval.setColor(Color.black);
        rectangle = new Rectangle(25, 25, 50, 50);
        rectangle.setColor(Color.black);
        rhombus = new Rhombus(25, 25, 50, 50);
        rhombus.setColor(Color.black);
        square = new Square(25, 25, 50, 50);
        square.setColor(Color.black);
        star = new Star(25, 25, 50, 50);
        star.setColor(Color.black);
        triangle = new Triangle(25, 25, 50, 50);
        star.setColor(Color.black);
    }

    @Test
    public void testEllipse() {
        assertEquals(25, ellipse.getX1());
        assertEquals(25, ellipse.getY1());
        assertEquals(50, ellipse.getX2());
        assertEquals(50, ellipse.getY2());
        assertEquals(Color.black, ellipse.getColor());
    }

    @Test
    public void testHexagon() {
        assertEquals(25, hexagon.getX1());
        assertEquals(25, hexagon.getY1());
        assertEquals(50, hexagon.getX2());
        assertEquals(50, hexagon.getY2());
        assertEquals(Color.blue, hexagon.getColor());
    }

    @Test
    public void testLine() {
        assertEquals(25, line.getX1());
        assertEquals(25, line.getY1());
        assertEquals(50, line.getX2());
        assertEquals(50, line.getY2());
        assertEquals(Color.pink, line.getColor());
    }

    @Test
    public void testOval() {
        assertEquals(25, oval.getX1());
        assertEquals(25, oval.getY1());
        assertEquals(50, oval.getX2());
        assertEquals(50, oval.getY2());
        assertEquals(Color.black, oval.getColor());
    }

    @Test
    public void testRectangle() {
        assertEquals(25, rectangle.getX1());
        assertEquals(25, rectangle.getY1());
        assertEquals(50, rectangle.getX2());
        assertEquals(50, rectangle.getY2());
        assertEquals(Color.black, rectangle.getColor());
    }

    @Test
    public void testRhombus() {
        assertEquals(25, rhombus.getX1());
        assertEquals(25, rhombus.getY1());
        assertEquals(50, rhombus.getX2());
        assertEquals(50, rhombus.getY2());
        assertEquals(Color.black, rhombus.getColor());
    }

    @Test
    public void testSquare() {
        assertEquals(25, oval.getX1());
        assertEquals(25, oval.getY1());
        assertEquals(50, oval.getX2());
        assertEquals(50, oval.getY2());
        assertEquals(Color.black, oval.getColor());
    }


    @Test
    public void testStar() {
        assertEquals(25, star.getX1());
        assertEquals(25, star.getY1());
        assertEquals(50, star.getX2());
        assertEquals(50, star.getY2());
        assertEquals(Color.black, star.getColor());
    }

    @Test
    public void testTriangle() {
        assertEquals(25, triangle.getX1());
        assertEquals(25, triangle.getY1());
        assertEquals(50, triangle.getX2());
        assertEquals(50, triangle.getY2());
        assertEquals(Color.black, triangle.getColor());
    }


}
