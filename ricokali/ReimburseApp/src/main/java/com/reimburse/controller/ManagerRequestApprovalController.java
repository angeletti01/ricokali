package com.reimburse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.reimburse.hibernate.dao.Employee_RequestDAO;
import com.reimburse.hibernate.model.Employee_Request;
import com.reimburse.hibernate.model.Manager_Request;
import com.reimburse.hibernate.util.HibernateUtil;

/**
 * Servlet implementation class ManagerRequestApprovalController
 */
public class ManagerRequestApprovalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Employee_RequestDAO emplDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerRequestApprovalController() {
        super();
        // TODO Auto-generated constructor stub
    }

    	public void init() 
    	{
    		emplDAO = new Employee_RequestDAO();
    	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("managerApproveRequest.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		approval(request, response);
	}
	
	
	
	private void approval(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		Employee_Request emplReq = new Employee_Request();
		
		String employee_request_id = request.getParameter("employee_request_id");
		System.out.println(employee_request_id);
		String approved = request.getParameter("approved");
		System.out.println(approved);
		
		
		int j = Integer.parseInt(employee_request_id);
		boolean a;
		
		
		if(approved != null) 
		{
			a = true;
			
		}
		else 
		{
			a = false;
		} 
		
				
		Transaction transaction = null;
		Employee_Request er = null;
		
		try(Session session = HibernateUtil.getSession())
		{
			transaction = session.beginTransaction();
			
			String hql = "UPDATE Employee_Request er SET er.approved = :approved WHERE er.employee_request_id = :employee_request_id";
			
		int	updateEntities =  session.createQuery(hql)
					.setParameter("approved", a)
					.setParameter("employee_request_id", j)
					.executeUpdate();
			
			
			/*
			er = (Employee_Request) session.createQuery("UPDATE Employee_Request set approved = :approved WHERE employee_request_id = :employee_request_id")
					.setParameter("employee_request_id", employee_request_id).setParameter("approved", approved).uniqueResult();
			*/
			
			transaction.commit();	
			session.close();
		}
		catch(HibernateException e) 
		{
			e.printStackTrace();
			transaction.rollback();
		}		
	
	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("managerApproveRequest.html");
        dispatcher.forward(request, response);
		
        /*
		emplReq.setEmployee_request_id(j);
		emplReq.setApproved(a); */
	
		
		
	} 
	
	/*
	private void updateApproval(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		Employee_Request emplReq = new Employee_Request();
		String employee_request_id = request.getParameter("employee_request_id");
		String approved = request.getParameter("approved");
		String denied = request.getParameter("denied");
		
		int x = Boolean.parseBoolean(approved);
		System.out.println(approved);
		boolean y = Boolean.parseBoolean(denied); 
		System.out.println(denied);
		int i = Integer.parseInt(employee_request_id);	
	
		
		if(approved != null) 
		{
			x = true;
		}
		else 
		{
			x = false;
		}
		
		if(denied != null) 
		{
			y = true;
		}
		else 
		{
			y = false;
		}
		
		emplReq.setEmployee_request_id(i);
		System.out.println("Employee Request ID: " + i);
		emplReq.setApproved(x);
		System.out.println("Approved: " + x);
				
		emplDAO.saveEmployee_Request(emplReq);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("managerApproveRequest.html");
		dispatcher.forward(request, response);
		
	} // end method
	*/
	
	
} // close class
