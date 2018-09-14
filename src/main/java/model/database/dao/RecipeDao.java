package model.database.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "Recipe")
public class RecipeDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id", nullable = false)
    private Integer recipeId;

    @Column(name = "recipe_name", nullable = false, columnDefinition = "varchar(255) default ''")
    private String recipeName;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FoodInRecipeDao> foodList;

    public RecipeDao() {
        super();
        this.foodList = new ArrayList<>();
    }

    /**
     * Gets the value of recipeId.
     *
     * @return the value of recipeId
     */
    public Integer getRecipeId() {
        return recipeId;
    }

    /**
     * Sets the value of recipeId.
     *
     * @param recipeId the value to set
     */
    public void setRecipeId(Integer recipeId) {
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
    public List<FoodInRecipeDao> getFoodList() {
        return foodList;
    }

    /**
     * Sets the value of foodList.
     *
     * @param foodList the value to set
     */
    public void setFoodList(List<FoodInRecipeDao> foodList) {
        this.foodList = foodList;
    }

}
