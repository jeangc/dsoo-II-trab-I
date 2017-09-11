package app.view.form;

import app.entity.EntryEntity;
import app.view.Renderable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewFormView implements Renderable {
    private JPanel panel;
    private JTextField placa;
    private JButton saveButton;

    public EntryEntity getEntry() {
        EntryEntity model = new EntryEntity();
        model.setPlaca(placa.getText());

        return model;
    }

    public Container getContainer() {
        return this.panel;
    }

    public void addSaveButtonClickListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }
}
