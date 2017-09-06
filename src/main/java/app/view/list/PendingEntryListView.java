package app.view.list;

import app.model.CarEntryModel;
import app.view.Renderable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.List;

public class PendingEntryListView implements Renderable {
    private JPanel panel;
    private JButton addButton;
    private JTable pendingEntryTable;

    private DefaultTableModel tableModel;

    public PendingEntryListView() {
        tableModel = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.addColumn("Placa");

        this.pendingEntryTable.setModel(tableModel);
    }

    public void load(List<CarEntryModel> cars) {
        tableModel.setRowCount(0);

        for (CarEntryModel car: cars) {
            tableModel.addRow(new String[]{ car.getPlaca() });
        }
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTable getPendingEntryList() {
        return pendingEntryTable;
    }

    public Container getContainer() {
        return this.panel;
    }
}
