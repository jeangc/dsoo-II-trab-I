package app.view;

import app.view.form.SettingsFormView;
import app.view.list.PendingEntryListView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainView implements Renderable {
    private JPanel panel;
    private JTabbedPane tabs;

    public MainView(SettingsFormView form, PendingEntryListView list) {
        tabs.addTab("Carros", null, addInternalPadding(list.getContainer()));
        tabs.addTab("Configurações", null, addInternalPadding(form.getContainer()));
    }

    public Container getContainer() {
        return this.panel;
    }

    private Container addInternalPadding(Container c) {
        Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        JPanel panel = (JPanel) c;
        panel.setBorder(padding);

        return c;
    }
}
