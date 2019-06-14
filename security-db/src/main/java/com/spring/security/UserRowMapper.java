package com.spring.security;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.security.model.User;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int row) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEnabled(rs.getBoolean("enabled"));
		return user;
	}

}
