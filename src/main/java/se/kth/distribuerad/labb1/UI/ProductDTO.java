package se.kth.distribuerad.labb1.UI;

import se.kth.distribuerad.labb1.BO.Category;

public class ProductDTO {
    private int productID;
    private String product_name;
    private int price;
    private int inStock;
    private Category category;

    public ProductDTO(int productID, String product_name, int price, int inStock, Category category) {
        this.productID = productID;
        this.product_name = product_name;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
