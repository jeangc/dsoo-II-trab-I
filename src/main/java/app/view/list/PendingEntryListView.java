package app.view.list;

import app.model.EntryModel;
import app.view.Renderable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
        tableModel.addColumn("Horário de chagada");

        pendingEntryTable.setModel(tableModel);
    }

    public void load(List<EntryModel> cars) {
        tableModel.setRowCount(0);

        for (EntryModel car: cars) {
            tableModel.addRow(new String[]{ car.getPlaca() });
        }
    }

    public EntryModel getSelectedEntry() {
        return (EntryModel) tableModel.getDataVector().elementAt(
                pendingEntryTable.getSelectedRow()
        );
    }

    public void addEntrySelectListener(MouseAdapter mouseAdapter) {
        pendingEntryTable.addMouseListener(mouseAdapter);
    }

    public void addAddNewListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public Container getContainer() {
        return this.panel;
    }
}
