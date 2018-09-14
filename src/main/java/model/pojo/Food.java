package model.pojo;

public class Food {

    private Integer foodId;
    private String foodName;

    private Double glucideAmountFor100g;
    private Double lipideAmountFor100g;
    private Double proteineAmountFor100g;

    private Double glucideAmount;
    private Double lipideAmount;
    private Double proteineAmount;

    public Food(Integer foodId, String foodName, Double glucideAmountFor100g, Double lipideAmountFor100g, Double proteineAmountFor100g) {
        super();
        this.foodId = foodId;
        this.foodName = foodName;
        this.glucideAmountFor100g = glucideAmountFor100g;
        this.lipideAmountFor100g = lipideAmountFor100g;
        this.proteineAmountFor100g = proteineAmountFor100g;
        this.glucideAmount = 0.0;
        this.lipideAmount = 0.0;
        this.proteineAmount = 0.0;
    }

    public Food(
        Integer foodId,
        String foodName,
        Double glucideAmountFor100g,
        Double lipideAmountFor100g,
        Double proteineAmountFor100g,
        Double glucideAmount,
        Double lipideAmount,
        Double proteineAmount) {
        super();
        this.foodId = foodId;
        this.foodName = foodName;
        this.glucideAmountFor100g = glucideAmountFor100g;
        this.lipideAmountFor100g = lipideAmountFor100g;
        this.proteineAmountFor100g = proteineAmountFor100g;
        this.glucideAmount = glucideAmount;
        this.lipideAmount = lipideAmount;
        this.proteineAmount = proteineAmount;
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
     * Gets the value of glucideAmountFor100g.
     *
     * @return the value of glucideAmountFor100g
     */
    public Double getGlucideAmountFor100g() {
        return glucideAmountFor100g;
    }

    /**
     * Sets the value of glucideAmountFor100g.
     *
     * @param glucideAmountFor100g the value to set
     */
    public void setGlucideAmountFor100g(Double glucideAmountFor100g) {
        this.glucideAmountFor100g = glucideAmountFor100g;
    }

    /**
     * Gets the value of lipideAmountFor100g.
     *
     * @return the value of lipideAmountFor100g
     */
    public Double getLipideAmountFor100g() {
        return lipideAmountFor100g;
    }

    /**
     * Sets the value of lipideAmountFor100g.
     *
     * @param lipideAmountFor100g the value to set
     */
    public void setLipideAmountFor100g(Double lipideAmountFor100g) {
        this.lipideAmountFor100g = lipideAmountFor100g;
    }

    /**
     * Gets the value of proteineAmountFor100g.
     *
     * @return the value of proteineAmountFor100g
     */
    public Double getProteineAmountFor100g() {
        return proteineAmountFor100g;
    }

    /**
     * Sets the value of proteineAmountFor100g.
     *
     * @param proteineAmountFor100g the value to set
     */
    public void setProteineAmountFor100g(Double proteineAmountFor100g) {
        this.proteineAmountFor100g = proteineAmountFor100g;
    }

    /**
     * Gets the value of glucideAmount.
     *
     * @return the value of glucideAmount
     */
    public Double getGlucideAmount() {
        return glucideAmount;
    }

    /**
     * Sets the value of glucideAmount.
     *
     * @param glucideAmount the value to set
     */
    public void setGlucideAmount(Double glucideAmount) {
        this.glucideAmount = glucideAmount;
    }

    /**
     * Gets the value of lipideAmount.
     *
     * @return the value of lipideAmount
     */
    public Double getLipideAmount() {
        return lipideAmount;
    }

    /**
     * Sets the value of lipideAmount.
     *
     * @param lipideAmount the value to set
     */
    public void setLipideAmount(Double lipideAmount) {
        this.lipideAmount = lipideAmount;
    }

    /**
     * Gets the value of proteineAmount.
     *
     * @return the value of proteineAmount
     */
    public Double getProteineAmount() {
        return proteineAmount;
    }

    /**
     * Sets the value of proteineAmount.
     *
     * @param proteineAmount the value to set
     */
    public void setProteineAmount(Double proteineAmount) {
        this.proteineAmount = proteineAmount;
    }

}
