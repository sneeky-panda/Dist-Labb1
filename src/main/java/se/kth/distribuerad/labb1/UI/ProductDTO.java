package se.kth.distribuerad.labb1.UI;

import se.kth.distribuerad.labb1.BO.Category;

/**
 * Representerar produkterDTO som kommer att finnas i systemet
 */
public class ProductDTO {
    /**
     * Den unika ID som produkten äger
     */
    private int productID;
    /**
     * produktens namn
     */
    private String product_name;
    /**
     * priset på produkten
     */
    private int price;
    /**
     * Hur många exemplar det finns av produkten
     */
    private int inStock;
    /**
     * Kategorier som delar in produkterna
     */
    private Category category;

    /**
     * Skapar instans med detta info
     * @param productID
     * @param product_name
     * @param price
     * @param inStock
     * @param category
     */
    public ProductDTO(int productID, String product_name, int price, int inStock, Category category) {
        this.productID = productID;
        this.product_name = product_name;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
    }
    /**
     *
     * @return produktensDTO unika ID
     */
    public int getProductID() {
        return productID;
    }
    /**
     *
     * @param productID sätter detta ID på DTO
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }
    /**
     *
     * @return priset på produktenDTO.
     */
    public int getPrice() {
        return price;
    }
    /**
     *
     * @param price sätter nytt pris på produktenDTO.
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     *
     * @return produktensDTO namn
     */
    public String getProductName() {
        return product_name;
    }
    /**
     *
     * @param product_name sätter nytt namn på produkten
     */
    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    /**
     *
     * @return antalet i lagret
     */
    public int getInStock() {
        return inStock;
    }

    /**
     * sätter hur många det finns i lagret
     * @param inStock
     */
    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    /**
     *
     * @return vilken kategori produkten tillhör
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sätter den kategori produkten ska tillhöra
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
