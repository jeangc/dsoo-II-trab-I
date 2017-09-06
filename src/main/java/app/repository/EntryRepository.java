package app.repository;

import app.entity.EntryEntity;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EntryRepository extends AbstractRepository {
    public void create(EntryEntity car) {
        try {
            Statement statement = getConnection().createStatement();
            statement.execute("INSERT INTO TESTE (TESTE) VALUES ('" + car.getPlaca() + "')");
        } catch (Exception e) {
            //
        }

    }

    public List<EntryEntity> getAll() {
        List<EntryEntity> cars = new ArrayList<EntryEntity>();

        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT TESTE FROM TESTE");

            while (resultSet.next()) {
                EntryEntity car = new EntryEntity();
                car.setPlaca(resultSet.getString("teste"));
                cars.add(car);
            }
        } catch (Exception e) {
            //
        }

        return cars;
    }
}
