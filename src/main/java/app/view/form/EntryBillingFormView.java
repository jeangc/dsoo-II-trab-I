package app.view.form;

import app.entity.EntryEntity;
import app.view.Renderable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;

public class EntryBillingFormView implements Renderable {
    private JPanel panel;
    private JButton saveButton;
    private JTextPane totalValue;
    private JLabel totalLabel;
    private JLabel tempoLabel;
    private JTextPane tempoValue;
    private EntryEntity entry;

    public EntryBillingFormView(EntryEntity entry) {
        this.entry = entry;
        this.totalValue.setText(String.format(Locale.getDefault(), "%.2f", entry.getValorTotal()));
        this.tempoValue.setText(String.format(Locale.getDefault(), "%.2f", entry.getTempoTotal()));
    }

    public EntryEntity getEntry() {
        return entry;
    }

    public Container getContainer() {
        return this.panel;
    }

    public void addSaveButtonClickListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }
}
