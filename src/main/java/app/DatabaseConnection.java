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
                            "id INT not null primary key " +
                                " GENERATED ALWAYS AS IDENTITY " +
                                " (START WITH 1, INCREMENT BY 1), " +
                            "placa VARCHAR (255) DEFAULT NULL, " +
                            "entrada TIMESTAMP DEFAULT NULL, " +
                            "saida TIMESTAMP DEFAULT NULL" +
                            ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
