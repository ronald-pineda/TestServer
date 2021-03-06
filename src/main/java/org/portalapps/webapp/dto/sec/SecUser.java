package org.portalapps.webapp.dto.sec;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "SEC_USER", catalog = "SEC")
public class SecUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "USER_ID", unique = true, nullable = false, length = 100)
	private String userId;
	@Column(name = "PASSWORD", unique = false, nullable = false, length = 100)
	private String password;
	@Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
	private String firstName;
	@Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
	private String lastName;
	@Column(name = "EMAIL", unique = false, nullable = false, length = 100)
	private String email;
	@Column(name = "STATE_ID", unique = false, nullable = false, length = 100)
	private String stateId;	
	


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "SEC_USER_ROLE", 
	joinColumns = { @JoinColumn(name = "USER_ID") }, 
	inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	private List<SecRole> userRoleList = new ArrayList<SecRole>();	


	public SecUser() {
	}
	public SecUser(String userId, String password, String firstName) {
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public List<SecRole> getUserRoleList() {
		return userRoleList;
	}
	public void setUserRoleList(List<SecRole> userRoleList) {
		this.userRoleList = userRoleList;
	}
	public String toString(){
		return "SEC_USER[userId=" + userId + ", firstName=" + firstName  + "]";
	}


}
