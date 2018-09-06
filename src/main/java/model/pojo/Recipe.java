package model.pojo;

import java.util.List;

public class Recipe {

    private int recipeId;

    private String recipeName;

    private List<Food> foodList;

    public Recipe(int recipeId, String recipeName, List<Food> foodList) {
        super();
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.foodList = foodList;
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
     * Gets the value of foodList.
     *
     * @return the value of foodList
     */
    public List<Food> getFoodList() {
        return foodList;
    }

    /**
     * Sets the value of foodList.
     *
     * @param foodList the value to set
     */
    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
 

}
