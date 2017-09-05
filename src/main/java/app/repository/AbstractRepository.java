package app.repository;

import app.DatabaseConnection;

import java.sql.Connection;

abstract public class AbstractRepository {
    protected Connection getConnection() {
        return DatabaseConnection.getDefaultConnection();
    }
}
