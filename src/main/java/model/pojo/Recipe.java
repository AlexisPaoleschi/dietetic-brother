package model.pojo;

import java.util.Map;

public class Recipe {

    private int recipeId;

    private String recipeName;

    private Map<Food, Integer> foodMap;

    public Recipe(int recipeId, String recipeName, Map<Food, Integer> foodMap) {
        super();
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.foodMap = foodMap;
    }

    /**
     * Gets the value of recipeId.
     *
     * @return the value of recipeId
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * Sets the value of recipeId.
     *
     * @param recipeId the value to set
     */
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * Gets the value of recipeName.
     *
     * @return the value of recipeName
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Sets the value of recipeName.
     *
     * @param recipeName the value to set
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * Gets the value of foodMap.
     *
     * @return the value of foodMap
     */
    public Map<Food, Integer> getFoodMap() {
        return foodMap;
    }

    /**
     * Sets the value of foodMap.
     *
     * @param foodMap the value to set
     */
    public void setFoodMap(Map<Food, Integer> foodMap) {
        this.foodMap = foodMap;
    }

}
