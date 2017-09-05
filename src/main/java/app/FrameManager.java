package app;

import javax.swing.*;
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

    static public JFrame showIntoMainFrame(Container container, String title) {
        JFrame mainFrame = getMainFrame();
        mainFrame.setTitle(frameTitlePrefix + " " + title);
        mainFrame.setContentPane(container);
        return mainFrame;
    }

    static public JFrame showIntoMainFrame(Container container) {
        return showIntoMainFrame(container, defaultFrameTitle);
    }

    static public JFrame showIntoNewFrame(Container container, String title) {
        JFrame frame = createFrame();
        frame.setContentPane(container);
        frame.setTitle(frameTitlePrefix + " " + title);
        return frame;
    }

    static public JFrame showIntoNewFrame(Container container) {
        return showIntoNewFrame(container, defaultFrameTitle);
    }

    static private JFrame getMainFrame() {
        if (mainFrame == null) {
            mainFrame = createFrame();
        }

        return mainFrame;
    }

    static private JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(300, 300));
        frame.pack();
        frame.setVisible(true);

        return frame;
    }
}
