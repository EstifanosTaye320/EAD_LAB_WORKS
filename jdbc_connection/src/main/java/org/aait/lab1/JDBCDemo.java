package org.aait.lab1;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo {

    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/church_db";
        String username = "root";
        String password = "my_password";

        try (Connection conn = DriverManager.getConnection(url, username, password);) {
            Class.forName(driver);

            System.out.println("Established Connection");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
