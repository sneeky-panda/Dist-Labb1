package se.kth.distribuerad.labb1.BO;

import se.kth.distribuerad.labb1.UI.ProductDTO;

/**
 * Representerar produkter som kommer att finnas i systemet
 */

public class Product {
    /**
     * Den unika ID som produkten äger
     */
    private int productID;
    /**
     * produktens namn
     */
    private String productName;
    /**
     *ger en enklare beskrivning över produkten
     */
    private String productDescription;
    /**
     * priset på produkten
     */
    private int price;
    /**
     * Hur många exemplar det finns av produkten
     */
    private  int inStock;
    /**
     * Kategorier som delar in produkterna
     */
    private Category category;

    /**
     * Skapar instans med detta info
     * @param productID
     * @param product_name
     * @param productDescription
     * @param price
     * @param inStock
     * @param category
     */
    public Product(int productID, String product_name, String productDescription, int price, int inStock, Category category) {
        this.productID = productID;
        this.productName = product_name;
        this.productDescription = productDescription;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
    }

    /**
     * Skapar instans med detta info
     * @param product_name
     * @param productDescription
     * @param price
     * @param inStock
     * @param category
     */
    public Product(String product_name, String productDescription, int price, int inStock, Category category) {
        this.productName = product_name;
        this.productDescription = productDescription;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
    }

    /**
     * Skapar instans med detta info
     * @param product_name
     * @param price
     * @param inStock
     * @param category
     */
    public Product(String product_name,int price,int inStock, Category category) {
        this.productName = product_name;
        this.price=price;
        this.inStock=inStock;
        this.category = category;
    }

    /**
     * Skapar instans med detta info
     * @param productID
     * @param product_name
     * @param price
     * @param inStock
     * @param category
     */
    public Product(int productID, String product_name, int price, int inStock, Category category) {
        this.productID = productID;
        this.productName = product_name;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
    }

    /**
     *
     * @return produktens unika ID
     */
    public int getProductID() {
        return productID;
    }

    /**
     *
     * @param productID sätter detta ID
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     *
     * @return produktens namn
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @param productName sätter nytt namn på produkten
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     *
     * @return String beskrivning av produkten
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     *
     * @param productDescription Sätter en ny beskrivning på produkten
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     *
     * @return priset på produkten.
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price sätter nytt pris på produkten.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return antalet av produkten i lager.
     */
    public int getInStock() {
        return inStock;
    }

    /**
     *
     * @param inStock sätter nytt värde på produkten i lagret
     */
    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    /**
     *
     * @return vilken kategori varan tillhör
     */
    public Category getCategory() {
        return category;
    }

    /**
     *
     * @param category sätter kategori på produkten
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     *  Gör om från user till DTO
     * @return ny skapad DTO med all data
     */
    public ProductDTO makeDTO() {
        return new ProductDTO(productID, productName, price, inStock, category);
    }

    /**
     *
     * @return en toString
     */
    @Override
    public String toString() {
        return "Product{" +
                "product_ID=" + productID +
                ", product_name='" + productName + '\'' +
                ", product_description='" + productDescription + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                '}';
    }
}
