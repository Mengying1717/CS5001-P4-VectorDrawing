package Delegate;

import Model.*;
import Model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DrawPanel class is used to draw the shape.
 */
public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

    /**
     * The start x coordinate when you start pressing the mouse.
     */
    private int startX;

    /**
     * The start y coordinate when you start pressing the mouse.
     */
    private int startY;

    /**
     * The end x coordinate when you release the mouse
     */
    private int endX;
    /**
     * The end y coordinate when you release the mouse
     */
    private int endY;

    /**
     * Record the current selected color
     */
    private Color color;

    /**
     * Record the current shape to be draw
     * default is line
     */
    private String shapeType = Line.SHAPE_TYPE;

    /**
     * Record the history shapes to support
     * the redo operation
     */
    private List<Object> shapes = new ArrayList<>();
    private List<Object> undoShapes = new ArrayList<>();
    private boolean setFill = false;

    public DrawPanel() {
        setUI();
    }

    private void setUI() {
        // set it background color to light gray
//        setBackground(Color.LIGHT_GRAY);
        // add mouse listener event
        addMouseListener(this);
//        addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // firstly press the mouse
        this.startX = e.getX();
        this.startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // release the mouse
        this.endX = e.getX();
        this.endY = e.getY();
        draw();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * change the color.
     * @param color
     */
    public void changeColor(Color color) {
        this.color = color;
    }

    /**
     * change the shape to be draw.
     * @param shape
     */
    public void changeShape(String shape) {
        this.shapeType = shape;
    }

    /**
     *
     */
    public void draw() {
        Graphics g = this.getGraphics();
        switch (shapeType) {
            case Line.SHAPE_TYPE:
                System.out.println("draw line");
                Line line = new Line(startX,startY,endX,endY);
                line.setColor(color);
                shapes.add(line);
                line.draw(g);
                break;
            case Rectangle.SHAPE_TYPE:
                System.out.println("draw " + Rectangle.SHAPE_TYPE);
                Rectangle rectangle = new Rectangle(startX,startY,endX,endY);
                rectangle.setColor(color);
                rectangle.setFill(setFill);
                shapes.add(rectangle);
                rectangle.draw(g);
                break;
            case Square.SHAPE_TYPE:
                System.out.println("draw " + Square.SHAPE_TYPE);
                Square square = new Square(startX,startY,endX,endY);
                square.setColor(color);
                square.setFill(setFill);
                shapes.add(square);
                square.draw(g);
                break;
            case Ellipse.SHAPE_TYPE:
                System.out.println("draw " + Ellipse.SHAPE_TYPE);
                Ellipse ellipse = new Ellipse(startX,startY,endX,endY);
                ellipse.setColor(color);
                ellipse.setFill(setFill);
                shapes.add(ellipse);
                ellipse.draw(g);
                break;
            case Star.SHAPE_TYPE:
                System.out.println("draw " + Star.SHAPE_TYPE);
                Star star = new Star(startX,startY,endX,endY);
                star.setColor(color);
                star.setFill(setFill);
                shapes.add(star);
                star.draw(g);
                break;
            case Oval.SHAPE_TYPE:
                Oval oval = new Oval(startX,startY,endX,endY);
                oval.setColor(color);
                oval.setFill(setFill);
                oval.draw(g);
                shapes.add(oval);
                break;

            case Hexagon.SHAPE_TYPE:
                Hexagon hexagon = new Hexagon(startX,startY,endX,endY);
                hexagon.setColor(color);
                hexagon.setFill(setFill);
                hexagon.draw(g);
                shapes.add(hexagon);
                break;

            case Rhombus.SHAPE_TYPE:
                Rhombus rhombus = new Rhombus(startX,startY,endX,endY);
                rhombus.setColor(color);
                rhombus.setFill(setFill);
                rhombus.draw(g);
                shapes.add(rhombus);
                break;

            case Triangle.SHAPE_TYPE:
                Triangle triangle = new Triangle(startX,startY,endX,endY);
                triangle.setColor(color);
                triangle.setFill(setFill);
                triangle.draw(g);
                shapes.add(triangle);
                break;
            default:
                return;
        }
    }

    public void setSetFill(boolean setFill) {
        this.setFill = setFill;
    }

    /**
     * undo operation.
     */
    public void undo() {
        if (shapes.size() > 0) {
            // delete the last shape and repaint the shapes
            int lastIndex = shapes.size() - 1;
            // save the undo shape to the undoShapes
            undoShapes.add(shapes.get(lastIndex));
            // remove the last shape
            shapes.remove(lastIndex);
            repaintShapes();
        }
    }

    /**
     * clear all current shapes on the board.
     */
    public void clear(){
        shapes.clear();
        repaintShapes();
    }

    /**
     * Repaint the undo shape.
     */
    public void redo() {
        if (undoShapes.size() > 0) {
            int lastIndex = undoShapes.size() - 1;
            Object shape = undoShapes.get(lastIndex);
            shapes.add(shape);
            undoShapes.remove(lastIndex);
            Graphics g = this.getGraphics();
            repaintShapes();
            drawShape(g, shape);
        }
    }

    /**
     * save current shapes.
     * @param filename filename
     * @throws IOException I/o
     */
    public void saveToFile (String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(shapes);
        oos.close();
        fos.close();
    }

    /**
     * read shape from file.
     * @param filename is the file you want to load.
     * @throws IOException I/O
     * @throws ClassNotFoundException Not Found Exception
     */
    public void readFromFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Object> readList = (List<Object>) ois.readObject();
        shapes = readList;
        ois.close();
        fis.close();
    }

    /**
     * repaint all the shapes.
     */
    private void repaintShapes() {
        Graphics g = this.getGraphics();
//        super.paintComponent(g);
        g.clearRect(0,0, this.getWidth(), this.getHeight());
        for (Object shape : shapes) {
            drawShape(g, shape);
        }
    }

    /**
     * check the shape type.
     * @param g is the graphic
     * @param shape is shape
     */
    private void drawShape(Graphics g, Object shape) {
        if (shape instanceof Line) {
            Line line = (Line)shape;
            line.draw(g);
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle)shape;
            rectangle.draw(g);
        } else if (shape instanceof Square) {
            Square square = (Square)shape;
            square.draw(g);
        } else if (shape instanceof Ellipse) {
            Ellipse ellipse = (Ellipse)shape;
            ellipse.draw(g);
        } else if (shape instanceof Oval) {
            Oval oval = (Oval)shape;
            oval.draw(g);
        } else if (shape instanceof Star) {
            Star star = (Star)shape;
            star.draw(g);
        } else if (shape instanceof Hexagon) {
            Hexagon hexagon = (Hexagon)shape;
            hexagon.draw(g);
        } else if (shape instanceof Rhombus) {
            Rhombus rhombus = (Rhombus) shape;
            rhombus.draw(g);
        } else if (shape instanceof Triangle) {
            Triangle triangle = (Triangle) shape;
            triangle.draw(g);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
        repaint();
    }
}
