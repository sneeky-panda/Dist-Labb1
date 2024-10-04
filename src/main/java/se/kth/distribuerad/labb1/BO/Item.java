package se.kth.distribuerad.labb1.BO;

import java.util.Collection;
;

public class Item {
    private String name;
    private int ID;
    private int price;
    private int stock;
    private Category category;

    static public Collection<Item> searchItems(String group){
        return null;//ItemDB.searchItems(group);
    }

    public Item(int ID, String name, int price, int stock, Category category){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public String getName(){
        return this.name;
    }

    public int getID(){
        return this.ID;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return this.stock;
    }

    public Category getCategory() {
        return this.category;
    }

}


