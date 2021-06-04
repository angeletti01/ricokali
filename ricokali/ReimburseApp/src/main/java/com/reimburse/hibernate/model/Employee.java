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
@Table(name = "employee")
public class Employee implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "employee_id_seq", strategy = GenerationType.AUTO) // auto incremented value
    @SequenceGenerator(allocationSize = 1, name = "employee_id_seq", sequenceName = "employee_id_seq")
	private int employee_id;
	
	@Column(name = "employee_firstname")
	private String employeeFirstName;
	
	@Column(name = "employee_lastname")
	private String employeeLastName;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "manager_id")
	private int manager_id;
	
	
		
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(int employee_id, String employeeFirstName, String employeeLastName, String username,
			String password, int manager_id) {
		super();
		this.employee_id = employee_id;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.username = username;
		this.password = password;
		this.manager_id = manager_id;
	}



	public int getEmployee_id() {
		return employee_id;
	}



	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}



	public String getEmployeeFirstName() {
		return employeeFirstName;
	}



	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}



	public String getEmployeeLastName() {
		return employeeLastName;
	}



	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
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
		result = prime * result + ((employeeFirstName == null) ? 0 : employeeFirstName.hashCode());
		result = prime * result + ((employeeLastName == null) ? 0 : employeeLastName.hashCode());
		result = prime * result + employee_id;
		result = prime * result + manager_id;
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
		Employee other = (Employee) obj;
		if (employeeFirstName == null) {
			if (other.employeeFirstName != null)
				return false;
		} else if (!employeeFirstName.equals(other.employeeFirstName))
			return false;
		if (employeeLastName == null) {
			if (other.employeeLastName != null)
				return false;
		} else if (!employeeLastName.equals(other.employeeLastName))
			return false;
		if (employee_id != other.employee_id)
			return false;
		if (manager_id != other.manager_id)
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
		return "Employee [employee_id=" + employee_id + ", employeeFirstName=" + employeeFirstName
				+ ", employeeLastName=" + employeeLastName + ", username=" + username + ", password=" + password
				+ ", manager_id=" + manager_id + "]";
	}
		
	} // end class

	
	
	

	
	
	

