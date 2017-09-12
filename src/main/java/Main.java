import app.FrameManager;
import app.controller.EntryListController;
import app.controller.SettingController;
import app.entity.SettingsEntity;
import app.view.form.SettingsFormView;
import app.view.list.PendingEntryListView;

import javax.swing.*;

public class Main {
    final static private String LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";

    public static void main(String[] args) {
        initLookAndFeel();
        initFrames();
        initDefaultSettings();

        PendingEntryListView view = new EntryListController().getPendingList();
        FrameManager.showIntoNewFrame(view, "Entradas pendentes");

        SettingsFormView form = new SettingController().getSettingsForm();
        FrameManager.showIntoNewFrame(form, "Configurações");
    }

    private static void initDefaultSettings() {
        SettingsEntity s = SettingsEntity.getInstance();
        s.setToleranciaMinutos(5);
        s.setPeriodoMinutos(1);
        s.setValorPeriodo(2);
        s.setPeriodoInicialMinutos(10);
        s.setValorInicial(3);
    }
    
    private static void initFrames() {
        FrameManager.setFrameTitlePrefix("Sistema AUTO - ");
    }

    private static void initLookAndFeel() {
        try {
            UIManager.setLookAndFeel(LOOK_AND_FEEL);
        }
        catch (Exception e) {
            System.err.println("Using the default look and feel.");
            e.printStackTrace();
        }
    }
}
