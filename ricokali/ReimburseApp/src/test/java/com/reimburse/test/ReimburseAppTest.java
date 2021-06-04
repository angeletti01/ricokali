package com.reimburse.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.reimburse.hibernate.dao.EmployeeDAO;
import com.reimburse.hibernate.model.Employee;
import com.reimburse.hibernate.model.Employee_Request;
import com.reimburse.hibernate.model.Manager_Request;
import com.reimburse.hibernate.util.HibernateUtil;
import com.reimburse.controller.*;

public class ReimburseAppTest {


	
	@Test
	public void test5_ReviewCheck() 
	{
		Employee emp = new Employee();
		Transaction transaction = null;
		List hibobj = new ArrayList<>();

		Session s = null;
		String G = null;
		int manager_id = 0;
		
		/* TESTING THAT THE VALUE OF VARIABLE MANAGER_ID IS INITIALIZED TO ZERO */
		assertEquals(0, manager_id);
		
		try {
			// start transaction
			s = HibernateUtil.getSession();
			transaction = s.beginTransaction();
			// get a user object
			hibobj = s.createQuery("FROM Manager_Request MR WHERE MR.manager_id = :manager_id")
					.setParameter("manager_id", manager_id).getResultList();
			transaction.commit();

			// Converts list object from Hibernate query to GSON(JSON object)
			Gson gson = new Gson();
			// convert your list to json
			String parseEmplReq = gson.toJson(hibobj);
			// print your generated json

			G = parseEmplReq;

		} // end try
		catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} // end catch
		finally {
			s.close();
		} // end finally
	} 

	@Test
	public void test6_ReviewCheck() 
	{
		Employee emp = new Employee();
		Transaction transaction = null;
		List hibobj = new ArrayList<>();

		Session s = null;
		String G = null;
		int manager_id = 0;
		
		/* TESTING THAT THE VALUE OF VARIABLE S IS INITIALIZED TO NULL */
		assertEquals(null, s);
		
		try {
			// start transaction
			s = HibernateUtil.getSession();
			transaction = s.beginTransaction();
			// get a user object
			hibobj = s.createQuery("FROM Manager_Request MR WHERE MR.manager_id = :manager_id")
					.setParameter("manager_id", manager_id).getResultList();
			transaction.commit();

			// Converts list object from Hibernate query to GSON(JSON object)
			Gson gson = new Gson();
			// convert your list to json
			String parseEmplReq = gson.toJson(hibobj);
			// print your generated json

			G = parseEmplReq;

				} // end try
		catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} // end catch
		finally {
			s.close();
		} // end finally

	} // end reviewCheck
	
	@Test
	public void test7_ReviewCheck() 
	{
		Employee emp = new Employee();
		Transaction transaction = null;
		List hibobj = new ArrayList<>();

		Session s = null;
		String G = null;
		int manager_id = 0;
		
		/* TESTING THAT THE VALUE OF VARIABLE TRANSACTION IS INITIALIZED TO NULL */
		assertEquals(null, transaction);
		
		try {
			// start transaction
			s = HibernateUtil.getSession();
			transaction = s.beginTransaction();
			// get a user object
			hibobj = s.createQuery("FROM Manager_Request MR WHERE MR.manager_id = :manager_id")
					.setParameter("manager_id", manager_id).getResultList();
			transaction.commit();

			// Converts list object from Hibernate query to GSON(JSON object)
			Gson gson = new Gson();
			// convert your list to json
			String parseEmplReq = gson.toJson(hibobj);
			// print your generated json

			G = parseEmplReq;			

		} // end try
		catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} // end catch
		finally {
			s.close();
		} // end finally

	} // end reviewCheck
	
	@Test
	public void test8_ReviewCheck() 
	{
		Employee emp = new Employee();
		Transaction transaction = null;
		List hibobj = new ArrayList<>();

		Session s = null;
		String G = null;
		int manager_id = 0;
		
				
		try {
			// start transaction
			s = HibernateUtil.getSession();
			
			/* TESTING THAT THE REFERENCE VARIABLE S IS REFERENCE TO HIBERNATEUTIL.GETSESSION */
			assertEquals(HibernateUtil.getSession(), s);
			
			transaction = s.beginTransaction();
			// get a user object
			hibobj = s.createQuery("FROM Manager_Request MR WHERE MR.manager_id = :manager_id")
					.setParameter("manager_id", manager_id).getResultList();
			transaction.commit();

			// Converts list object from Hibernate query to GSON(JSON object)
			Gson gson = new Gson();
			// convert your list to json
			String parseEmplReq = gson.toJson(hibobj);
			// print your generated json

			G = parseEmplReq;

						

		} // end try
		catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} // end catch
		finally {
			s.close();
		} // end finally

	} // end reviewCheck
	
	@Test
	public void test9_ReviewCheck() 
	{
		Employee emp = new Employee();
		Transaction transaction = null;
		List hibobj = new ArrayList<>();

		Session s = null;
		String G = null;
		int manager_id = 0;
		
				
		try {
			// start transaction
			s = HibernateUtil.getSession();
			
		
			
			transaction = s.beginTransaction();
			/* TESTING THAT THE METHOD S.BEGINTRANSACTION WAS PASSED ON SUCCESFULLY TO REFERENCE VARIABLE TRANSACTION */
			assertNotEquals(null, transaction);
			
			// get a user object
			hibobj = s.createQuery("FROM Manager_Request MR WHERE MR.manager_id = :manager_id")
					.setParameter("manager_id", manager_id).getResultList();
			transaction.commit();

			// Converts list object from Hibernate query to GSON(JSON object)
			Gson gson = new Gson();
			// convert your list to json
			String parseEmplReq = gson.toJson(hibobj);
			// print your generated json

			G = parseEmplReq;
		

		} // end try
		catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} // end catch
		finally {
			s.close();
		} // end finally

	} // end reviewCheck
	
	@Test
	public void test10_ReviewCheck() 
	{
		Employee emp = new Employee();
		Transaction transaction = null;
		List hibobj = new ArrayList<>();

		Session s = null;
		String G = null;
		int manager_id = 0;
		
				
		try {
			// start transaction
			s = HibernateUtil.getSession();
			
		
			
			transaction = s.beginTransaction();			
			
			// get a user object
			hibobj = s.createQuery("FROM Manager_Request MR WHERE MR.manager_id = :manager_id")
					.setParameter("manager_id", manager_id).getResultList();
			transaction.commit();
			
			/* TESTING THAT THE VARIABLE HIBOBJ IS NOT NULL*/
			assertNotEquals(null, hibobj);

			// Converts list object from Hibernate query to GSON(JSON object)
			Gson gson = new Gson();
			// convert your list to json
			String parseEmplReq = gson.toJson(hibobj);
			// print your generated json

			G = parseEmplReq;			

		} // end try
		catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} // end catch
		finally {
			s.close();
		} // end finally

	} // end reviewCheck
	
	

} // end test class
