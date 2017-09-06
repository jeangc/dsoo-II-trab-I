package app.view.list;

import app.entity.EntryEntity;
import app.table.AbstractEntityTableDataModel;
import app.table.EntryTableDataModel;
import app.view.Renderable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

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
        return (EntryEntity) tableModel.getEntity(
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
