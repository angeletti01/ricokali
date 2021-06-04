package com.reimburse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimburse.hibernate.dao.Manager_SupervisorDAO;
import com.reimburse.hibernate.model.Manager_Supervisor;

/**
 * Servlet implementation class Manager_SupervisorRegisterController
 */
public class Manager_SupervisorRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Manager_SupervisorDAO manSupDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init() {
	manSupDAO = new Manager_SupervisorDAO();
	}
	
    public Manager_SupervisorRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("managerSupervisorRegister.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		register(request, response);
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");	        
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String manager_id = request.getParameter("manager_id");
        
        int i = Integer.parseInt(manager_id); // converts the string value in webpage to int.

        Manager_Supervisor manSup = new Manager_Supervisor();
        
        manSup.setManager_supervisorFirstName(firstName);
        System.out.println(firstName);
        manSup.setManager_supervisorLastName(lastName);
        System.out.println(lastName);
        manSup.setUsername(username);
        System.out.println(username);
        manSup.setPassword(password);
        System.out.println(password);
        manSup.setManager_id(i);
        

        manSupDAO.saveManager_Supervisor(manSup);

        RequestDispatcher dispatcher = request.getRequestDispatcher("managerSupervisorLogin.html");
        dispatcher.forward(request, response);
    }
} // end class
