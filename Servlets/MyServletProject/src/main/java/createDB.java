import java.sql.*;
public class createDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Remember2020!!!!!"); Statement statement = conn.createStatement()) {
//			statement.executeUpdate("create database book");
//		} catch(Exception e) {
//			System.err.println(e);
//		}
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "Remember2020!!!!!"); Statement statement = conn.createStatement()) {
			statement.executeUpdate("CREATE TABLE bookdata ("
					+ "    id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "    bookName VARCHAR(255),"
					+ "    bookEdition VARCHAR(255),"
					+ "    bookPrice FLOAT"
					+ ");");
//			statement.executeUpdate("drop table bookdata");
		} catch(Exception e) {
			System.err.println(e);
		}
	}

}
