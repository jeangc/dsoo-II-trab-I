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
            statement.execute("INSERT INTO ENTRIES (PLACA, ENTRADA) VALUES ('" + car.getPlaca() + "', now())");
        } catch (Exception e) {
            //
        }

    }

    public List<EntryEntity> getAll() {
        List<EntryEntity> cars = new ArrayList<EntryEntity>();

        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT PLACA, ENTRADA FROM ENTRIES");

            while (resultSet.next()) {
                EntryEntity car = new EntryEntity();
                car.setPlaca(resultSet.getString("PLACA"));
                car.setEntrada(resultSet.getString("ENTRADA"));
                cars.add(car);
            }
        } catch (Exception e) {
            //
        }

        return cars;
    }
}
