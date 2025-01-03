package com.labexam.util;

import com.labexam.model.User;
import com.labexam.repository.UserRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {

  @Autowired private DBConnectionManager manager;

  @Override
  public User findByUsername(String username) throws SQLException {
    String query = "SELECT * FROM login WHERE username = ?";
    User user = null;

    try (Connection con = manager.openConnection();
        PreparedStatement ps = con.prepareStatement(query);) {
      ps.setString(1, username);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          user = new User();
          user.setId(rs.getInt("id"));
          user.setUsername(rs.getString("username"));
          user.setPassword(rs.getString("password"));
        }
      }
    }
    return user;
  }

  @Override
  public void save(User user) throws SQLException {
    String query = "INSERT INTO login (username, password) VALUES (?,?)";

    try (Connection con = manager.openConnection();
        PreparedStatement ps = con.prepareStatement(query);) {
      ps.setString(1, user.getUsername());
      ps.setString(2, user.getPassword());
      ps.executeUpdate();
    }
  }
}
