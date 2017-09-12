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
        settings = s;

        toleranciaValue.setText(String.valueOf(s.getToleranciaMinutos()));
        periodoInicialValue.setText(String.valueOf(s.getPeriodoInicialMinutos()));
        valorInicialValue.setText(String.valueOf(s.getValorInicial()));
        periodoAdicionalValue.setText(String.valueOf(s.getPeriodoMinutos()));
        valorAdicionalValue.setText(String.valueOf(s.getValorPeriodo()));
    }

    public void saveSettings() {
        settings.setToleranciaMinutos(Integer.parseInt(toleranciaValue.getText()));
        settings.setPeriodoInicialMinutos(Integer.parseInt(periodoInicialValue.getText()));
        settings.setValorInicial(Float.parseFloat(valorInicialValue.getText()));
        settings.setPeriodoMinutos(Integer.parseInt(periodoAdicionalValue.getText()));
        settings.setValorPeriodo(Float.parseFloat(valorAdicionalValue.getText()));
    }

    public Container getContainer() {
        return panel;
    }

    public void addSaveButtonClickListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }
}
