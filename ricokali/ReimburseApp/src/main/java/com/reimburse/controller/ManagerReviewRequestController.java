package com.reimburse.controller;

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
import com.reimburse.hibernate.model.Employee_Request;
import com.reimburse.hibernate.model.Manager_Request;
import com.reimburse.hibernate.util.HibernateUtil;
/**
 * Servlet implementation class ManagerReviewRequestController
 */
public class ManagerReviewRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerReviewRequestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		try {
			reviewCheck(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("managerReviewRequest.html");		
	}
	
	public String reviewCheck(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		Manager_Request manreq = new Manager_Request();
		Transaction transaction = null;
		List hibobj = new ArrayList<>();
		
		Session s = null;
		String G = null;
		int manager_id = 0;
		try
		{
			// start transaction
			s = HibernateUtil.getSession();
			transaction = s.beginTransaction();
			//get a user object
			hibobj = s.createQuery("FROM Manager_Request MR WHERE MR.manager_id = :manager_id")
					.setParameter("manager_id", manager_id).getResultList();
			transaction.commit();
			System.out.println("Manager ID: "+ manager_id);
	// Converts list object from Hibernate query to GSON(JSON object)
			 Gson gson = new Gson();
		     // convert your list to json
		     String parseEmplReq = gson.toJson(hibobj);
		     // print your generated json
		     System.out.println("Manager Request: " + parseEmplReq);
		  	
		     /*
		     G = parseEmplReq;
		     manreq.setConvertedToGson(G); // set variable to converted GSON object. 
		     System.out.println("JSON Conversion: "+ G); */
		     
		     RequestDispatcher dispatcher = request.getRequestDispatcher("viewManagerRequests.html");
		        dispatcher.forward(request, response);
		    
		        return parseEmplReq;
			
			
		} // end try
			catch(HibernateException e) 
			{
				e.printStackTrace();
				transaction.rollback();
			} // end catch
		finally 
		{
			s.close();
		} // end finally
		
			return G;
		} // end reviewCheck
}
