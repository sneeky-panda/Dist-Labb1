package se.kth.distribuerad.labb1.BO;

public class Product {
    private int productID;
    private String productName;
    private String productDescription;
    private double price;
    private  int inStock;
    private Category category;

    public Product(int productID, String product_name, String productDescription, int price, int inStock, Category category) {
        this.productID = productID;
        this.productName = product_name;
        this.productDescription = productDescription;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
    }

    public Product(String product_name, String productDescription, int price, int inStock, Category category) {
        this.productName = product_name;
        this.productDescription = productDescription;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
    }

    public Product(String product_name,double price,int inStock, Category category) {
        this.productName = product_name;
        this.price=price;
        this.inStock=inStock;
        this.category = category;
    }

    public Product(int productID, String product_name, int price, int inStock, Category category) {
        this.productID = productID;
        this.productName = product_name;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
