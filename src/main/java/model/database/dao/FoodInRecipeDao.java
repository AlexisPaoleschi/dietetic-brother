package model.database.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Table;

import model.pojo.Recipe;

@Entity
@Table(appliesTo = "Food_In_Recipe")
public class FoodInRecipeDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "food_in_recipe_id", nullable = false)
    private Integer foodInRecipeId;

    @Column(name = "food_id", nullable = true, columnDefinition = "int default -1")
    private Integer foodId;

    @Column(name = "quantity", nullable = true, columnDefinition = "int default 0")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    /**
     * Gets the value of foodInRecipeId.
     *
     * @return the value of foodInRecipeId
     */
    public Integer getFoodInRecipeId() {
        return foodInRecipeId;
    }

    /**
     * Sets the value of foodInRecipeId.
     *
     * @param foodInRecipeId the value to set
     */
    public void setFoodInRecipeId(Integer foodInRecipeId) {
        this.foodInRecipeId = foodInRecipeId;
    }

    /**
     * Gets the value of foodId.
     *
     * @return the value of foodId
     */
    public Integer getFoodId() {
        return foodId;
    }

    /**
     * Sets the value of foodId.
     *
     * @param foodId the value to set
     */
    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    /**
     * Gets the value of quantity.
     *
     * @return the value of quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of quantity.
     *
     * @param quantity the value to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the value of recipe.
     *
     * @return the value of recipe
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Sets the value of recipe.
     *
     * @param recipe the value to set
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
