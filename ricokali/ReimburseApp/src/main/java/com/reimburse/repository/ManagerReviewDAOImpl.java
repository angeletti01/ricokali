package com.reimburse.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.reimburse.hibernate.model.Manager_Request;
import com.reimburse.hibernate.util.HibernateUtil;


public class ManagerReviewDAOImpl implements ManagerReview	
{

	@Override
public List<Manager_Request> getReview(int manager_id)
{
	List<Manager_Request> manReview = new ArrayList<>();
	Session s = null;
	Transaction transaction = null;
	
	try 
	{
		s = HibernateUtil.getSession();
		transaction = s.beginTransaction();
		
		//get a user object
		manReview = s.createQuery("FROM Manager_Request MR WHERE MR.manager_id = :manager_id", Manager_Request.class)
				.setParameter("manager_id", manager_id).getResultList();
		
		System.out.println("manReview: " + manReview);
		
		transaction.commit();
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
	
	System.out.println(manReview);	
	return null;
}

} // class 
