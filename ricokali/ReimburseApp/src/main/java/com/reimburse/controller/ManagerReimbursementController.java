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
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.postgresql.largeobject.BlobInputStream;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.reimburse.hibernate.dao.Manager_RequestDAO;
import com.reimburse.hibernate.model.*;

@MultipartConfig(maxFileSize = 16177215) // upload file size max
public class ManagerReimbursementController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private Manager_RequestDAO manReqDAO;
	
	public ManagerReimbursementController() 
	{
		super();
	}
	
	public void init() 
	{
		manReqDAO = new Manager_RequestDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendRedirect("managerSubmitRequest.html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		submit(request, response);
	}
	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Manager_Request manReq = new Manager_Request();
		
		String link = request.getParameter("link"); // retrieves text input
		String manager_id = request.getParameter("manager_id"); // retrieves text input
		String description = request.getParameter("description"); // retrieves text input
		String manager_supervisor_id = request.getParameter("manager_supervisor_id");
		
		int i = Integer.parseInt(manager_id);
		int j = Integer.parseInt(manager_supervisor_id);
		
		manReq.setLink(link);
		System.out.println(link);
		manReq.setDescription(description);
		System.out.println(description);
		manReq.setManager_id(i);
		System.out.println(i);
		manReq.setApproved(false);
		System.out.println(false);
		manReq.setDenied(false);
		System.out.println(false);
		manReq.setManager_supervisor_id(manager_supervisor_id);
		System.out.println(j);
		
		manReqDAO.SaveManager_RequestDAO(manReq);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("managerHomepage.html");
		dispatcher.forward(request, response);
	}
	
}// end class








