package app.controller;

import app.view.MainView;
import app.view.form.SettingsFormView;
import app.view.list.PendingEntryListView;

public class MainController {
    private MainView view;

    public MainController() {
        PendingEntryListView list = new EntryListController().getPendingList();
        SettingsFormView form = new SettingController().getSettingsForm();

        view = new MainView(form, list);
    }

    public MainView getView() {
        return view;
    }
}
