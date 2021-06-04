package com.reimburse;

import java.util.List;

import com.reimburse.hibernate.model.Employee_Request;
import com.reimburse.hibernate.util.HibernateUtil;
import com.reimburse.repository.EmployeeReview;
import com.reimburse.repository.EmployeeReviewDAOImpl;
import com.reimburse.service.EmployeeReviewService;

public class Driver {


	public static void main(String[] args) 
	{
		/*EmployeeReview employeeReview = new EmployeeReviewDAOImpl();
		
		employeeReview.getReview(); */
		
		HibernateUtil.getSession();
		System.out.println("Session retrieved");
		
		

	}
	

}
