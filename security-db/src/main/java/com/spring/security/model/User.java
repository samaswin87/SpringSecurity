package com.spring.security.model;

import java.util.List;

public class User {

	private String username;
	private String password;
	private Boolean enabled;
	List<UserRole> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getEnabledValue() {
		return enabled ? "Enabled" : "Disabled";
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "[ Username: " + username + ", Password: " + password + ", Enabled: " + enabled + " ]";
	}
}
