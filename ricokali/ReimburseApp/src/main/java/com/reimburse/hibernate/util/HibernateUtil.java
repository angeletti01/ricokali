package com.reimburse.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;



public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static Session getSession() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", System.getenv("dburl"))
					.setProperty("hibernate.connection.username", System.getenv("dbusername"))
					.setProperty("hibernate.connection.password", System.getenv("dbpassword")).buildSessionFactory();
		} // end if
		return sessionFactory.getCurrentSession();
	}
}
