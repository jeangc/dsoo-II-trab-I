import app.FrameManager;
import app.view.list.CarsListView;

import javax.swing.*;

public class Main {
    final static private String LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";

    public static void main(String[] args) {
        initLookAndFeel();

        FrameManager.setFrameTitlePrefix("Sistema AUTO - ");
        FrameManager.showIntoNewFrame(new CarsListView().getContainer());
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
