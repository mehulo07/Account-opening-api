
package com.bns.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_opening_auth_tab")
public class UserAuthDetail implements Serializable {

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 3325624044593059550L;

	@Column(name = "user_id", nullable = false)
	private String userId;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_name", nullable = false)
	private String userName;
    @Column(name = "password", nullable = false)
	private String password;
    @Column(name = "roles", nullable = false)
	private String roles;
    @Column(name = "active", nullable = false)
	private boolean active;
    
	public UserAuthDetail() {
		
	}

	public UserAuthDetail(String userId, String userName, String password, String roles, boolean active) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.active = active;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserAuthDetail [userId=" + userId + ", userName=" + userName + ", password=" + password + ", roles="
				+ roles + ", active=" + active + "]";
	}
	
}	
	
	
