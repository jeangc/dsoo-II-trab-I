package app.view.form;

import app.entity.EntryEntity;
import app.view.Renderable;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewFormView implements Renderable {
    private JPanel panel;
    private JFormattedTextField placa;
    private JButton saveButton;

    public EntryEntity getEntry() {
        EntryEntity model;
        model = new EntryEntity();
        model.setPlaca(placa.getText());

        return model;
    }

    public Container getContainer() {
        return this.panel;
    }

    public void addSaveButtonClickListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    private void createUIComponents() {
        try{
            placa = new JFormattedTextField(new MaskFormatter("### ####"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
