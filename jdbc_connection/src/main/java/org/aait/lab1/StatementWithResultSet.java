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
        String[] insertStatements = {
            "insert into teachers(first_name, last_name, school, hire_date, salary) values('Aster', 'Nega', 'Yekatit 12', '2021-01-01', 8000)",
            "insert into teachers(first_name, last_name, school, hire_date, salary) values('Jemal', 'Edris', 'Bole', '2021-09-11', 20000)",
            "insert into teachers(first_name, last_name, school, hire_date, salary) values('Haile', 'Anaol', 'Saris', '2022-01-22', 15000)",
            "insert into teachers(first_name, last_name, school, hire_date, salary) values('Teddy', 'Anbesaw', 'Bole', '2021-01-01', 8000)",};

        try (Connection connection = DriverManager.getConnection(url, username, password); Statement statement = connection.createStatement()) {
            statement.executeUpdate(createDatabaseQuery);
            System.out.println("Database " + databaseName + " created!");
        } catch (SQLException e) {
            System.err.println(e);
        }

        try (Connection connection = DriverManager.getConnection(url + databaseName, username, password); Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableQuery);
            System.out.println("Table " + tableName + " created!");

            for (String stmt : insertStatements) {
                statement.executeUpdate(stmt);
            }
            System.out.println("Data Inserted Successfullly.");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
