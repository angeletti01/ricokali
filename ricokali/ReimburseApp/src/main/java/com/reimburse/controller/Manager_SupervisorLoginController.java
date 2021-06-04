package com.reimburse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimburse.hibernate.dao.Manager_SupervisorDAO;

/**
 * Servlet implementation class Manager_SupervisorLoginController
 */
public class Manager_SupervisorLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Manager_SupervisorDAO manSupDAO;
	
	public void init() 
	{
		manSupDAO = new Manager_SupervisorDAO();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager_SupervisorLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("managerSupervisorLogin.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try 
		{
			authenticate(request, response);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	private void authenticate(HttpServletRequest request, HttpServletResponse response)
		    throws Exception {
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");

		        if (manSupDAO.validate(username, password)) {
		        	System.out.println("Login Successful, redirecting to homepage.");
		            RequestDispatcher dispatcher = request.getRequestDispatcher("managerSupervisorHomepage.html");
		            dispatcher.forward(request, response);
		        } else {
		        
		            throw new Exception("Login not successful..");
		            
		        }
		    }

} // end class Manager_SupervisorLoginController
