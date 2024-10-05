package se.kth.distribuerad.labb1.BO;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    private int totalPrice;

    public Cart() {
        this.products = new ArrayList<Product>();
        this.totalPrice = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public int getTotalPrice(){
        return totalPrice;
    }

}
