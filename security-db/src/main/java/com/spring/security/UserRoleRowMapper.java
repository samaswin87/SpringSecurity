package com.spring.security;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.security.model.UserRole;

public class UserRoleRowMapper implements RowMapper<UserRole> {

	public UserRole mapRow(ResultSet rs, int row) throws SQLException {
		UserRole userRole = new UserRole();
		userRole.setUsername(rs.getString("username"));
		userRole.setRole(rs.getString("role"));
		userRole.setUserRoleId(rs.getInt("user_role_id"));
		return userRole;
	}

}
