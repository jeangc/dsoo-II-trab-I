package app.controller;

import app.FrameManager;
import app.entity.SettingsEntity;
import app.view.form.SettingsFormView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingController {

    private SettingsEntity settings;
    private SettingsFormView view;

    public SettingController() {
        settings = SettingsEntity.getInstance();
        settings.setToleranciaMinutos(5);
        settings.setPeriodoMinutos(1);
        settings.setValorPeriodo(2);
        settings.setPeriodoInicialMinutos(10);
        settings.setValorInicial(3);
    }

    /**
     * Abre a página principal do sistema
     */
    public void openSettingsDialogBox() {
        view = new SettingsFormView(settings);
        view.addSaveButtonClickListener(new ActionListener() {
            public void actionPerformed(ActionEvent clickTime)  {
                view.saveSettings();
            }
        });

        FrameManager.showIntoNewFrame(view, "Configurações");
    }
}
