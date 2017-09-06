package app.view.form;

import app.entity.EntryEntity;
import app.view.Renderable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EntryBillingFormView implements Renderable {
    private JPanel panel;
    private JButton saveButton;
    private EntryEntity entry;

    public EntryBillingFormView(EntryEntity entry) {
        this.entry = entry;
    }

    public EntryEntity getEntry() {
//        entry.setPlaca(.getText());

        return entry;
    }


    public Container getContainer() {
        return this.panel;
    }

    public void addSaveButtonClickListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

}
