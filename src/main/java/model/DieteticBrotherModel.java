package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.database.Database;
import model.pojo.Food;
import model.pojo.Recipe;
import observer.Observable;
import observer.Observer;

public class DieteticBrotherModel implements Observable {

    private List<Observer> observersList = new ArrayList<>();

    private List<Food> availableFood;

    private List<Recipe> recipes;

    private Recipe recipe;

    private Database database;

    /**
     * Constructeur initialisant les variables.
     */
    public DieteticBrotherModel() {
        database = new Database();
        availableFood = database.initializeAvailableFood();
        recipes = database.initializeRecipes(availableFood);

        recipe = new Recipe(0, "My Recipe");
    }

    public void updateRecipe(Map<Food, Integer> foodList) {
        recipe.setFoodMap(foodList);
        recipeChangeNotifyObserver(recipe);
    }

    public void updateAll() {
        foodListChangeNotifyObserver(availableFood);
    }

    @Override
    public void foodListChangeNotifyObserver(List<Food> foodList) {
        for (final Observer obs : observersList) {
            obs.updateFoodList(foodList);
        }
    }

    @Override
    public void recipeChangeNotifyObserver(Recipe newRecipe) {
        for (final Observer obs : observersList) {
            obs.updateRecipe(newRecipe);
        }
    }

    @Override
    public void addObserver(Observer obs) {
        observersList.add(obs);
    }

    @Override
    public void removeObserver() {
        observersList = new ArrayList<>();
    }

    /**
     * Gets the value of availableFood.
     *
     * @return the value of availableFood
     */
    public List<Food> getAvailableFood() {
        return availableFood;
    }

    /**
     * Gets the value of recipe.
     *
     * @return the value of recipe
     */
    public Recipe getRecipe() {
        return recipe;
    }

}
