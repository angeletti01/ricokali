package com.reimburse.repository;

import java.util.List;

import com.reimburse.hibernate.model.Employee;

public interface ListEmployee 
{
	List<Employee>getEmployee(int manager_id);
}
