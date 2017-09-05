package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        testDatabase();
    }

    private static void testDatabase() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:derby:./db;create=true", "", "");
            Statement statement1 = connection.createStatement();
            statement1.execute("CREATE TABLE teste (teste VARCHAR (255))");

            Statement statement2 = connection.createStatement();
            statement2.execute("INSERT INTO teste (teste) VALUES ('oh meu deus')");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT teste FROM teste");

            while (resultSet.next()) {
                System.out.println("COLUNA:" + resultSet.getString("teste"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
