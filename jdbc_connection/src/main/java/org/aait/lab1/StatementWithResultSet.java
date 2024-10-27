package org.aait.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementWithResultSet {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Remember2020!!!!!";
        String databaseName = "teachersdb";
        String tableName = "teachers";
        String createDatabaseQuery = "create database " + databaseName;
        String createTableQuery = "create table " + tableName + " ("
                + "id int auto_increment primary key,"
                + "first_name varchar(255),"
                + "last_name varchar(255),"
                + "school varchar(255),"
                + "hire_date date,"
                + "salary decimal(10, 2)"
                + ")";

        try (Connection connection = DriverManager.getConnection(url, username, password); Statement statement = connection.createStatement()) {
            statement.executeUpdate(createDatabaseQuery);
            System.out.println("Database " + databaseName + " created!");
        } catch (SQLException e) {
            System.err.println(e);
        }

        try (Connection connection = DriverManager.getConnection(url + databaseName, username, password); Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableQuery);
            System.out.println("Table " + tableName + " created!");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
