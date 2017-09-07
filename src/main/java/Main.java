import app.FrameManager;
import app.controller.EntryControlController;
import app.entity.SettingsEntity;
import app.view.form.SettingsFormView;

import javax.swing.*;
import java.awt.*;

public class Main {
    final static private String LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";

    public static void main(String[] args) {
        initLookAndFeel();
        initFrames();
        initSettingsMock();

        new EntryControlController().startControlPage();
    }

    private static void initSettingsMock() {
        SettingsEntity t = SettingsEntity.getInstance();

        t.setToleranciaMinutos(5);
        t.setPeriodoMinutos(1);
        t.setValorPeriodo(2);
        t.setPeriodoInicialMinutos(10);
        t.setValorInicial(3);
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
