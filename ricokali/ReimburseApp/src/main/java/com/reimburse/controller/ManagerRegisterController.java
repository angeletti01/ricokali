package com.reimburse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimburse.hibernate.dao.ManagerDAO;
import com.reimburse.hibernate.model.Manager;

/**
 * Servlet implementation class ManagerRegisterController
 */
public class ManagerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ManagerDAO manDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init() 
	{
		manDAO = new ManagerDAO();
	}
	
    public ManagerRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("managerRegistration.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		register(request, response);
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");	        
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String manager_supervisor_id = request.getParameter("manager_supervisor_id");
        
        int i = Integer.parseInt(manager_supervisor_id); // converts the string value in webpage to int.

        Manager man = new Manager();
        
        man.setManagerFirstName(firstName);
        System.out.println(firstName);
        man.setManagerLastName(lastName);
        System.out.println(lastName);
        man.setUsername(username);
        System.out.println(username);
        man.setPassword(password);
        System.out.println(password);
        man.setManager_supervisor_id(i);
        

        manDAO.saveManager(man);

        RequestDispatcher dispatcher = request.getRequestDispatcher("managerLogin.html");
        dispatcher.forward(request, response);
    }

}
