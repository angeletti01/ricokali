package com.reimburse.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.reimburse.hibernate.model.Employee;
import com.reimburse.hibernate.util.HibernateUtil;



public class EmployeeDAO 
{
	public void saveEmployee(Employee empl) 
	{
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSession())
		{
			// start a transaction
			transaction = session.beginTransaction();
			
			// save the object
			session.save(empl);
			
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
	
	 public boolean validate(String userName, String password) {

	        Transaction transaction = null;
	        Employee empl = null;
	        try (Session session = HibernateUtil.getSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            empl = (Employee) session.createQuery("FROM Employee E WHERE E.username = :userName").setParameter("userName", userName)
	                .uniqueResult();

	            if (empl != null && empl.getPassword().equals(password)) {
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
	
} // and class EmployeeDAO
