package app.repository;

import app.model.CarModel;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarRepository extends AbstractRepository {
    public void create(CarModel car) {
        try {
            Statement statement = getConnection().createStatement();
            statement.execute("INSERT INTO TESTE (TESTE) VALUES ('" + car.getPlaca() + "')");
        } catch (Exception e) {
            //
        }

    }

    public List<CarModel> getAll() {
        List<CarModel> cars = new ArrayList<CarModel>();

        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT TESTE FROM TESTE");

            while (resultSet.next()) {
                CarModel car = new CarModel();
                car.setPlaca(resultSet.getString("teste"));
                cars.add(car);
            }
        } catch (Exception e) {
            //
        }

        return cars;
    }
}
