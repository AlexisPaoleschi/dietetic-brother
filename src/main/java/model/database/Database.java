package model.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.database.dao.FoodInRecipeDao;
import model.database.dao.RecipeDao;
import model.hibernate.Glucide;
import model.hibernate.Lipide;
import model.hibernate.Proteine;
import model.pojo.Food;
import model.pojo.Recipe;
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

    public List<Recipe> initializeRecipes(List<Food> availableFood) {
        List<RecipeDao> recipesDao = selectAllRecipes();
        List<Recipe> recipes = new ArrayList<>();

        for (RecipeDao recipeDao : recipesDao) {
            recipes.add(convertRecipeDaoToRecipe(recipeDao, availableFood));
        }

        return recipes;
    }

    @SuppressWarnings("unchecked")
    public List<RecipeDao> selectAllRecipes() {
        return session.createQuery("FROM Recipe").list();
    }

    public void saveRecipeInDatabase(Recipe recipe) {
        RecipeDao recipeDao = new RecipeDao();
        recipeDao.setRecipeName(recipe.getRecipeName());
        for (Entry<Food, Integer> entry : recipe.getFoodMap().entrySet()) {
            Food food = entry.getKey();
            FoodInRecipeDao foodInRecipeDao = new FoodInRecipeDao();
            foodInRecipeDao.setFoodId(food.getFoodId());
            foodInRecipeDao.setQuantity(entry.getValue());
            foodInRecipeDao.setRecipe(recipe);
            recipeDao.getFoodList().add(foodInRecipeDao);
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            for (FoodInRecipeDao foodInRecipeDao : recipeDao.getFoodList()) {
                session.save(foodInRecipeDao);
            }
            session.save(recipeDao);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        }
    }

    public Recipe convertRecipeDaoToRecipe(RecipeDao recipeDao, List<Food> availableFood) {
        Recipe recipe = new Recipe(recipeDao.getRecipeId(), recipeDao.getRecipeName());
        List<FoodInRecipeDao> foodList = recipeDao.getFoodList();
        for (FoodInRecipeDao foodInRecipeDao : foodList) {
            Food currentFood = null;
            for (Food food : availableFood) {
                if (food.getFoodId().equals(foodInRecipeDao.getFoodId())) {
                    currentFood = food;
                }
            }
            if (currentFood != null) {
                recipe.getFoodMap().put(currentFood, foodInRecipeDao.getQuantity());
            }
        }
        return recipe;
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
