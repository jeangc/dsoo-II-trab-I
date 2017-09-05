package app;

import app.database.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");


        DatabaseConnection.getDefaultConnection();
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("SELECT teste FROM teste");

//            while (resultSet.next()) {
//                System.out.println("COLUNA:" + resultSet.getString("teste"));
//            }

        DatabaseConnection.closeDefaultConnection();
    }
}
