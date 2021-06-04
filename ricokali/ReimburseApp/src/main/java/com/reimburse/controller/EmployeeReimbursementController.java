package com.reimburse.controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.postgresql.largeobject.BlobInputStream;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.reimburse.hibernate.dao.*;
import com.reimburse.hibernate.model.*;


@MultipartConfig(maxFileSize = 16177215) // upload file size max
public class EmployeeReimbursementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Employee_RequestDAO emplReqDAO;

	public EmployeeReimbursementController() {
		super();
	}

	public void init() {
		emplReqDAO = new Employee_RequestDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("employeeSubmitRequest.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		submit(request, response);
	}

	private void submit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee_Request emplReq = new Employee_Request();

		String link = request.getParameter("link"); // retrieves text input
		String employee_id = request.getParameter("employee_id"); // retrieves text input
		String description = request.getParameter("description"); // retrieves text input

		int i = Integer.parseInt(employee_id); // converts string to int

					
		
			emplReq.setLink(link);
			System.out.println(link);
			emplReq.setEmployee_id(i);
			System.out.println(i);
			emplReq.setDescription(description);
			System.out.println(description);
			emplReq.setApproved(false);
			System.out.println(false);
			

			emplReqDAO.saveEmployee_Request(emplReq);

			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeHomepage.html");
			dispatcher.forward(request, response);
			// IOUtils.copy(inputStream, stream);
			

	} // submit

}// end class
