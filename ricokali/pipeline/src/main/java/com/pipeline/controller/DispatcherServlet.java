package com.pipeline.controller;

import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.*;



/*This servlet is a Front Controller. The "Front Controller" is a design pattern in which we have a single
 * front controller which serves as a single point of entry to our application. All of the requests and reponses are meant to 
 * move through here. This establishes a single point of validation. This scales well since you don't need a lot of servlets. */
@WebServlet("/dispatcherServlet")
public class DispatcherServlet extends HttpServlet 
{
	private static final String UPLOAD_DIRECTORY = "upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; //50MB
	/*The servlet container calls the init method after it creates an instance of the Servlet class.
	 * Your web container decides that an instance of a servlet class is needed when the url pattern for a servlet
	 * is mapped matches that of the request URL. This method is called only once per instance. */
	

	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(DispatcherServlet.class);	
	private static final String filepath  = "C:\\git_repositories\\ricokali\\ricokali\\pipeline\\uploads";
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		//new FileInputStream(new File(request.getParameter("image")));
		
		if(!ServletFileUpload.isMultipartContent(request)) 
		{
			PrintWriter writer = response.getWriter();
			writer.println("Request does not contain upload data");
			writer.flush();
			return;
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		// Constructs the directory path to store upload file (IF FILE PATH DOESN'T WORK TROUBLESHOOT THIS CODE!!!)
		String uploadPath = getServletContext().getRealPath(filepath) + File.separator + UPLOAD_DIRECTORY;
		
		// Creates the directory if it does not exist
		
		
	
		
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) 
		{
			uploadDir.mkdir();
		}
		
		try {
		List formItems = upload.parseRequest(request);
		Iterator iter = formItems.iterator();
		
		// iterates over form's fields
		while(iter.hasNext()) 
		{
			FileItem item = (FileItem) iter.next();
			// processes only fields that are not form fields
			if(!item.isFormField()) 
			{
				String fileName = new File(item.getName()).getName();
				String filePath = uploadPath + File.separator + fileName;
				File storeFile = new File(filepath);
				
				try {
				item.write(storeFile);
				}
				catch(FileUploadException f) 
				{
					f.printStackTrace();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
		} // end try block
		catch(FileUploadException f) 
		{
			f.printStackTrace();
		}
		
		
		PrintWriter writer = response.getWriter();
		String htmlResponse = "<html>";
		htmlResponse += "\n <h2> Name: " + name + "</h2>";
		htmlResponse += "\n <h2> Email:  " + email + "</h2>";
		htmlResponse += "\n <h2> Message:  " + email + "</h2>";		
		htmlResponse += "</html>";
		
		writer.println(htmlResponse);
	} // end doPost method
		
	@Override
	public void init() throws ServletException {
		
		super.init();
	}

	/*Servlet Lifecycle*/
	
	/*The servlet container calls the service method as many times as needed. If there is already a working
	 * instance of our servlet class, the web container can invoke that servlet's service method. During the service method, 
	 * handler methods such as doGet, doPost, etc. are called. */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.service(req, resp);
	}
	
	/*Our web container calls the destroy method once. This method may be called when the servlet
	 * container has been idle for a certain period of time, or if the server is shut down. It is called
	 * once. The servlet is then taken out of commission. */
	@Override
	public void destroy() {
		
		super.destroy();
	}
}
