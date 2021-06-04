package com.reimburse.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "manager_supervisor")
public class Manager_Supervisor implements Serializable
{
private static final long serialVersionUID = 1L;
	
@Id
@GeneratedValue(generator = "manager_supervisor_id_seq",strategy = GenerationType.AUTO) // auto incremented value
@SequenceGenerator(allocationSize = 1, name = "manager_supervisor_id_seq", sequenceName = "manager_supervisor_id_seq")
private int manager_supervisor_id;

@Column(name = "manager_supervisor_firstname")
private String manager_supervisorFirstName;

@Column(name = "manager_supervisor_lastname")
private String manager_supervisorLastName;

@Column(name = "username")
private String username;

@Column(name = "password")
private String password;

@Column(name = "manager_id")
private int manager_id;

public Manager_Supervisor() {
	super();
	// TODO Auto-generated constructor stub
}


public Manager_Supervisor(int manager_supervisor_id, String manager_supervisorFirstName,
		String manager_supervisorLastName, String username, String password, int manager_id)
{
	super();
	this.manager_supervisor_id = manager_supervisor_id;
	this.manager_supervisorFirstName = manager_supervisorFirstName;
	this.manager_supervisorLastName = manager_supervisorLastName;
	this.username = username;
	this.password = password;
	this.manager_id = manager_id;
}

public int getManager_supervisor_id() {
	return manager_supervisor_id;
}

public void setManager_supervisor_id(int manager_supervisor_id) {
	this.manager_supervisor_id = manager_supervisor_id;
}

public String getManager_supervisorFirstName() {
	return manager_supervisorFirstName;
}

public void setManager_supervisorFirstName(String manager_supervisorFirstName) {
	this.manager_supervisorFirstName = manager_supervisorFirstName;
}

public String getManager_supervisorLastName() {
	return manager_supervisorLastName;
}

public void setManager_supervisorLastName(String manager_supervisorLastName) {
	this.manager_supervisorLastName = manager_supervisorLastName;
}

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

public int getManager_id() {
	return manager_id;
}

public void setManager_id(int manager_id) {
	this.manager_id = manager_id;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + manager_id;
	result = prime * result + ((manager_supervisorFirstName == null) ? 0 : manager_supervisorFirstName.hashCode());
	result = prime * result + ((manager_supervisorLastName == null) ? 0 : manager_supervisorLastName.hashCode());
	result = prime * result + manager_supervisor_id;
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Manager_Supervisor other = (Manager_Supervisor) obj;
	if (manager_id != other.manager_id)
		return false;
	if (manager_supervisorFirstName == null) {
		if (other.manager_supervisorFirstName != null)
			return false;
	} else if (!manager_supervisorFirstName.equals(other.manager_supervisorFirstName))
		return false;
	if (manager_supervisorLastName == null) {
		if (other.manager_supervisorLastName != null)
			return false;
	} else if (!manager_supervisorLastName.equals(other.manager_supervisorLastName))
		return false;
	if (manager_supervisor_id != other.manager_supervisor_id)
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}

@Override
public String toString() {
	return "Manager_Supervisor [manager_supervisor_id=" + manager_supervisor_id + ", manager_supervisorFirstName="
			+ manager_supervisorFirstName + ", manager_supervisorLastName=" + manager_supervisorLastName + ", username="
			+ username + ", password=" + password + ", manager_id=" + manager_id + "]";
}

} // end persistent class Manager_Supervisor
