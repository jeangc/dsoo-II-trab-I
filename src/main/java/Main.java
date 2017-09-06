import app.FrameManager;
import app.controller.EntryControlController;

import javax.swing.*;

public class Main {
    final static private String LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";

    public static void main(String[] args) {
        initLookAndFeel();
        initFrames();

        new EntryControlController().startControlPage();
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
