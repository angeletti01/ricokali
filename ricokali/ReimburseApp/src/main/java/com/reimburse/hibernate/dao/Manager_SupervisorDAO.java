package com.reimburse.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.reimburse.hibernate.model.Manager_Supervisor;
import com.reimburse.hibernate.util.HibernateUtil;

public class Manager_SupervisorDAO 
{
	public void saveManager_Supervisor(Manager_Supervisor manSup) 
	{
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSession())
		{
			// start a transaction
			transaction = session.beginTransaction();
			
			// save the object
			session.save(manSup);
			
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
	} // end saveManagaer_Supervisor method
	
	 public boolean validate(String userName, String password) {

	        Transaction transaction = null;
	        Manager_Supervisor manSup = null;
	        try (Session session = HibernateUtil.getSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            manSup = (Manager_Supervisor) session.createQuery("FROM Manager_Supervisor MS WHERE MS.username = :userName").setParameter("userName", userName)
	                .uniqueResult();

	            if (manSup != null && manSup.getPassword().equals(password)) {
	                return true;
	            }
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return false;
	    }
}
