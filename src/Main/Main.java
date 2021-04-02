package Main;

import Delegate.View;

import javax.swing.*;
import java.awt.*;

/**
 * The Main class to run the program.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        EventQueue.invokeLater(() -> {
            View view = new View();
            view.setTitle("Draw shapes");
            view.setSize(1200,700);
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            view.setVisible(true);
        });
    }
}
