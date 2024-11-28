package rest.database;
import rest.dao.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
    Connection connect = DatabaseConnector.connector();

    public void createFruitTable() throws SQLException {
        connect.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS fruit(id BIGSERIAL PRIMARY KEY, " +
                "name TEXT UNIQUE NOT NULL, price NUMERIC CHECK (price>0), sellers TEXT [])");
    }

    public void createSellersTable() throws SQLException {
        connect.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS sellers(id BIGSERIAL PRIMARY KEY, " +
                "name TEXT UNIQUE NOT NULL, supplier TEXT, fruits TEXT [])");
    }

    public void createSuppliersTable() throws SQLException {
        connect.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS suppliers(id BIGSERIAL PRIMARY KEY, " +
                "name TEXT UNIQUE NOT NULL, sellers TEXT [])");
    }

    public void dropTable(String table) throws SQLException {
        connect.createStatement().executeUpdate("DROP TABLE IF EXISTS " + table);
    }

    public void truncateTable(String table) throws SQLException {
        connect.createStatement().executeUpdate("TRUNCATE TABLE " + table + " RESTART IDENTITY");
    }
}
