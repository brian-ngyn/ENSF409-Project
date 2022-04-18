package edu.ucalgary.ensf409;

public class FoodItem {
    private final int ITEMID;
    private final String ITEMNAME;
    private final int GRAINCONTENT;
    private final int FRUITVEGGIESCONTENT;
    private final int PROTEINCONTENT;
    private final int OTHERNUTRITION;
    private final int CALORIES;

    /**
     * Initialize a FoodItem object with the food item details
     * @param itemID
     * @param itemName
     * @param grainContent
     * @param fruitsVeggiesContent
     * @param proteinContent
     * @param otherNutrition
     * @param calories
     */
    public FoodItem(int itemID, String itemName, int grainContent, int fruitsVeggiesContent, int proteinContent, int otherNutrition, int calories){
        this.ITEMID = itemID;
        this.ITEMNAME = itemName;
        this.GRAINCONTENT = grainContent;
        this.FRUITVEGGIESCONTENT = fruitsVeggiesContent;
        this.PROTEINCONTENT = proteinContent;
        this.OTHERNUTRITION = otherNutrition;
        this.CALORIES = calories;
    }

    /**
     * Getter method for Item ID
     * @return ITEMID
     */
    public int getItemID(){
        return this.ITEMID;
    }

    /**
     * Getter method for itemName
     * @return ITEMNAME
     */
    public String getItemName(){
        return this.ITEMNAME;
    }

    /**
     * Getter method for grainContent
     * @return GRAINCONTENT
     */
    public int getGrainContent(){
        return this.GRAINCONTENT;
    }

    /**
     * Getter method for fruitVeggiesContent
     * @return FRUITVEGGIESCONTENT
     */
    public int getFruitsVeggiesContent(){
        return this.FRUITVEGGIESCONTENT;
    }

    /**
     * Getter method for proteinContent
     * @return PROTEINCONTENT
     */
    public int getProteinContent(){
        return this.PROTEINCONTENT;
    }

    /**
     * Getter method for otherNutrition
     * @return OTHERNUTRITION
     */
    public int getOtherNutrition(){
        return this.OTHERNUTRITION;
    }

    /**
     * Getter method for calories
     * @return CALORIES
     */
    public int getCalories(){
        return this.CALORIES;
    }
}
