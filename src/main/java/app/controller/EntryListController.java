package app.controller;

import app.FrameManager;
import app.component.EntryTotalPriceCalculator;
import app.entity.EntryEntity;
import app.entity.SettingsEntity;
import app.repository.EntryRepository;
import app.view.form.BillingFormView;
import app.view.form.NewFormView;
import app.view.list.PendingEntryListView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EntryListController {
    private EntryRepository entryRepository;
    private PendingEntryListView pendingList;
    private NewFormView newForm;

    public EntryListController() {
        entryRepository = new EntryRepository();

        pendingList = new PendingEntryListView();
        pendingList.addAddNewListener(new ActionListener() {
            public void actionPerformed(ActionEvent clickTime)  {
                openNewEntryDialogBox();
            }
        });
        pendingList.addEntrySelectListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                openBillingDialogBox(pendingList.getSelectedEntry());
            }
        });

        loadPendingList();
    }

    public PendingEntryListView getPendingList() {
        return pendingList;
    }

    /**
     * Abre um modal para registrar uma entrada
     */
    private void openNewEntryDialogBox() {
        newForm = new NewFormView();
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

    /**
     * Abre um modal pra visualizar os totais
     */
    private void openBillingDialogBox(EntryEntity entry) {
        if (entry == null) {
           return;
        }

        EntryTotalPriceCalculator.calculate(SettingsEntity.getInstance(), entry);

        JFrame frame;
        frame = FrameManager.showIntoNewFrame(new BillingFormView(entry), "Fechamento", new Dimension(500, 100));
        frame.setResizable(false);
    }

    /**
     * Recarrega os dados da lista de entradas pendentes
     */
    private void loadPendingList() {
        pendingList.load(entryRepository.getAll());
    }
}