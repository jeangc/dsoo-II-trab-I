package app.repository;

import app.model.EntryModel;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EntryRepository extends AbstractRepository {
    public void create(EntryModel car) {
        try {
            Statement statement = getConnection().createStatement();
            statement.execute("INSERT INTO TESTE (TESTE) VALUES ('" + car.getPlaca() + "')");
        } catch (Exception e) {
            //
        }

    }

    public List<EntryModel> getAll() {
        List<EntryModel> cars = new ArrayList<EntryModel>();

        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT TESTE FROM TESTE");

            while (resultSet.next()) {
                EntryModel car = new EntryModel();
                car.setPlaca(resultSet.getString("teste"));
                cars.add(car);
            }
        } catch (Exception e) {
            //
        }

        return cars;
    }
}
