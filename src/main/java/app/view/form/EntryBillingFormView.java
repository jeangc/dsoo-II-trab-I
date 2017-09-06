package app.view.form;

import app.model.EntryModel;
import app.view.Renderable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EntryBillingFormView implements Renderable {
    private JPanel panel;
    private JButton saveButton;

    public EntryBillingFormView(EntryModel entry) {

    }

    public Container getContainer() {
        return this.panel;
    }

    public void addSaveButtonClickListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

}
