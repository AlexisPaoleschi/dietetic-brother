package model.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.hibernate.Glucide;
import model.hibernate.Lipide;
import model.hibernate.Proteine;
import model.pojo.Food;
import utils.Utils;

public class Database {

    private final Session session;

    private SessionFactory sessionFactory;

    public Database() {
        session = getSessionFactory().openSession();
    }

    @SuppressWarnings("unchecked")
    public List<Food> initializeAvailableFood() {
        List<Food> availableFood = new ArrayList<>();

        List<Glucide> glucidesList = session.createQuery("FROM Glucide").list();
        List<Lipide> lipidesList = session.createQuery("FROM Lipide").list();
        List<Proteine> proteinesList = session.createQuery("FROM Proteine").list();

        for (Glucide g : glucidesList) {
            int foodId = g.getProductCode();
            String foodName = g.getAlimentProduct();
            double gluAmount = Utils.parseStringWithComaToDouble(g.getGlucideAmount());
            double lipAmount = 0;
            double proAmount = 0;
            Food food = new Food(foodId, foodName, gluAmount, lipAmount, proAmount);
            lipidesList.forEach(l -> {
                if (l.getProductCode() == foodId) {
                    food.setLipideAmountFor100g(Utils.parseStringWithComaToDouble(l.getLipideAmount()));
                }
            });
            proteinesList.forEach(p -> {
                if (p.getProductCode() == foodId) {
                    food.setProteineAmountFor100g(Utils.parseStringWithComaToDouble(p.getProteineAmount()));
                }
            });
            availableFood.add(food);
        }

        return availableFood;
    }

    /**
     * Méthode permettant de récupérer une SessionFactory d'Hibernate.
     *
     * @return SessionFactory d'Hibernate
     */
    private SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    /**
     * Méthode de fermeture de la base de données.
     */
    public void closeDB() {
        session.clear();
        session.close();
    }

    /**
     * Méthode d'exécution d'une requête SQL par Hibernate.
     *
     * @param requete : la requête SQL
     */
    public void executeSQLQuery(String requete) {
        session.createSQLQuery(requete).executeUpdate();
    }

}
