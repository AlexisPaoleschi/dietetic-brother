package model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proteines")
public class Proteine {

	@Column(name = "familleAliments")
    private String alimentFamily;

    @Column(name = "sousFamilleAlimentaire_1")
    private String alimentSubFamily;

    @Column(name = "sousFamilleAlimentaire_2")
    private String alimentSubFamily2;

    @Column(name = "codeProduit")
    private Integer productCode;

    @Id
    @Column(name = "aliment")
    private String alimentProduct;

    @Column(name = "proteines_100g")
    private String proteineAmount;

    public Proteine(){
    	
    }
    
    public Proteine(
        String alimentFamily,
        String alimentSubFamily,
        String alimentSubFamily2,
        Integer productCode,
        String alimentProduct,
        String proteineAmount) {
        super();
        this.alimentFamily = alimentFamily;
        this.alimentSubFamily = alimentSubFamily;
        this.alimentSubFamily2 = alimentSubFamily2;
        this.productCode = productCode;
        this.alimentProduct = alimentProduct;
        this.proteineAmount = proteineAmount;
    }

    /**
     * Gets the value of alimentFamily.
     *
     * @return the value of alimentFamily
     */
    public String getAlimentFamily() {
        return alimentFamily;
    }

    /**
     * Sets the value of alimentFamily.
     *
     * @param alimentFamily the value to set
     */
    public void setAlimentFamily(String alimentFamily) {
        this.alimentFamily = alimentFamily;
    }

    /**
     * Gets the value of alimentSubFamily.
     *
     * @return the value of alimentSubFamily
     */
    public String getAlimentSubFamily() {
        return alimentSubFamily;
    }

    /**
     * Sets the value of alimentSubFamily.
     *
     * @param alimentSubFamily the value to set
     */
    public void setAlimentSubFamily(String alimentSubFamily) {
        this.alimentSubFamily = alimentSubFamily;
    }

    /**
     * Gets the value of alimentSubFamily2.
     *
     * @return the value of alimentSubFamily2
     */
    public String getAlimentSubFamily2() {
        return alimentSubFamily2;
    }

    /**
     * Sets the value of alimentSubFamily2.
     *
     * @param alimentSubFamily2 the value to set
     */
    public void setAlimentSubFamily2(String alimentSubFamily2) {
        this.alimentSubFamily2 = alimentSubFamily2;
    }

    /**
     * Gets the value of productCode.
     *
     * @return the value of productCode
     */
    public Integer getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of productCode.
     *
     * @param productCode the value to set
     */
    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    /**
     * Gets the value of alimentProduct.
     *
     * @return the value of alimentProduct
     */
    public String getAlimentProduct() {
        return alimentProduct;
    }

    /**
     * Sets the value of alimentProduct.
     *
     * @param alimentProduct the value to set
     */
    public void setAlimentProduct(String alimentProduct) {
        this.alimentProduct = alimentProduct;
    }

    /**
     * Gets the value of proteineAmount.
     *
     * @return the value of proteineAmount
     */
    public String getProteineAmount() {
        return proteineAmount;
    }

    /**
     * Sets the value of proteineAmount.
     *
     * @param proteineAmount the value to set
     */
    public void setProteineAmount(String proteineAmount) {
        this.proteineAmount = proteineAmount;
    }

}
