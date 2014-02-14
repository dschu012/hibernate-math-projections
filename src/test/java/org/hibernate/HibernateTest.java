package org.hibernate;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import domain.YearlyEarning;

public class HibernateTest {

	protected static Session session;
	protected static SessionFactory sessionFactory;
	
	static {
		Configuration config = new Configuration();
		
		config.setProperty("hibernate.dialect",
	    "org.hibernate.dialect.MySQLDialect");
		config.setProperty("hibernate.connection.driver_class",
	    "com.mysql.jdbc.Driver");
		config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
		config.setProperty("hibernate.connection.username", "root");
		config.setProperty("hibernate.connection.password", "");
		config.setProperty("hibernate.hbm2ddl.auto", "update");
		config.setProperty("hibernate.show_sql", "true");
		config.addAnnotatedClass(YearlyEarning.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}
	
}
