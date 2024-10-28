package org.aait.lab1;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/church_db";
        String username = "root";
        String password = "my_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection Established");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
