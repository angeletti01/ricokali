package com.reimburse.service;


import java.util.List;

import com.reimburse.hibernate.model.Employee_Request;
import com.reimburse.repository.*;

public class EmployeeReviewService 
{
	private EmployeeReview employeeReview = new EmployeeReviewDAOImpl();
	
	public List<Employee_Request> getReview(int employee_id) 
	{
		return this.employeeReview.getReview(employee_id);
		
	}

}
