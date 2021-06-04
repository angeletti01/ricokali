package com.reimburse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimburse.service.ListEmployeeService;

public class RequestHelperThree 
{
	public static Object processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		final String URI = request.getRequestURI();
		final String RESOURCE = URI.replace("/ReimburseApp/api3", "");
		
		switch(RESOURCE) 
		{
		case "/listEmployee":
			final String manager_id = request.getParameter("manager_id");
			int i = Integer.parseInt(manager_id);
			return new ListEmployeeService().getEmployee(i);
			
			default:
				response.setStatus(404);
				return "Sorry, resource not found";
		}
				
	}
}
