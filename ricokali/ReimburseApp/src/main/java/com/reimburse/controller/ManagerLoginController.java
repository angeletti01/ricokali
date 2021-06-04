package com.reimburse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimburse.hibernate.dao.ManagerDAO;

/**
 * Servlet implementation class ManagerLoginController
 */
public class ManagerLoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	private ManagerDAO manDAO;
	
	public void init() 
	{
		manDAO = new ManagerDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("managerLogin.html");
		
	} // end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
	} // end doPost

	private void authenticate(HttpServletRequest request, HttpServletResponse response)
		    throws Exception {
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");

		        if (manDAO.validate(username, password)) {
		        	System.out.println("Login Successful, redirecting to homepage.");
		            RequestDispatcher dispatcher = request.getRequestDispatcher("managerHomepage.html");
		            dispatcher.forward(request, response);
		        } else {
		            throw new Exception("Login not successful..");
		        }
		    }
} // end class MangerLoginController
