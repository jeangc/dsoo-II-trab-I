import app.FrameManager;
import app.controller.MainController;
import app.entity.SettingsEntity;

import javax.swing.*;
import java.awt.*;

public class Main {
    final static private String LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";

    public static void main(String[] args) {
        initLookAndFeel();
        initFrames();
        initDefaultSettings();

        JFrame frame;
        frame = FrameManager.showIntoMainFrame(new MainController().getView(), "Bem vindo(a)", new Dimension(600, 500));
        frame.setResizable(false);
    }

    /**
     * Configurações padrão para o cálculo do ticket
     * Considerando que a configuração é persistida na memória essa informações precisa ser definida
     *   na inicialização do projeto
     */
    private static void initDefaultSettings() {
        SettingsEntity s = SettingsEntity.getInstance();
        s.setToleranciaMinutos(5);
        s.setPeriodoMinutos(1);
        s.setValorPeriodo(2);
        s.setPeriodoInicialMinutos(10);
        s.setValorInicial(3);
    }

    /**
     * Define um prefixo para as janelas
     */
    private static void initFrames() {
        FrameManager.setFrameTitlePrefix("Sistema AUTO - ");
    }

    /**
     * Deixa as janelas bonitinhas no linux (fuck windows, yeah)
     */
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
