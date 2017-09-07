package app.view.form;

import app.entity.SettingsEntity;
import app.view.Renderable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SettingsFormView implements Renderable {
    private JTextField toleranciaValue;
    private JTextField periodoInicialValue;
    private JTextField valorInicialValue;
    private JTextField periodoAdicionalValue;
    private JTextField valorAdicionalValue;
    private JButton saveButton;
    private JPanel panel;

    private SettingsEntity settings;

    public SettingsFormView(SettingsEntity s) {
        this.settings = s;

        this.toleranciaValue.setText(String.valueOf(s.getToleranciaMinutos()));
        this.periodoInicialValue.setText(String.valueOf(s.getPeriodoInicialMinutos()));
        this.valorInicialValue.setText(String.valueOf(s.getValorInicial()));
        this.periodoAdicionalValue.setText(String.valueOf(s.getPeriodoMinutos()));
        this.valorAdicionalValue.setText(String.valueOf(s.getValorPeriodo()));
    }

    public SettingsEntity getSettings() {
        this.settings.setToleranciaMinutos(Integer.parseInt(this.toleranciaValue.getText()));
        this.settings.setPeriodoInicialMinutos(Integer.parseInt(this.periodoInicialValue.getText()));
        this.settings.setValorInicial(Integer.parseInt(this.valorInicialValue.getText()));
        this.settings.setPeriodoMinutos(Integer.parseInt(this.periodoAdicionalValue.getText()));
        this.settings.setValorPeriodo(Integer.parseInt(this.valorAdicionalValue.getText()));

        return this.settings;
    }

    public Container getContainer() {
        return this.panel;
    }

    public void addSaveButtonClickListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }
}
