package com.reimburse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimburse.service.ManagerReviewService;

public class RequestHelperTwo 
{
	public static Object processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		final String URI = request.getRequestURI();
		final String RESOURCE = URI.replace("/ReimburseApp/api2", "");
		
		switch(RESOURCE) 
		{
		case "/manReview":
			final String manager_id = request.getParameter("manager_id");
			int j = Integer.parseInt(manager_id);			
			return new ManagerReviewService().getReview(j);
			
			default:
				response.setStatus(404);
				return "Sorry, resource not found";
		}		
		
	}
}
