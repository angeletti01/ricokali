package com.reimburse.repository;

import java.util.List;


import com.reimburse.hibernate.model.*;

public interface EmployeeReview 
{
	List<Employee_Request> getReview(int employee_id);
	
}
