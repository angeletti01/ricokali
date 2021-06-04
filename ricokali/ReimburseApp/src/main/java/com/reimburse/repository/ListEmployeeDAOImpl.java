package com.reimburse.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.reimburse.hibernate.model.Employee;
import com.reimburse.hibernate.util.HibernateUtil;

public class ListEmployeeDAOImpl implements ListEmployee 
{
	@Override
	public List<Employee> getEmployee(int manager_id) 
	{
		List<Employee> emp = new ArrayList<>();
		Session s = null;
		Transaction transaction = null;

		try 
		{
			s = HibernateUtil.getSession();
			transaction = s.beginTransaction();
			
			emp = s.createQuery("FROM Employee e WHERE e.manager_id = :manager_id", Employee.class)
					.setParameter("manager_id", manager_id).getResultList();
			
			System.out.println("List of Employees: " + emp);
			
			transaction.commit();

		} catch (HibernateException e) 
		{
			e.printStackTrace();
			transaction.rollback();
		} finally 
		{
			s.close();
		}
		System.out.println(emp);

		return emp;
	}
}
