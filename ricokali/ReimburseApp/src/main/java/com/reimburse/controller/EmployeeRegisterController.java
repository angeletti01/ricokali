package com.reimburse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimburse.hibernate.dao.EmployeeDAO;
import com.reimburse.hibernate.model.Employee;


/**
 * Servlet implementation class EmployeeRegisterController
 */
public class EmployeeRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private EmployeeDAO emplDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() 
	{
		emplDAO = new EmployeeDAO();
	}
	
    public EmployeeRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("employeeRegistration.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		register(request, response);
	}
	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");	        
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String manager_id = request.getParameter("manager_id");
        
        int i = Integer.parseInt(manager_id); // converts the string value in webpage to int.

        Employee empl = new Employee();
        
        empl.setEmployeeFirstName(firstName);
        System.out.println(firstName);
        empl.setEmployeeLastName(lastName);
        System.out.println(lastName);
        empl.setUsername(username);
        System.out.println(username);
        empl.setPassword(password);
        System.out.println(password);
        empl.setManager_id(i);
        

        emplDAO.saveEmployee(empl);

        RequestDispatcher dispatcher = request.getRequestDispatcher("employeeLogin.html");
        dispatcher.forward(request, response);
    }
} // end class EmployeeRegisterController
