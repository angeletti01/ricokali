package com.pipeline.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper 
{
public static String processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	final String URI = request.getRequestURI();
	final String RESOURCE =URI.replace("/Pipeline/dispatcher", "");
	
	switch(RESOURCE) 
	{
	case "/welcome":
		return "Welcome to the Welcome Page";
		
	case "/goodbye":
		return "See you, come back soon";
		
		default:
			return "That is not a supported operation";
	
	}
	
	
	
}

} // end RequestHelper class
