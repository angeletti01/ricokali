package com.reimburse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimburse.hibernate.dao.EmployeeDAO;

/**
 * Servlet implementation class EmployeeLoginController
 */
public class EmployeeLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDAO emplDAO;
	
	public void init() 
	{
		emplDAO = new EmployeeDAO();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginController() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.sendRedirect("employeeLogin.html");
	} // end method doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		try 
		{
			authenticate(request, response);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	} // end method doPost
	
	private void authenticate(HttpServletRequest request, HttpServletResponse response)
		    throws Exception {
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");

		        if (emplDAO.validate(username, password)) {
		        	System.out.println("Login Successful, redirecting to homepage.");
		            RequestDispatcher dispatcher = request.getRequestDispatcher("employeeHomepage.html");
		            dispatcher.forward(request, response);
		        } else {
		            throw new Exception("Login not successful..");
		        }
		    }

} // end class EmployeeLoginController
