package com.reimburse.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class EmployeeReviewRequestController
 */
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() 
    {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			ObjectMapper map = new ObjectMapper();
			PrintWriter writer = response.getWriter();
			response.setContentType("application/json");
			final String JSON = map.writeValueAsString(RequestHelper.processGet(request, response));
			writer.write(JSON);
		
				/*
				try {
					reviewCheck(request, response);
					
				} catch (Exception e) 
				{
				
					e.printStackTrace();
				}
				*/
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect("viewEmployeeRequests.html");
	}
	
	
	
	} // end class


