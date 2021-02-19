package com.pipeline.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DispatcherServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(DispatcherServlet.class);	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*
		 * We can use our HttpServletRequest to access information about the HTTP request.
		 * */
		final String URI = request.getRequestURI();
		LOG.debug(URI);
		
		response.getWriter().write("dispatcher is populating the response body");
		
	}
}
