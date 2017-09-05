package app.controller;

import app.FrameManager;
import app.model.CarModel;
import app.repository.CarRepository;
import app.view.list.CarListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarsListController {
    private CarListView list;
    private CarRepository carRepository;

    public CarsListController() {
        this.carRepository = new CarRepository();
    }

    public void openList() {
        createList();
        loadList();
        FrameManager.showIntoNewFrame(list.getContainer());
    }

    private void createList() {
        list = new CarListView();
        list.getAddButton().addActionListener(new addButtonClick());
    }

    private void loadList() {
        list.load(carRepository.getAll());
    }

    private class addButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent clickTime)  {
            CarModel car = new CarModel();
            car.setPlaca("Teste");

            carRepository.create(car);

            loadList();
        }
    }
}
