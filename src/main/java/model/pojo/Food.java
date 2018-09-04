package model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @Column(name = "foodId")
    private int foodId;

    @Column(name = "foodName")
    private String foodName;

    @Column(name = "glucideAmount")
    private double glucideAmount;

    @Column(name = "lipideAmount")
    private double lipideAmount;

    @Column(name = "proteineAmount")
    private double proteineAmount;

    public Food(int foodId, String foodName, double glucideAmount, double lipideAmount, double proteineAmount) {
        super();
        this.foodId = foodId;
        this.foodName = foodName;
        this.glucideAmount = glucideAmount;
        this.lipideAmount = lipideAmount;
        this.proteineAmount = proteineAmount;
    }

    /**
     * Gets the value of foodId.
     *
     * @return the value of foodId
     */
    public int getFoodId() {
        return foodId;
    }

    /**
     * Sets the value of foodId.
     *
     * @param foodId the value to set
     */
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    /**
     * Gets the value of foodName.
     *
     * @return the value of foodName
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * Sets the value of foodName.
     *
     * @param foodName the value to set
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * Gets the value of glucideAmount.
     *
     * @return the value of glucideAmount
     */
    public double getGlucideAmount() {
        return glucideAmount;
    }

    /**
     * Sets the value of glucideAmount.
     *
     * @param glucideAmount the value to set
     */
    public void setGlucideAmount(double glucideAmount) {
        this.glucideAmount = glucideAmount;
    }

    /**
     * Gets the value of lipideAmount.
     *
     * @return the value of lipideAmount
     */
    public double getLipideAmount() {
        return lipideAmount;
    }

    /**
     * Sets the value of lipideAmount.
     *
     * @param lipideAmount the value to set
     */
    public void setLipideAmount(double lipideAmount) {
        this.lipideAmount = lipideAmount;
    }

    /**
     * Gets the value of proteineAmount.
     *
     * @return the value of proteineAmount
     */
    public double getProteineAmount() {
        return proteineAmount;
    }

    /**
     * Sets the value of proteineAmount.
     *
     * @param proteineAmount the value to set
     */
    public void setProteineAmount(double proteineAmount) {
        this.proteineAmount = proteineAmount;
    }

}
