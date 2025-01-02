package com.labexam.repository;

import com.labexam.model.User;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository {
    User findByUsername(String username) throws SQLException;
    void save(User user) throws SQLException;
}
