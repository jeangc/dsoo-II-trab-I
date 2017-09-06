package app.view.list;

import app.entity.EntryEntity;
import app.view.table.AbstractEntityTableDataModel;
import app.view.table.EntryTableDataModel;
import app.view.Renderable;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;

public class PendingEntryListView implements Renderable {
    private JPanel panel;
    private JButton addButton;
    private JTable pendingEntryTable;

    private AbstractEntityTableDataModel tableModel;

    public void load(List<EntryEntity> cars) {
        tableModel = new EntryTableDataModel(cars);
        pendingEntryTable.setModel(tableModel);
    }

    public EntryEntity getSelectedEntry() {
        int selectedRow = pendingEntryTable.getSelectedRow();
        int rowCount = tableModel.getRowCount();

        if (selectedRow == -1 || selectedRow >= rowCount) {
            return null;
        }

        return (EntryEntity) tableModel.getEntity(selectedRow);
    }

    public void addAddNewListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addEntrySelectListener(MouseAdapter mouseAdapter) {
        pendingEntryTable.addMouseListener(mouseAdapter);
    }

    public Container getContainer() {
        return this.panel;
    }
}
