package app;

import app.view.Renderable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Vai controlar as janelas abertas
 * Permtir saber qual a janela atual e etc
 *
 * Assim podemos renderizar a aplicação inteira na mesma janela e dar ao usuário uma
 *  experiência um pouco mais fluida
 */
public class FrameManager {

    private static final String defaultFrameTitle = "Nova janela";

    static private JFrame mainFrame;
    static private String frameTitlePrefix;

    static public void setFrameTitlePrefix(String prefix) {
        frameTitlePrefix = prefix;
    }

    static public JFrame showIntoMainFrame(Renderable r, String t) {
        return showFrame(getMainFrame(), t, r);
    }

    static public JFrame showIntoMainFrame(Renderable r) {
        return showFrame(getMainFrame(), r);
    }

    static public JFrame showIntoNewFrame(Renderable r, String t, Dimension d) {
        return showFrame(createFrame(), t, r, d);
    }

    static public JFrame showIntoNewFrame(Renderable r, String t) {
        return showFrame(createFrame(), t, r);
    }

    static public JFrame showIntoNewFrame(Renderable r) {
        return showFrame(createFrame(), r);
    }

    static private JFrame showFrame(JFrame frame, Renderable r) {
        return showFrame(frame, defaultFrameTitle, r);
    }
    
    static private JFrame showFrame(JFrame frame, String t, Renderable r) {
        return showFrame(frame, t, r, new Dimension(500, 250));
    }
    
    static private JFrame showFrame(JFrame frame, String t, Renderable r, Dimension d) {
        addPanelPadding(r);
        frame.setTitle(frameTitlePrefix + " " + t);
        frame.setContentPane(r.getContainer());
        frame.setSize(d);
        frame.setMinimumSize(d);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    static private void addPanelPadding(Renderable r) {
        Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        JPanel panel = (JPanel) r.getContainer();
        panel.setBorder(padding);
    }

    static private JFrame getMainFrame() {
        if (mainFrame == null) {
            mainFrame = createFrame();
        }

        return mainFrame;
    }

    static private JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationByPlatform(true);
        return frame;
    }
}
