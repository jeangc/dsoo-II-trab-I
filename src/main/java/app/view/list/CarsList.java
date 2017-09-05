package app.view.list;

import app.view.Renderable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CarsList implements Renderable {
    private JPanel panel;
    private JTable table;
    private JButton add;

    public CarsList() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Coluna");
        model.addRow(new Object[] { "Meu valor" });

        this.table.setModel(model);
    }

    public Container getContainer() {
        return this.panel;
    }

}
