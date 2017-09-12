package app.controller;

import app.FrameManager;
import app.entity.SettingsEntity;
import app.view.form.SettingsFormView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingController {

    private SettingsFormView settingsForm;

    public SettingController() {
        SettingsEntity settings = SettingsEntity.getInstance();

        settingsForm = new SettingsFormView(settings);
        settingsForm.addSaveButtonClickListener(new ActionListener() {
            public void actionPerformed(ActionEvent clickTime)  {
                settingsForm.saveSettings();
            }
        });
    }

    /**
     * Abre a página principal do sistema
     */
    public SettingsFormView getSettingsForm() {
        return settingsForm;
    }
}
