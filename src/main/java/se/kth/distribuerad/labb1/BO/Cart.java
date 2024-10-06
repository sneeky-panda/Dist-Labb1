package se.kth.distribuerad.labb1.BO;

import java.util.ArrayList;
import java.util.List;

/**
 * Cart representerar en varukorg i webbutiken.
 * Klassen håller reda på de produkter som har lagts till i varukorgen och deras totala pris.
 */
public class Cart {
    /**
     * Skapar en references till en lista över prudukter som ska finnas i varukorgen
     */
    private List<Product> products;
    /**
     * Skapar en references till en int som ska hålla kåll på totalpriset i varukorgen
     */
    private int totalPrice;

    /**
     * skapar en instans med en lista för produkter och sätter totalpriset till noll.
     */
    public Cart() {
        this.products = new ArrayList<Product>();
        this.totalPrice = 0;
    }

    /**
     *
     * @param product denna produkt adderas till varukorgen.
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     *
     * @return lista över produkter i varukorgen
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     *
     * @param product denna produkt tas bort från varukorgen
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }

    /**
     *
     * @return totalpriset över produkter i varukorgen
     */
    public int getTotalPrice(){
        return totalPrice;
    }

}
