package com.reimburse.hibernate.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "employee_request")
public class Employee_Request implements Serializable
{
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(generator = "employee_request_id_seq",strategy = GenerationType.AUTO) // auto incremented value
	@SequenceGenerator(allocationSize = 1, name = "employee_request_id_seq", sequenceName = "employee_request_id_seq")
	private int employee_request_id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "approved")
	private boolean approved;
		
	@Column(name = "file")
	private byte[] file;
	
	@Column(name ="link")
	private String link;
	
	@Column(name = "employee_id")
	private int employee_id;
		
		
	public Employee_Request() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee_Request(int employee_request_id, String description, boolean approved, byte[] file, String link,
			int employee_id) {
		super();
		this.employee_request_id = employee_request_id;
		this.description = description;
		this.approved = approved;
		this.file = file;
		this.link = link;
		this.employee_id = employee_id;
	}


	public int getEmployee_request_id() {
		return employee_request_id;
	}


	public void setEmployee_request_id(int employee_request_id) {
		this.employee_request_id = employee_request_id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isApproved() {
		return approved;
	}


	public void setApproved(boolean approved) {
		this.approved = approved;
	}


	public byte[] getFile() {
		return file;
	}


	public void setFile(byte[] file) {
		this.file = file;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + employee_id;
		result = prime * result + employee_request_id;
		result = prime * result + Arrays.hashCode(file);
		result = prime * result + ((link == null) ? 0 : link.hashCode());
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
		Employee_Request other = (Employee_Request) obj;
		if (approved != other.approved)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employee_id != other.employee_id)
			return false;
		if (employee_request_id != other.employee_request_id)
			return false;
		if (!Arrays.equals(file, other.file))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Employee_Request [employee_request_id=" + employee_request_id + ", description=" + description
				+ ", approved=" + approved + ", file=" + Arrays.toString(file) + ", link=" + link + ", employee_id="
				+ employee_id + "]";
	}
	
	
}
