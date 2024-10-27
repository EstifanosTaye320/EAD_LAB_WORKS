package org.aait.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDatabaseOperations {

    private static final String SELECTQUERY = "select * from students limit 5";
    private static final String AVGQUERY = "select avg(grade) as avarage_grade from students";

    private static class Student {

        String first_name;
        String last_name;
        int grade;

        private Student(String first_name, String last_name, int grade) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.grade = grade;
        }
    }

    private static final Student[] students = new Student[]{
        new Student("Jhon", "Doe", 90),
        new Student("Estifanos", "Taye", 75),
        new Student("Duff", "Beer", 80),
        new Student("Homer", "Simpson", 81),
        new Student("Other", "Name", 77),
        new Student("Jack", "Gaint", 93),
        new Student("Souron", "Rings", 100),
        new Student("Jhon", "Wick", 87),
        new Student("Silina", "Vampire", 74),
        new Student("Merlin", "Wizard", 70),
        new Student("Jockstar", "Smith", 80),};

    private static void insertSampleData(Connection connection) {
        try (PreparedStatement insertSingle = connection.prepareStatement("insert into students (first_name, last_name, grade) values( ?,  ?,  ?)")) {
            for (Student student : students) {
                insertSingle.setString(1, student.first_name);
                insertSingle.setString(2, student.last_name);
                insertSingle.setInt(3, student.grade);
                insertSingle.executeUpdate();
            }

            System.out.println("Students successfully inserted!\n");

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void retiveData(Connection connection) {
        try (Statement statement = connection.createStatement(); ResultSet resultset = statement.executeQuery(SELECTQUERY)) {
            while (resultset.next()) {
                int id = resultset.getInt("id");
                String first_name = resultset.getString("first_name");
                String last_name = resultset.getString("last_name");
                int grade = resultset.getInt("grade");

                System.out.printf("The student with id %d is named: %s %s and scored: %d\n", id, first_name, last_name, grade);
                System.out.println("..............");
            }

            System.out.println();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void updateNameById(Connection connection, int i, String newName) {
        try (PreparedStatement updateStatement = connection.prepareStatement("update students set first_name = ? where id =?")) {
            updateStatement.setString(1, newName);
            updateStatement.setInt(2, i);
            updateStatement.executeUpdate();

            System.out.printf("First name of student with id %d has been updated to %s\n\n", i, newName);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void deleteStudent(Connection connection, int i) {
        try (Statement statement = connection.createStatement()) {
            String deleteQuery = "delete from students where id = " + i;
            statement.executeUpdate(deleteQuery);

            System.out.printf("Student with id %d has successfully been deleted\n\n", i);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void calculateAverageGrade(Connection connection) {
        try (Statement statement = connection.createStatement(); ResultSet resultset = statement.executeQuery(AVGQUERY)) {
            resultset.next();
            double result = resultset.getDouble("avarage_grade");
            System.out.println("Average = " + result);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "my_password";
        String databaseName = "studentdb";
        String tableName = "students";
        String createDatabaseQuery = "create database if not exists " + databaseName;
        String createTableQuery = "create table if not exists " + tableName + " ("
                + "id int auto_increment primary key,"
                + "first_name varchar(255),"
                + "last_name varchar(255),"
                + "grade int"
                + ")";

        try (Connection connection = DriverManager.getConnection(url, username, password); Statement statement = connection.createStatement()) {
            statement.executeUpdate(createDatabaseQuery);
            System.out.println("StudentDB database created!\n");
        } catch (SQLException e) {
            System.err.println(e);
        }

        try (Connection connection = DriverManager.getConnection(url + databaseName, username, password); Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableQuery);
            System.out.println("Student table created!\n");

            insertSampleData(connection);
            retiveData(connection);
            updateNameById(connection, 3, "Teddy");
            deleteStudent(connection, 3);
            calculateAverageGrade(connection);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
