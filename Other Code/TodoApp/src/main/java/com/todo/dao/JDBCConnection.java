package com.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component()
public class JDBCConnection {
	private String databaseName = "TodoDB";
	private String tableName = "tasks";
	private String url = "jdbc:mysql://localhost:3306/" + databaseName;
	private String username = "root";
	private String password = "Password1234!@#$";

	public Connection openConnection() throws SQLException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return conn;
	}

	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
