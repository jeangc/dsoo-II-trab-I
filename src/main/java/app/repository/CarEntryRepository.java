package app.repository;

import app.model.CarEntryModel;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarEntryRepository extends AbstractRepository {
    public void create(CarEntryModel car) {
        try {
            Statement statement = getConnection().createStatement();
            statement.execute("INSERT INTO TESTE (TESTE) VALUES ('" + car.getPlaca() + "')");
        } catch (Exception e) {
            //
        }

    }

    public List<CarEntryModel> getAll() {
        List<CarEntryModel> cars = new ArrayList<CarEntryModel>();

        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT TESTE FROM TESTE");

            while (resultSet.next()) {
                CarEntryModel car = new CarEntryModel();
                car.setPlaca(resultSet.getString("teste"));
                cars.add(car);
            }
        } catch (Exception e) {
            //
        }

        return cars;
    }
}
