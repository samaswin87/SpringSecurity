package com.spring.security.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.security.UserRoleRowMapper;
import com.spring.security.UserRowMapper;
import com.spring.security.model.User;
import com.spring.security.model.UserRole;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User getUser(String username) {
		User user = jdbcTemplate.queryForObject("select * from users where username = ?", new Object[] {username}, new UserRowMapper());
		List<UserRole> roles  = jdbcTemplate.query("select * from user_roles where username = ?", new UserRoleRowMapper(), username);
		user.setRoles(roles);
		return user;
	}

	public List<User> getAllUsers() {
		List<User> user = (List<User>) jdbcTemplate.query("select * from users", new UserRowMapper());
		return user;
	}

	public String addUser(User user) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		String[] columns = { "username", "password", "enabled" };
		simpleJdbcInsert.usingColumns(columns).withTableName("users");
		Map<String, Object> parameters = new HashMap<String, Object>(3);
		parameters.put("username", user.getUsername());
		parameters.put("password", user.getPassword());
		parameters.put("enabled", user.getEnabled());
		simpleJdbcInsert.execute(parameters);
		
		user.getRoles().forEach(role -> {
			addRole(role);
		});
		return user.getUsername();
	}

	public int updateUser(User user) {
		String sql = "update users set username = ?, password = ?, enabled = ? where username = ?";
		int resp = jdbcTemplate.update(sql,
				new Object[] { user.getUsername(), user.getPassword(), user.getEnabled(), user.getUsername() });
		return resp;
	}

	public int deleteUser(String username) {
		int resp = jdbcTemplate.update("delete from users where uesrname = ?", username);
		return resp;
	}
	
	private void addRole(UserRole role) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		String[] role_columns = { "username", "role" };
		simpleJdbcInsert.usingColumns(role_columns).withTableName("user_roles")
				.usingGeneratedKeyColumns("user_role_id");
		Map<String, Object> parameters = new HashMap<String, Object>(2);
		parameters.put("username", role.getUsername());
		parameters.put("role", role.getRole());
		simpleJdbcInsert.execute(parameters);
	}

}
