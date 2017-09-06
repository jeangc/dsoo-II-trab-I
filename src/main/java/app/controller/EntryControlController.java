package app.controller;

import app.FrameManager;
import app.model.CarEntryModel;
import app.repository.CarEntryRepository;
import app.view.form.NewEntryFormView;
import app.view.list.PendingEntryListView;

import java.awt.event.*;

public class EntryControlController {
    private PendingEntryListView list;
    private CarEntryRepository entryRepository;

    public EntryControlController() {
        this.entryRepository = new CarEntryRepository();
    }

    public void startControlPage() {
        createPendingList();
        loadPendingList();
        FrameManager.showIntoNewFrame(list.getContainer(), "Entradas pendentes");
    }

    private void startEntryPage() {
        NewEntryFormView form = new NewEntryFormView();

        FrameManager.showIntoNewFrame(form.getContainer());
//        CarEntryModel car = new CarEntryModel();
//        car.setPlaca("Teste");
//
//        entryRepository.create(car);
//        loadPendingList();
    }

    private void createPendingList() {
        list = new PendingEntryListView();
        list.getAddButton().addActionListener(new onAddEntryButtonClick());
        list.getPendingEntryList().addMouseListener(new onEntrySelect());
    }

    private void loadPendingList() {
        list.load(entryRepository.getAll());
    }

    private class onAddEntryButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent clickTime)  {
            startEntryPage();
        }
    }

    private class onEntrySelect extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            startEntryPage();
        }
    }
}
