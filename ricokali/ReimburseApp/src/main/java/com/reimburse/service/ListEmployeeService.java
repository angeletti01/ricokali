package com.reimburse.service;

import java.util.List;

import com.reimburse.hibernate.model.Employee;
import com.reimburse.repository.*;

public class ListEmployeeService 
{
	private ListEmployee le = new ListEmployeeDAOImpl();
	
	public List<Employee> getEmployee(int manager_id)
	{
	
	return this.le.getEmployee(manager_id);
	}
}
