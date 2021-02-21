package com.pipeline.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class ConnectionCloser 
{
	/*Optional*/
	public static void close(Connection conn) 
	{
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) 
	{
		try {
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet set) 
	{
		try {
			set.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}	
	
	
}
