package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    private static Connection c;

    public static Connection getDefaultConnection()
    {
        if (c == null) {
            try {
                c = DriverManager.getConnection("jdbc:derby:./db;create=true", "", "");

            } catch (Exception e) {
                e.printStackTrace();
            }

            createDatabaseStructure();
        }

        return c;
    }

    /**
     *
     */
    public static void closeDefaultConnection()
    {
        try {
            c.close();
            c = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    private static void createDatabaseStructure()
    {
        try {
            Statement statement1 = c.createStatement();
            statement1.execute(
                    "CREATE TABLE ENTRIES (" +
                            "id INT PRIMARY KEY, " +
                            "placa VARCHAR (255), " +
                            "entrada TIMESTAMP, " +
                            "saida TIMESTAMP" +
                            ")");
        } catch (Exception e) {
            // já existem as tabelas
        }
    }
}
