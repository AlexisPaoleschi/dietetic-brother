package model;

import java.util.ArrayList;
import java.util.List;

import model.database.Database;
import model.pojo.Food;
import model.pojo.Recipe;

public class DieteticBrotherModel {

    private List<Food> availableFood;

    private Recipe recipe;

    private Database database;

    /**
     * Constructeur initialisant les variables.
     */
    public DieteticBrotherModel() {
        database = new Database();
        recipe = new Recipe(0, "My Recipe", new ArrayList<>());
    }

    public void addAvailableFood(Food food) {
        database.createAvailableFood(food);
    }
}
