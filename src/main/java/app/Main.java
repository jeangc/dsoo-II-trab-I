package app;

import app.database.DatabaseConnection;
import app.view.list.CarsList;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    // and "GTK"
    final static String LOOKANDFEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";

    public static void main(String[] args) {
        initLookAndFeel();

        Connection connection = DatabaseConnection.getDefaultConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT teste FROM teste");

            while (resultSet.next()) {
                System.out.println("COLUNA:" + resultSet.getString("teste"));
            }
        } catch (Exception e) {

        }

        JFrame frame = new JFrame("teste");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CarsList().getContainer());
        frame.pack();
        frame.setMinimumSize(new Dimension(200, 200));
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
