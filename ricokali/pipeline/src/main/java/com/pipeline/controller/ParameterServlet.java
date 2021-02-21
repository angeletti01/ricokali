package com.pipeline.controller;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.Enumeration;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

public class ParameterServlet extends HttpServlet
{
private static final long serialVersionUID = 1L;

public ParameterServlet() 
{
	super();	
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   
{  
  doGet(request, response);  
}  
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   
{  
  response.setContentType("text/html");  
  PrintWriter out=response.getWriter();  
  out.println("<html><head>");  
  out.println("<title>Servlet Parameter</title>");  
  out.println("</head>");  
  out.println("<body>");  
  Enumeration parameters = request.getParameterNames();  
  String param=null;  
      while (parameters.hasMoreElements())  
      {  
            param=(String)parameters.nextElement();                    
            out.println(param + ":" + request.getParameter(param) + "<br>" );                    
      }  
 out.println("</body></html>");  
 out.close();  
}

@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
}  

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.service(req, resp);
}

@Override
public void destroy() {
	// TODO Auto-generated method stub
	super.destroy();
}



} // end class ParameterServlet 


