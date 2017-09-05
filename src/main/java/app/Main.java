package app;

import app.database.DatabaseConnection;
import app.view.list.CarsList;

import javax.swing.*;
import java.awt.*;

public class Main {
    // and "GTK"
    final static String LOOKANDFEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";

    public static void main(String[] args) {
        initLookAndFeel();

        JFrame frame = new JFrame("teste");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(200, 200));
        frame.setContentPane(new CarsList().getContainer());
        frame.pack();
        frame.setVisible(true);

        DatabaseConnection.closeDefaultConnection();
    }

    private static void initLookAndFeel() {
        try {
            UIManager.setLookAndFeel(LOOKANDFEEL);
        }
        catch (Exception e) {
            System.err.println("Couldn't get specified look and feel (" + LOOKANDFEEL + "), for some reason.");
            System.err.println("Using the default look and feel.");
            e.printStackTrace();
        }
    }
}
