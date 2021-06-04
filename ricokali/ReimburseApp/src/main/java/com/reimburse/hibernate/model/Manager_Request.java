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
@Table(name = "manager_request")
public class Manager_Request implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "manager_request_id_seq",strategy = GenerationType.AUTO) // auto incremented value
    @SequenceGenerator(allocationSize = 1, name = "manager_request_id_seq", sequenceName = "manager_request_id_seq")
	private int manager_request_id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "approved")
	private boolean approved;
	
	@Column(name = "denied")
	private boolean denied;
	
	@Column(name = "file")
	private byte[] file;
	
	@Column(name = "manager_id")
	private int manager_id;
	
	@Column(name = "link")
	private String link;
	
	@Column(name = "manager_supervisor_id")
	private String manager_supervisor_id;
		
	public Manager_Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager_Request(int manager_request_id, String description, boolean approved, boolean denied, byte[] file,
			int manager_id, String link, String manager_supervisor_id) {
		super();
		this.manager_request_id = manager_request_id;
		this.description = description;
		this.approved = approved;
		this.denied = denied;
		this.file = file;
		this.manager_id = manager_id;
		this.link = link;
		this.manager_supervisor_id = manager_supervisor_id;
	}

	public int getManager_request_id() {
		return manager_request_id;
	}

	public void setManager_request_id(int manager_request_id) {
		this.manager_request_id = manager_request_id;
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

	public boolean isDenied() {
		return denied;
	}

	public void setDenied(boolean denied) {
		this.denied = denied;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getManager_supervisor_id() {
		return manager_supervisor_id;
	}

	public void setManager_supervisor_id(String manager_supervisor_id) {
		this.manager_supervisor_id = manager_supervisor_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + (denied ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + Arrays.hashCode(file);
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + manager_id;
		result = prime * result + manager_request_id;
		result = prime * result + ((manager_supervisor_id == null) ? 0 : manager_supervisor_id.hashCode());
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
		Manager_Request other = (Manager_Request) obj;
		if (approved != other.approved)
			return false;
		if (denied != other.denied)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (!Arrays.equals(file, other.file))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (manager_id != other.manager_id)
			return false;
		if (manager_request_id != other.manager_request_id)
			return false;
		if (manager_supervisor_id == null) {
			if (other.manager_supervisor_id != null)
				return false;
		} else if (!manager_supervisor_id.equals(other.manager_supervisor_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manager_Request [manager_request_id=" + manager_request_id + ", description=" + description
				+ ", approved=" + approved + ", denied=" + denied + ", file=" + Arrays.toString(file) + ", manager_id="
				+ manager_id + ", link=" + link + ", manager_supervisor_id=" + manager_supervisor_id + "]";
	}
			
}
