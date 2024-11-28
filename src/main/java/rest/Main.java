package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rest.dao.DatabaseConnector;
import rest.database.DBManager;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class Main {
	Connection connect = DatabaseConnector.connector();
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Main.class, args);
		DBManager db=new DBManager();
		db.createFruitTable();
		db.createSuppliersTable();
		db.createSellersTable();
	}

}

