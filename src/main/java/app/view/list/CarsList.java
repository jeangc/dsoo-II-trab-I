package app.view.list;

import app.DatabaseConnection;
import app.view.Renderable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CarsList implements Renderable {
    private JPanel panel;
    private JTable table;
    private JButton add;

    public CarsList() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Coluna");

        Connection connection = DatabaseConnection.getDefaultConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT teste FROM teste");

            while (resultSet.next()) {
                model.addRow(new Object[] { resultSet.getString("teste") });
            }
        } catch (Exception e) {
            //
        }

        this.table.setModel(model);
    }

    public Container getContainer() {
        return this.panel;
    }

}
