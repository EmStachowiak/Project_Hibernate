package pl.maja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	
	public static SessionFactory getSessionFactory() {

		if(sessionFactory == null) {

		Configuration configuration = new Configuration();
		Properties settings = new Properties();

		settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		settings.put(Environment.URL, "jdbc:mysql://localhost:3306/practica_Es_2");
		settings.put(Environment.USER, "root");
		settings.put(Environment.PASS, "");
		settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		settings.put(Environment.SHOW_SQL, "true");   
		settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		settings.put(Environment.HBM2DDL_AUTO, "create");
		

		configuration.setProperties(settings);
		configuration.addAnnotatedClass(Manga.class);
		configuration.addAnnotatedClass(CasaEditrice.class);

		
		ServiceRegistry sr = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.build();
		
		sessionFactory = configuration.buildSessionFactory(sr);
		
		
		}
		return sessionFactory;
		}

}