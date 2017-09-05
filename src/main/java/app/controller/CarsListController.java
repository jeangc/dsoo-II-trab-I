package app.controller;

import app.FrameManager;
import app.repository.CarRepository;
import app.view.list.CarListView;

public class CarsListController {

    private CarListView carList;

    public void open() {
        carList = new CarListView(new CarRepository().getAll());

        FrameManager.showIntoNewFrame(carList.getContainer());
    }
}
