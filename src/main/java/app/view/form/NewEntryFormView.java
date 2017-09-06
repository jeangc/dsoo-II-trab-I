package app.view.form;

import app.view.Renderable;

import javax.swing.*;
import java.awt.*;

public class NewEntryFormView implements Renderable {
    private JPanel panel;
    private JTextField placa;
    private JButton saveButton;

    public Container getContainer() {
        return this.panel;
    }
}
