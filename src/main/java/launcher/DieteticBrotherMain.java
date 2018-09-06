package launcher;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Array;
import org.hibernate.service.ServiceRegistry;

import model.hibernate.Glucide;
import model.hibernate.Lipide;
import model.hibernate.Proteine;
import model.pojo.Food;
import model.pojo.Recipe;
import utils.Utils;

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
			
			// Retrieve all Food from database
			Query queryGlu = sessionObj.createQuery("FROM Glucide");
			Query queryLip = sessionObj.createQuery("FROM Lipide");
			Query queryPro = sessionObj.createQuery("FROM Proteine");
			
			List<Glucide> lstGlu = queryGlu.list();
			List<Lipide> lstLip = queryLip.list();
			List<Proteine> lstPro = queryPro.list();
			
			List<Food> lstFood = new ArrayList<>();
			
			lstGlu.forEach(g -> {
				int foodId = g.getProductCode();
				String foodName = g.getAlimentProduct();
				double gluAmount = Utils.parseStringWithcomaToDouble(g.getGlucideAmount());
				double lipAmount = 0;
				double proAmount = 0;
				Food food = new Food(foodId, foodName, gluAmount, lipAmount, proAmount);
				lstLip.forEach(l ->{
					if(l.getProductCode() == foodId){
						food.setLipideAmount(Utils.parseStringWithcomaToDouble(l.getLipideAmount()));
					}
				});
				lstPro.forEach(p ->{
					if(p.getProductCode() == foodId){
						food.setProteineAmount(Utils.parseStringWithcomaToDouble(p.getProteineAmount()));
					}
				});
				lstFood.add(food);
			});

			
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