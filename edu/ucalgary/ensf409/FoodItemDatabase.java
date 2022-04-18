package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.sql.*;

public class FoodItemDatabase {
    private ArrayList<FoodItem> foodItemArray = new ArrayList<FoodItem>();
    private Connection dbConnect;
    private ResultSet results;

    /**
     * Constructor for the database which calls fetchFromFoodDatabase()
     */
    public FoodItemDatabase(){
        
    }

    /**
     * 1st of 2 methods for the algorithm, goal is to hit the target amount for 3/4 of whole grains, fruit/veggies, protein, other
     * and then call addLastFoodItem()
     * @param targetWholeGrains
     * @param targetVeggies
     * @param targetProtein
     * @param targetOther
     * @return hamper with the food items that satisfy the target
     */
    public ArrayList<FoodItem> generateFoodItems(int targetWholeGrains, int targetVeggies, int targetProtein, int targetOther) {
        ArrayList<FoodItem> hamper = new ArrayList<FoodItem>();
        int currWholeGrains = 0;
        int currProtein = 0;
        int currOther = 0;
        int currVeggies = 0;
        int nutrition = 0;
        int nutritionSatisfied = 0;
        
        while(nutritionSatisfied < 3){
            
            int bestNutrition = Integer.MIN_VALUE;
            if(targetWholeGrains - currWholeGrains >= bestNutrition){
                bestNutrition = targetWholeGrains - currWholeGrains;
                nutrition = 0;
            }
            if(targetProtein - currProtein >= bestNutrition){
                bestNutrition = targetProtein - currProtein;
                nutrition = 1;
            }
            if(targetVeggies - currVeggies >= bestNutrition){
                bestNutrition = targetVeggies - currVeggies;
                nutrition = 2;
            }
            if(targetOther - currOther >= bestNutrition) {
                bestNutrition = targetOther - currOther;
                nutrition = 3;
            }
            
            if (foodItemArray.isEmpty()){
                return hamper;
            }
            FoodItem bestItem = foodItemArray.get(0);
            int lowestDifference = Integer.MAX_VALUE;
    
            for(int i = 0; i < foodItemArray.size(); i++){
               FoodItem anItem = foodItemArray.get(i);
                if(nutrition == 0){
                    if(Math.abs((targetWholeGrains - currWholeGrains) - (int)(anItem.getGrainContent()/ 100.0 * anItem.getCalories())) < lowestDifference){
                        lowestDifference = Math.abs((targetWholeGrains - currWholeGrains) - (int)(anItem.getGrainContent() / 100.0 * anItem.getCalories()));
                        bestItem = anItem;
                    }
                }

                else if(nutrition == 1){
                    if(Math.abs((targetProtein - currProtein) - (int)(anItem.getProteinContent() / 100.0 * anItem.getCalories())) < lowestDifference){
                        lowestDifference = Math.abs((targetProtein -currProtein) - (int)(anItem.getProteinContent() / 100.0 * anItem.getCalories()));
                        bestItem = anItem;
                    }
                }

                else if(nutrition == 2){
                    if(Math.abs((targetVeggies - currVeggies) - (int)(anItem.getFruitsVeggiesContent() / 100.0 * anItem.getCalories())) < lowestDifference){
                        lowestDifference = Math.abs((targetVeggies - currVeggies) - (int)(anItem.getFruitsVeggiesContent() / 100.0 * anItem.getCalories()));
                        bestItem = anItem;
                    }
                }

                else if(nutrition == 3){
                    if(Math.abs((targetOther - currOther) - (int)(anItem.getOtherNutrition() / 100.0 * anItem.getCalories())) < lowestDifference){
                        lowestDifference = Math.abs(targetOther - currOther - (int)(anItem.getOtherNutrition() / 100.0 * anItem.getCalories()));
                        bestItem = anItem;
                    }
                }
            }
            hamper.add(bestItem);
            deleteItem(bestItem.getItemName());
            currOther += (int)(bestItem.getOtherNutrition() / 100.0 * bestItem.getCalories());
            currVeggies += (int)(bestItem.getFruitsVeggiesContent() / 100.0 * bestItem.getCalories());
            currProtein += (int)(bestItem.getProteinContent() / 100.0 * bestItem.getCalories());
            currWholeGrains += (int)(bestItem.getGrainContent() / 100.0 * bestItem.getCalories());
            nutritionSatisfied = 0;
            if (currWholeGrains >= targetWholeGrains) {
                nutritionSatisfied++;
            }
            if (currProtein >= targetProtein){
                nutritionSatisfied++;
            }
            if (currVeggies >= targetVeggies){
                nutritionSatisfied++;
            }
            if (currOther >= targetOther){
                nutritionSatisfied++;
            }
        }
        hamper = addLastFoodItem(targetWholeGrains, targetVeggies, targetProtein, targetOther, hamper);
        return hamper;
    }

