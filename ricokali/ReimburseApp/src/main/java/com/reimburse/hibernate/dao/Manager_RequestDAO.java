package com.reimburse.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.reimburse.hibernate.model.Manager_Request;
import com.reimburse.hibernate.util.HibernateUtil;

public class Manager_RequestDAO 
{
public void SaveManager_RequestDAO(Manager_Request man_req) 
{
	Transaction transaction = null;
	
	try(Session session = HibernateUtil.getSession())
	{
		// start a transaction
		transaction = session.beginTransaction();
		
		// save the object
		session.save(man_req);
		
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
	
} // end class
