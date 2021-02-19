package com.pipeline.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory 
{
/*This is a utility class for building a session factory and returning Hibernate sessions. Note that this
 * HibernateSessionFactory will be a Singleton, as SessionFactories are expensive to build, and we don't
 * need more than one to retrieve sessions in our application. */
	
	private static SessionFactory sessionFactory;	
	
	public static Session getSession() 
	{
		if(sessionFactory == null) 
		{
			 sessionFactory = new Configuration().configure()
			 .setProperty("hibernate.connection.url", System.getenv("dburl"))
			 .setProperty("hibernate.connection.username", System.getenv("dbusername"))
			 .setProperty("hibernate.connection.username", System.getenv("dbpassword"))
			 .buildSessionFactory();
		}
		
	return sessionFactory.getCurrentSession();
	} // end getSession()
	
} // end HibernateSessionFactory