    /**
     * 2nd of 2 methods for the algorithm, that resolves the last nutrition value that was not completed from
     * generateFoodItems().
     * @param targetWholeGrains
     * @param targetVeggies
     * @param targetProtein
     * @param targetOther
     * @param hamper
     * @return hamper with 4/4 targets satisfied
     */
    public ArrayList<FoodItem> addLastFoodItem(int targetWholeGrains, int targetVeggies, int targetProtein, int targetOther, ArrayList<FoodItem> hamper){
        int currWholeGrains = 0;
        int currVeggies = 0;
        int currProtein = 0;
        int currOther = 0;
        for (int i = 0; i < hamper.size(); i++){
            currWholeGrains += (int)(hamper.get(i).getGrainContent() / 100.0 * hamper.get(i).getCalories());
            currVeggies += (int)(hamper.get(i).getFruitsVeggiesContent() / 100.0 * hamper.get(i).getCalories());
            currProtein += (int)(hamper.get(i).getProteinContent() / 100.0 * hamper.get(i).getCalories());
            currOther += (int)(hamper.get(i).getOtherNutrition() / 100.0 * hamper.get(i).getCalories());
        }
        int nutrition = -1;
        if (currWholeGrains < targetWholeGrains){
            nutrition = 0;
        }
        else if (currVeggies < targetVeggies){
            nutrition = 1;
        }
        else if (currProtein < targetProtein){
            nutrition = 2;
        }
        else{
            nutrition = 3;
        }

        int highestDifference = Integer.MIN_VALUE;
        FoodItem bestItem = null;

        for(int i = 0; i < foodItemArray.size(); i++){
            FoodItem anItem = foodItemArray.get(i);
             if(nutrition == 0){
                int difference = (targetWholeGrains - currWholeGrains) - (int)(anItem.getGrainContent() / 100.0 * anItem.getCalories());
                if (difference < 0 && difference > highestDifference) {
                    highestDifference = difference;
                    bestItem = anItem;
                }  
             }
             else if(nutrition == 1){
                int difference = (targetVeggies - currVeggies) - (int)(anItem.getFruitsVeggiesContent() / 100.0 * anItem.getCalories());
                if (difference < 0 && difference > highestDifference) {
                    highestDifference = difference;
                    bestItem = anItem;
                }
             }
             else if(nutrition == 2){
                int difference = (targetProtein - currProtein) - (int)(anItem.getProteinContent() / 100.0 * anItem.getCalories());
                if (difference < 0 && difference > highestDifference) {
                    highestDifference = difference;
                    bestItem = anItem;
                }
             }
             else if(nutrition == 3){
                int difference = (targetOther - currOther) - (int)(anItem.getOtherNutrition() / 100.0 * anItem.getCalories());
                if (difference < 0 && difference > highestDifference) {
                    highestDifference = difference;
                    bestItem = anItem;
                }
             }
         }
        hamper.add(bestItem);
        deleteItem(bestItem.getItemName());

        return hamper;
    }

    /**
     * Connect to the database using ENSF409 Convention of user:"student" and password:"ensf" from Lab F.
     * Iterates over the available food table and adds each food item into the foodItemArray.
     */
    public void fetchFromFoodDatabase(){
        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/FOOD_INVENTORY", "student", "ensf");
            Statement myStatement = dbConnect.createStatement();
            results = myStatement.executeQuery("SELECT * FROM AVAILABLE_FOOD");
            while (results.next()){
                int calories = results.getInt("Calories");
                FoodItem currFood = new FoodItem(results.getInt("ItemID"),
                                                results.getString("Name"),
                                                results.getInt("GrainContent"), 
                                                results.getInt("FVContent"), 
                                                results.getInt("ProContent"), 
                                                results.getInt("Other"), 
                                                results.getInt("Calories"));
                foodItemArray.add(currFood);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Deletes an item from the foodItemArray based by iterating over the array until
     * it finds the item based on the foodName. If it cannot find the food, throw an
     * illegal argument exception
     * @param foodName
     */
    public void deleteItem(String foodName){
        for (int i = 0; i < foodItemArray.size(); i++){
            if (foodItemArray.get(i).getItemName().equals(foodName)){
                foodItemArray.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Food Item: " + foodName + " was not found in database");
    }

    /**
     * This method returns the current foodItemArray
     * @return foodItemArray
     */
    public ArrayList<FoodItem> getFoodItemArray(){
        return this.foodItemArray;
    }

    /**
     * This method connects to the database and rewrites the AVAILABLE_FOOD table by iterating
     * over the foodItemArray and adding each item.
     */
    public void updateDatabase(){
        Statement clearDatabaseStatement;
        try {
            clearDatabaseStatement = dbConnect.createStatement();
            int executeClearDatabaseStatus = clearDatabaseStatement.executeUpdate("truncate AVAILABLE_FOOD");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (FoodItem currFoodItem : foodItemArray){
            String itemName = currFoodItem.getItemName();
            int grainContent = currFoodItem.getGrainContent();
            int fruitVeggiesContent = currFoodItem.getFruitsVeggiesContent();
            int proteinContent = currFoodItem.getProteinContent();
            int otherNutrition = currFoodItem.getOtherNutrition();
            int calories = currFoodItem.getCalories();

            try{
                Statement updateDatabaseStatement = dbConnect.createStatement();
                int executeUpdateDatabaseStatus = updateDatabaseStatement.executeUpdate("INSERT INTO AVAILABLE_FOOD(Name, GrainContent, FVContent, ProContent, Other, Calories)VALUES('"+ itemName + "', " + grainContent +", " + fruitVeggiesContent +", " + proteinContent + ", " + otherNutrition + ", " + calories + ")");
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * This method takes a String of the foodItem name and searches the foodItemArray
     * and returns the FoodItem object if the foodItem is found, else throws an exception
     * @param foodItem
     * @return FoodItem
     */
    public FoodItem getFoodItem(String foodItem){
        for (FoodItem currFood : foodItemArray){
            if (currFood.getItemName().equals(foodItem)){
                return currFood;
            }
        }
        throw new IllegalArgumentException("Food item does not exist into the database");
    }
}