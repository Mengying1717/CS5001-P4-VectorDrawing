package Delegate;

import javax.swing.*;
import java.awt.*;

/**
 * create the mainPanel.
 */
public class View extends JFrame {

    /**
     *
     * @throws HeadlessException
     */
    public View() throws HeadlessException {
        setUI();
    }

    /**
     * Finish the initial job of all the components.
     */
    private void setUI() {

        /**
         * The whole pane to display all the interface.
         * and set it border layout.
         */
        JPanel mainPanel = new JPanel(new BorderLayout(0,0));

        /**
         * Add the drawing Board to the Main Panel.
         */
        DrawPanel drawingBoardPanel = new DrawPanel();
        // add it to the center of the main pane
        mainPanel.add(drawingBoardPanel, BorderLayout.CENTER);

        /**
         * Create the top operation panel.
         */
        OperationView operationPane = new OperationView(drawingBoardPanel);

        // add this operation pane to the north of the main pane
        mainPanel.add(operationPane, BorderLayout.NORTH);

        // add the main pane to frame
        add(mainPanel);
    }

}
