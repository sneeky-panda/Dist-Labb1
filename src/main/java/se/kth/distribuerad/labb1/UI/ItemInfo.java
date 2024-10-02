package se.kth.distribuerad.labb1.UI;

public class ItemInfo {
    private String name;
    private String description;

    public ItemInfo(String name,String description){
        this.name = name;
        this.description= description;

    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description= description;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
}
