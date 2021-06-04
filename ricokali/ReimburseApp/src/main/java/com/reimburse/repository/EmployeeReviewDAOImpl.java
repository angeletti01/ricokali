package com.reimburse.repository;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.reimburse.hibernate.model.Employee_Request;
import com.reimburse.hibernate.util.HibernateUtil;

public class EmployeeReviewDAOImpl implements EmployeeReview
{
	
	@Override
	public List<Employee_Request> getReview(int employee_id)
	{
		
		List<Employee_Request> emplReview = new ArrayList<>();
		Session s = null;
		Transaction transaction = null;
		
		//Employee_Request emplReq = null;
	//	EmployeeReviewRequestController errc = new EmployeeReviewRequestController();
		
		
		try
		{
			// start transaction
			s = HibernateUtil.getSession();
			transaction = s.beginTransaction();
		
			//get a user object
			emplReview = s.createQuery("FROM Employee_Request ER WHERE ER.employee_id = :employee_id", Employee_Request.class).setParameter("employee_id", employee_id)
					.getResultList();
			
			System.out.print("emplReview: " + emplReview);
			
			transaction.commit();
			
			
			//int i = Integer.parseInt(employee_id); // convert string to int			
		}
			catch(HibernateException e) 
			{
				e.printStackTrace();
				transaction.rollback();
			}
		finally 
		{
			s.close();
		}	
		
		/*List<Employee_Request> er = new ArrayList<>();
		
		// Creating JSONObject object
		JSONObject jsonObject = new JSONObject();
		
		JSONArray array = new JSONArray();
		
		while(er != null) 
		{
			JSONObject record = new JSONObject();
			// Inserting key-value pairs into the json object
			record.put("employee_request_id", emplReq.getEmployee_request_id());
			record.put("description", emplReq.getDescription());
			record.put("link", emplReq.getLink());
			record.put("approved", emplReq.isApproved());
			record.put("denied", emplReq.isDenied());
			array.add(record);
		}
		jsonObject.put("request_review", array);
		
		try {
			FileWriter file = new FileWriter("C:\\Eclipse\\workspace\\ReimburseApp\\filepath");
			file.write(jsonObject.toJSONString());
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		} */
		
		System.out.println(emplReview);
		return emplReview;
	}

	
	
}
