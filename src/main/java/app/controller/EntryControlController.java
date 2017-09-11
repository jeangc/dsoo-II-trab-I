package app.controller;

import app.FrameManager;
import app.component.EntryTotalPriceCalculator;
import app.entity.EntryEntity;
import app.entity.SettingsEntity;
import app.repository.EntryRepository;
import app.view.form.EntryBillingFormView;
import app.view.form.NewEntryFormView;
import app.view.list.PendingEntryListView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EntryControlController {
    private PendingEntryListView list;
    private NewEntryFormView newForm;
    private EntryRepository entryRepository;

    public EntryControlController() {
        this.entryRepository = new EntryRepository();
    }

    public void startControlPage() {
        createPendingList();
        loadPendingList();
        FrameManager.showIntoMainFrame(list, "Entradas pendentes");
    }

    private void startNewEntryPage() {
        newForm = new NewEntryFormView();
        newForm.addSaveButtonClickListener(new ActionListener() {
            public void actionPerformed(ActionEvent clickTime)  {
                entryRepository.create(newForm.getEntry());
                loadPendingList();
            }
        });

        JFrame frame;
        frame = FrameManager.showIntoNewFrame(newForm, "Nova entrada", new Dimension(300, 100));
        frame.setResizable(false);
    }

    private void startEditEntryPage() {
        EntryEntity entry = list.getSelectedEntry();

        if (entry == null) {
           return;
        }

        EntryTotalPriceCalculator.calculate(SettingsEntity.getInstance(), entry);

        JFrame frame;
        frame = FrameManager.showIntoNewFrame(new EntryBillingFormView(entry), "Fechamento", new Dimension(500, 150));
        frame.setResizable(false);
    }

    private void createPendingList() {
        list = new PendingEntryListView();
        list.addAddNewListener(new ActionListener() {
            public void actionPerformed(ActionEvent clickTime)  {
                startNewEntryPage();
            }
        });
        list.addEntrySelectListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                startEditEntryPage();
            }
        });
    }

    private void loadPendingList() {
        list.load(entryRepository.getAll());
    }
}
