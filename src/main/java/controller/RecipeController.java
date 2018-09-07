package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import model.DieteticBrotherModel;
import model.pojo.Food;
import utils.Utils;

public class RecipeController {

    private DieteticBrotherModel model;
    private Parent root;

    /**
     * Constructeur privé.
     */
    private RecipeController() {
    }

    /**
     * The instance.
     */
    private static RecipeController instance = new RecipeController();

    /**
     * Point d'accès pour l'instance unique du singleton.
     *
     * @return l'instance du singleton
     */
    public static RecipeController getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    public void searchTextFieldModified(String newValue) {
        List<Food> items = model.getAvailableFood();
        ObservableList<Food> newItems = FXCollections.observableArrayList();

        for (Food food : items) {
            if (food.getFoodName().toLowerCase().contains(newValue.toLowerCase())) {
                newItems.add(food);
            }
        }

        TableView<Food> availableFoodTableview = (TableView<Food>) root.lookup("#availableFoodTableview");
        availableFoodTableview.setItems(newItems);
    }

    public void addFoodToRecipe(Food food) {
        updateFoodQuantity(food, 100);
    }

    public void updateFoodQuantity(Food food, Integer quantity) {
        if (food != null && quantity >= 0) {
            Map<Food, Integer> foodMap = model.getRecipe().getFoodMap();
            food.setProteineAmount(Utils.round(quantity * food.getProteineAmountFor100g() / 100, 1));
            food.setGlucideAmount(Utils.round(quantity * food.getGlucideAmountFor100g() / 100, 1));
            food.setLipideAmount(Utils.round(quantity * food.getLipideAmountFor100g() / 100, 1));
            foodMap.put(food, quantity);
            model.updateRecipe(foodMap);
        }
    }

    public void deleteFoodFromRecipe(Food food) {
        Map<Food, Integer> foodMap = model.getRecipe().getFoodMap();
        Map<Food, Integer> newFoodMap = new HashMap<>();
        for (Food currentFood : foodMap.keySet()) {
            if (currentFood.getFoodId() != food.getFoodId()) {
                newFoodMap.put(currentFood, foodMap.get(currentFood));
            }
        }
        model.updateRecipe(newFoodMap);
    }

    public void setModel(DieteticBrotherModel model) {
        this.model = model;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

}
