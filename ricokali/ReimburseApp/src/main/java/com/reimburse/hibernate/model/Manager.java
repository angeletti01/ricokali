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
@Table(name = "manager")
public class Manager implements Serializable
{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "manager_id_seq",strategy = GenerationType.AUTO) // auto incremented value
    @SequenceGenerator(allocationSize = 1, name = "manager_id_seq", sequenceName = "manager_id_seq")
	private int manager_id;
	
	@Column(name = "manager_firstname")
	private String managerFirstName;
	
	@Column(name = "manager_lastname")
	private String managerLastName;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "employee_id")
	private int employee_id;
	
	@Column(name = "manager_supervisor_id")
	private int manager_supervisor_id;
	
	@Column(name = "gson")
	private String convertedToGson;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int manager_id, String managerFirstName, String managerLastName, String username, String password,
			int employee_id, int manager_supervisor_id, String convertedToGson) {
		super();
		this.manager_id = manager_id;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.username = username;
		this.password = password;
		this.employee_id = employee_id;
		this.manager_supervisor_id = manager_supervisor_id;
		this.convertedToGson = convertedToGson;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
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

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getManager_supervisor_id() {
		return manager_supervisor_id;
	}

	public void setManager_supervisor_id(int manager_supervisor_id) {
		this.manager_supervisor_id = manager_supervisor_id;
	}

	public String getConvertedToGson() {
		return convertedToGson;
	}

	public void setConvertedToGson(String convertedToGson) {
		this.convertedToGson = convertedToGson;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((convertedToGson == null) ? 0 : convertedToGson.hashCode());
		result = prime * result + employee_id;
		result = prime * result + ((managerFirstName == null) ? 0 : managerFirstName.hashCode());
		result = prime * result + ((managerLastName == null) ? 0 : managerLastName.hashCode());
		result = prime * result + manager_id;
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
		Manager other = (Manager) obj;
		if (convertedToGson == null) {
			if (other.convertedToGson != null)
				return false;
		} else if (!convertedToGson.equals(other.convertedToGson))
			return false;
		if (employee_id != other.employee_id)
			return false;
		if (managerFirstName == null) {
			if (other.managerFirstName != null)
				return false;
		} else if (!managerFirstName.equals(other.managerFirstName))
			return false;
		if (managerLastName == null) {
			if (other.managerLastName != null)
				return false;
		} else if (!managerLastName.equals(other.managerLastName))
			return false;
		if (manager_id != other.manager_id)
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
		return "Manager [manager_id=" + manager_id + ", managerFirstName=" + managerFirstName + ", managerLastName="
				+ managerLastName + ", username=" + username + ", password=" + password + ", employee_id=" + employee_id
				+ ", manager_supervisor_id=" + manager_supervisor_id + ", convertedToGson=" + convertedToGson + "]";
	}

	
	



	
	
}
