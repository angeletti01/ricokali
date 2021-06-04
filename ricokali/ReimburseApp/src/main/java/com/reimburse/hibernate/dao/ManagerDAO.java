package com.reimburse.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.reimburse.hibernate.model.*;
import com.reimburse.hibernate.util.*;

public class ManagerDAO 
{
	public void saveManager(Manager man) 
	{
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSession())
		{
			// start a transaction
			transaction = session.beginTransaction();
			
			// save the object
			session.save(man);
			
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
	} // end saveEmployee method
	
	public boolean validate(String userName, String password) 
	{
		Transaction transaction = null;
		Manager man = null;
		
		try (Session session = HibernateUtil.getSession())
		{
			//start a transaction
			transaction = session.beginTransaction();
			
			// get a object
			man = (Manager) session.createQuery("FROM Manager M WHERE M.username = :userName")
					.setParameter("userName", userName).uniqueResult();
			
			if(man != null && man.getPassword().equals(password)) 
			{
				return true;
			}
			//commit transaction
			transaction.commit();			
		}
		catch(Exception e) 
		{
			if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
		}
		return false;
	}
}
