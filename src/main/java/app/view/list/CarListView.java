package app.view.list;

import app.model.CarModel;
import app.view.Renderable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CarListView implements Renderable {
    private JPanel panel;
    private JTable carTable;
    private JButton addButton;

    private DefaultTableModel tableModel;

    public CarListView() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Placa");

        this.carTable.setModel(tableModel);
    }

    public void load(List<CarModel> cars) {
        tableModel.setRowCount(0);

        for (CarModel car: cars) {
            tableModel.addRow(new String[]{ car.getPlaca() });
        }
    }

    public Container getContainer() {
        return this.panel;
    }

    public JButton getAddButton() {
        return addButton;
    }
}
