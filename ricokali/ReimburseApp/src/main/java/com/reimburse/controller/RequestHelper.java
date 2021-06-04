package com.reimburse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimburse.service.EmployeeReviewService;

public class RequestHelper 
{
	public static Object processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		final String URI = request.getRequestURI();
		final String RESOURCE = URI.replace("/ReimburseApp/api","");
		
		switch(RESOURCE) 
		{
		case "/emplReview":
			final String employee_id = request.getParameter("employee_id");
			int i = Integer.parseInt(employee_id);
			return new EmployeeReviewService().getReview(i);
		
		default:
			response.setStatus(404);
			return "Sorry, resource not found";
		}
		
		
	}
}
