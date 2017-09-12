package app.view;

import app.view.form.SettingsFormView;
import app.view.list.PendingEntryListView;

import javax.swing.*;
import java.awt.*;

public class MainView implements Renderable {
    private JPanel panel;
    private JTabbedPane tabs;

    public MainView(SettingsFormView form, PendingEntryListView list) {
        tabs.addTab("Carros", null, list.getContainer());
        tabs.addTab("Configurações", null, form.getContainer());
    }

    public Container getContainer() {
        return this.panel;
    }
}
