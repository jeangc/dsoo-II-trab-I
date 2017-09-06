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
            statement.execute("INSERT INTO ENTRIES (placa, entrada) VALUES ('" + car.getPlaca() + "', CURRENT_TIMESTAMP)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<EntryEntity> getAll() {
        List<EntryEntity> cars = new ArrayList<EntryEntity>();

        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, placa, entrada, saida FROM ENTRIES"
                );

            while (resultSet.next()) {
                EntryEntity car = new EntryEntity();
                car.setId(resultSet.getInt("id"));
                car.setPlaca(resultSet.getString("placa"));
                car.setEntrada(resultSet.getTimestamp("entrada"));
                car.setSaida(resultSet.getTimestamp("saida"));
                cars.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cars;
    }
}
