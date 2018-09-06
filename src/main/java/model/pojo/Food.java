package model.pojo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Food {

    private final SimpleIntegerProperty foodId = new SimpleIntegerProperty(this, "foodId", -1);
    private final SimpleStringProperty foodName = new SimpleStringProperty(this, "foodName", "");
    private final SimpleDoubleProperty glucideAmount = new SimpleDoubleProperty(this, "glucideAmount", 0.0);
    private final SimpleDoubleProperty lipideAmount = new SimpleDoubleProperty(this, "lipideAmount", 0.0);
    private final SimpleDoubleProperty proteineAmount = new SimpleDoubleProperty(this, "proteineAmount", 0.0);

    public Food(int foodId, String foodName, double glucideAmount, double lipideAmount, double proteineAmount) {
        super();
        this.foodId.set(foodId);
        this.foodName.set(foodName);
        this.glucideAmount.set(glucideAmount);
        this.lipideAmount.set(lipideAmount);
        this.proteineAmount.set(proteineAmount);
    }

    /**
     * Gets the value of foodId.
     *
     * @return the value of foodId
     */
    public int getFoodId() {
        return foodId.get();
    }

    /**
     * Sets the value of foodId.
     *
     * @param foodId the value to set
     */
    public void setFoodId(int foodId) {
        this.foodId.set(foodId);
    }

    /**
     * Gets the value of foodName.
     *
     * @return the value of foodName
     */
    public String getFoodName() {
        return foodName.get();
    }

    /**
     * Sets the value of foodName.
     *
     * @param foodName the value to set
     */
    public void setFoodName(String foodName) {
        this.foodName.set(foodName);
    }

    /**
     * Gets the value of glucideAmount.
     *
     * @return the value of glucideAmount
     */
    public double getGlucideAmount() {
        return glucideAmount.get();
    }

    /**
     * Sets the value of glucideAmount.
     *
     * @param glucideAmount the value to set
     */
    public void setGlucideAmount(double glucideAmount) {
        this.glucideAmount.set(glucideAmount);
    }

    /**
     * Gets the value of lipideAmount.
     *
     * @return the value of lipideAmount
     */
    public double getLipideAmount() {
        return lipideAmount.get();
    }

    /**
     * Sets the value of lipideAmount.
     *
     * @param lipideAmount the value to set
     */
    public void setLipideAmount(double lipideAmount) {
        this.lipideAmount.set(lipideAmount);
    }

    /**
     * Gets the value of proteineAmount.
     *
     * @return the value of proteineAmount
     */
    public double getProteineAmount() {
        return proteineAmount.get();
    }

    /**
     * Sets the value of proteineAmount.
     *
     * @param proteineAmount the value to set
     */
    public void setProteineAmount(double proteineAmount) {
        this.proteineAmount.set(proteineAmount);
    }

}
