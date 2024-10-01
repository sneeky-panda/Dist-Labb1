package se.kth.distribuerad.labb1.BO;

import java.util.Collection;

import se.kth.distribuerad.labb1.DB.ItemDB;

public class Item {
    private String name;
    private String description;
    private int ID;
    private int price;

    static public Collection<Item> searchItems(String group){
        return null;
        //return ItemDB.searchItems(group);
    }

    protected Item(int ID, String name, String description, int price){
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getID(){
        return this.ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}


