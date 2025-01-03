package com.labexam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class DBConnectionManager {
	private String databaseName = "TodoDB";
	private String tableName = "tasks";
	private String url = "jdbc:mysql://localhost:3306/" + databaseName;
	private String username = "root";
	private String password = "Password1234!@#$";
    private String loginTableName = "login";

	public Connection openConnection() throws SQLException {
		createDatabase();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println(e);
		}
		createTable(conn);
        createLoginTable(conn);
		return conn;
	}

	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void createDatabase() {
        String createDataBaseCommand = "CREATE DATABASE IF NOT EXISTS " + databaseName;
        String url = "jdbc:mysql://localhost:3306/";

        try (Connection connection = DriverManager.getConnection(url, username, password); Statement statement = connection.createStatement();) {
            statement.executeUpdate(createDataBaseCommand);

            System.out.println("Database " + databaseName + " created!");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
	
	public void createTable(Connection connection) {

        String createTableCommand = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id int auto_increment primary key,"
                + "description varchar(255),"
                + "status varchar(10) not null check (status IN ('Pending', 'Completed')),"
                + "due_date date)";

        try (Statement statement = connection.createStatement();){
            statement.executeUpdate(createTableCommand);

            System.out.println("Table " + tableName + " created!");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void createLoginTable(Connection connection) {
      String createTableCommand = "CREATE TABLE IF NOT EXISTS " + loginTableName + " ("
              + "id int auto_increment primary key,"
              + "username varchar(255) unique,"
              + "password varchar(255))";

      try (Statement statement = connection.createStatement();){
          statement.executeUpdate(createTableCommand);

          System.out.println("Table " + loginTableName + " created!");
      } catch (SQLException e) {
          System.out.println(e);
      }

  }
}