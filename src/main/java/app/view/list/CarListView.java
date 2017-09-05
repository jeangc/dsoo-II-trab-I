package app.view.list;

import app.model.CarModel;
import app.view.Renderable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CarListView implements Renderable {
    private JPanel panel;
    private JTable table;
    private JButton add;

    public CarListView(List<CarModel> cars) {
        DefaultTableModel model;

        model = new DefaultTableModel();
        model.addColumn("Placa");

        for (CarModel car: cars) {
            model.addRow(new String[]{ car.getPlaca() });
        }

        this.table.setModel(model);
    }

    public Container getContainer() {
        return this.panel;
    }

}
