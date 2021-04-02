package Delegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * The operationView class to display all the operation button.
 */
public class OperationView extends JPanel {

    /**
     * List all the drawing shape type
     */
    private JComboBox<String> shapeSelector;

    /**
     * Current selected color.
     */
    private Color currentColor = Color.BLACK;
    /**
     * Current selected color.
     */
    private JLabel colorLabel;

    /**
     * drawPanel object
     */
    private DrawPanel drawPanel;

    /**
     * set draw panel and all components.
     * @param drawPanel is the board showing the drawing shape
     */
    public OperationView(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        setComponent();
    }

    /**
     * add all the component to the panel.
     */
    private void setComponent() {
        // all the shape types
        String shapes[] = new String[]{"Line", "Rectangle","Square", "Circle", "Ellipse", "Star", "Hexagon", "Rhombus", "Triangle"};
        shapeSelector = new JComboBox<>(shapes);
        shapeSelector.addItemListener(ie -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                String shape = (String)ie.getItem();
                drawPanel.changeShape(shape);
            }
        });
        add(shapeSelector);

        // color change and color display
        colorLabel = new JLabel("");
        colorLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentColor = JColorChooser.showDialog(null,"Choose Color", null );
                colorLabel.setBackground(currentColor);
                colorLabel.repaint();
                drawPanel.changeColor(currentColor);
            }
        });
        colorLabel.setOpaque(true);
        colorLabel.setPreferredSize(new Dimension(20,20));
        colorLabel.setBackground(currentColor);
        add(colorLabel);

        // redo button
        JButton redoButton = new JButton("Redo");
        redoButton.addActionListener(redoEvent -> {
            drawPanel.redo();
        });
        add(redoButton);

        //undo button
        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(undoEvent -> {
            drawPanel.undo();
        });
        add(undoButton);

        // clear button
        JButton clearButton = new JButton("Clean");
        clearButton.addActionListener(e -> {
            drawPanel.clear();
        });
        add(clearButton);

        //save button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(fc);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fc.getSelectedFile();
                        drawPanel.saveToFile(file.toString());
                    }
                    catch (Exception e1) {
                        JOptionPane.showMessageDialog(new JFrame(), "Could not save file!", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
                drawPanel.repaint();
            }
        });
        add(saveButton);

        //load button
        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(fc);
                if (returnVal == JFileChooser.APPROVE_OPTION) {

                    try {
                        File file = fc.getSelectedFile();
                        drawPanel.readFromFile(file.toString());
                        drawPanel.clear();
                        drawPanel.repaint();
                    }
                    catch (Exception e1) {
                        JOptionPane.showMessageDialog(new JFrame(), "Could not load file!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        });
        add(loadButton);

        //color check box
        JCheckBox fillColorBox = new JCheckBox("Filled");
        fillColorBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    drawPanel.setSetFill(true);
                }
                else {
                    drawPanel.setSetFill(false);
                }
            }
        });
        add(fillColorBox);
    }

}
