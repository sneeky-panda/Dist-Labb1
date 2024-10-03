package se.kth.distribuerad.labb1.BO;

import java.util.Collection;
;

public class Item {
    private String name;
    private String description;
    private int ID;
    private int price;

    static public Collection searchItems(String group){
        return null;//ItemDB.searchItems(group);
    }

    protected Item(int ID, String name, String description){
        this.ID = ID;
        this.name = name;
        this.description = description;
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


