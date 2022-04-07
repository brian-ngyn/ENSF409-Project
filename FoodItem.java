package edu.ucalgary.ensf409;

public class FoodItem {
    private final int ITEMID;
    private final String ITEMNAME;
    private final int GRAINCONTENT;
    private final int FRUITVEGGIESCONTENT;
    private final int PROTEINCONTENT;
    private final int OTHERNUTRITION;
    private final int CALORIES;

    public FoodItem(int itemID, String itemName, int grainContent, int fruitsVeggiesContent, int proteinContent, int otherNutrition, int calories){
        this.ITEMID = itemID;
        this.ITEMNAME = itemName;
        this.GRAINCONTENT = grainContent;
        this.FRUITVEGGIESCONTENT = fruitsVeggiesContent;
        this.PROTEINCONTENT = proteinContent;
        this.OTHERNUTRITION = otherNutrition;
        this.CALORIES = calories;
    }

    public int getItemID(){
        return this.ITEMID;
    }

    public String getItemName(){
        return this.ITEMNAME;
    }

    public int getGrainContent(){
        return this.GRAINCONTENT;
    }

    public int getFruitsVeggiesContent(){
        return this.FRUITVEGGIESCONTENT;
    }

    public int getProteinContent(){
        return this.PROTEINCONTENT;
    }

    public int getOtherNutrition(){
        return this.OTHERNUTRITION;
    }

    public int getCalories(){
        return this.CALORIES;
    }
}
