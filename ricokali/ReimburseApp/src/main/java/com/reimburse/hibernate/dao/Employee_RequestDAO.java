package com.reimburse.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.reimburse.hibernate.util.HibernateUtil;
import com.reimburse.hibernate.model.Employee_Request;

public class Employee_RequestDAO 
{
	public void saveEmployee_Request(Employee_Request emplReq) 
	{
Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSession())
		{
			// start a transaction
			transaction = session.beginTransaction();
			
			// save the object
			session.save(emplReq);
			
			// commit transaction
			transaction.commit();			
		} // end try
		catch(Exception e)
		{
			if (transaction != null) 
			{
				transaction.rollback();
			}
			e.printStackTrace();
		} // end catch		
	}
}
