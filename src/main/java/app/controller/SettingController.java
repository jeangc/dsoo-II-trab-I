package app.controller;

import app.entity.SettingsEntity;
import app.view.form.SettingsFormView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SettingController {

    private SettingsFormView settingsForm;

    SettingController() {
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
    SettingsFormView getSettingsForm() {
        return settingsForm;
    }
}
