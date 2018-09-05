package launcher;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.hibernate.Glucide;

public class DieteticBrotherMain {

	
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;
	
	public static void main(String[] args) {
//        MySQLConnector dbConnection = new MySQLConnector();
//        dbConnection.openConnection();
		
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
			// Create session with connection to database
			sessionObj = buildSessionFactory().openSession();
			
			Query query = sessionObj.createQuery("FROM Glucide");
			List<Glucide> lstGlu = query.list();
			
			sessionObj.beginTransaction();

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
			
		} catch(Exception sqlException) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if(sessionObj != null) {
				sessionObj.close();
			}
		}
    }
	
	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");
		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
		// Creating Hibernate SessionFactory Instance
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}
	
}