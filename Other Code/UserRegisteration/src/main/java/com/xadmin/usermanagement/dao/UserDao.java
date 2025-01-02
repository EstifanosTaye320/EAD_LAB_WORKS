package com.xadmin.usermanagement.dao;

public class UserDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Password1234!@#$";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
}
