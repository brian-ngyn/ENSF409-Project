/*package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.sql.*;

public class FoodItemDatabase {
    private ArrayList<FoodItem> foodItemArray = new ArrayList<FoodItem>();
    private Connection dbConnect;
    private ResultSet results;

    public FoodItemDatabase(){
        fetchFromFoodDatabase();
    }

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

                    if(Math.abs((targetWholeGrains - currWholeGrains) - anItem.getGrainContent()) < lowestDifference){
                        lowestDifference = Math.abs((targetWholeGrains - currWholeGrains) - anItem.getGrainContent());
                        bestItem = anItem;
                    }
                    
                }
                else if(nutrition == 1){
                    if(Math.abs((targetProtein - currProtein) - anItem.getProteinContent()) < lowestDifference){
                        lowestDifference = Math.abs((targetProtein -currProtein) - anItem.getProteinContent());
                        bestItem = anItem;
                    }
                }
                else if(nutrition == 2){
                    if(Math.abs((targetVeggies - currVeggies) - anItem.getFruitsVeggiesContent()) < lowestDifference){
                        lowestDifference = Math.abs((targetVeggies - currVeggies) - anItem.getFruitsVeggiesContent());
                        bestItem = anItem;
                    }
                }
                else if(nutrition == 3){
                    if(Math.abs((targetOther - currOther) - anItem.getOtherNutrition()) < lowestDifference){
                        lowestDifference = Math.abs(targetOther - currOther - anItem.getOtherNutrition());
                        bestItem = anItem;
                    }
                }
            }
            hamper.add(bestItem);
            foodItemArray.remove(bestItem);
            currOther += bestItem.getOtherNutrition();
            currVeggies += bestItem.getFruitsVeggiesContent();
            currProtein += bestItem.getProteinContent();
            currWholeGrains += bestItem.getGrainContent();
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

    public ArrayList<FoodItem> addLastFoodItem(int targetWholeGrains, int targetVeggies, int targetProtein, int targetOther, ArrayList<FoodItem> hamper){
        int currWholeGrains = 0;
        int currVeggies = 0;
        int currProtein = 0;
        int currOther = 0;
        for (int i = 0; i < hamper.size(); i++){
            currWholeGrains += hamper.get(i).getGrainContent();
            currVeggies += hamper.get(i).getFruitsVeggiesContent();
            currProtein += hamper.get(i).getProteinContent();
            currOther += hamper.get(i).getOtherNutrition();
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

                int difference = (targetWholeGrains - currWholeGrains) - anItem.getGrainContent();
                if (difference < 0 && difference > highestDifference) {
                    highestDifference = difference;
                    bestItem = anItem;
                }
                 
             }
             else if(nutrition == 1){
                 int difference = (targetVeggies - currVeggies) - anItem.getFruitsVeggiesContent();
                if (difference < 0 && difference > highestDifference) {
                    highestDifference = difference;
                    bestItem = anItem;
                }
                
             }
             else if(nutrition == 2){
                int difference = (targetProtein - currProtein) - anItem.getProteinContent();
                if (difference < 0 && difference > highestDifference) {
                    highestDifference = difference;
                    bestItem = anItem;
                }
             }
             else if(nutrition == 3){
                int difference = (targetOther - currOther) - anItem.getOtherNutrition();
                if (difference < 0 && difference > highestDifference) {
                    highestDifference = difference;
                    bestItem = anItem;
                }
             }
         }
        hamper.add(bestItem);
        foodItemArray.remove(bestItem);

        return hamper;
    }

    public void fetchFromFoodDatabase(){
        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/FOOD_INVENTORY", "user1", "ensf");
            Statement myStatement = dbConnect.createStatement();
            results = myStatement.executeQuery("SELECT * FROM AVAILABLE_FOOD");
            while (results.next()){
                int calories = results.getInt("Calories");
                FoodItem currFood = new FoodItem(results.getInt("ItemID"),
                                                results.getString("Name"),
                                                 (results.getInt("GrainContent")/100.0 * calories), 
                                                 (results.getInt("FVContent")/100.0 * calories), 
                                                (int) (results.getInt("ProContent")/100.0 * calories), 
                                                (int) (results.getInt("Other")/100.0 * calories), 
                                                results.getInt("Calories"));
                foodItemArray.add(currFood);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteItem(String foodName){
        for (int i = 0; i < foodItemArray.size(); i++){
            if (foodItemArray.get(i).getItemName().equals(foodName)){
                foodItemArray.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Food Item: " + foodName + " was not found in database");
    }

    public ArrayList<FoodItem> getFoodItemArray(){
        return this.foodItemArray;
    }

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
            double grainContent = (double)currFoodItem.getGrainContent() / (double)currFoodItem.getCalories() * 100.0;
            double fruitVeggiesContent = (double)currFoodItem.getFruitsVeggiesContent() / (double)currFoodItem.getCalories() * 100.0;
            double proteinContent = (double)currFoodItem.getProteinContent() / (double)currFoodItem.getCalories() * 100.0;
            double otherNutrition = (double)currFoodItem.getOtherNutrition() / (double)currFoodItem.getCalories() * 100.0;
            int calories = currFoodItem.getCalories();

            try{
                Statement updateDatabaseStatement = dbConnect.createStatement();
                int executeUpdateDatabaseStatus = updateDatabaseStatement.executeUpdate("INSERT INTO AVAILABLE_FOOD(Name, GrainContent, FVContent, ProContent, Other, Calories)VALUES('"+ itemName + "', " + (int)grainContent +", " + (int)fruitVeggiesContent +", " + (int)proteinContent + ", " + (int)otherNutrition + ", " + calories + ")");
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void printDatabase(){
        for (FoodItem currFoodItem : foodItemArray){
            System.out.println(currFoodItem.getItemName());
            System.out.print(" " + currFoodItem.getGrainContent());
            System.out.print(" " + currFoodItem.getFruitsVeggiesContent());
            System.out.print(" " + currFoodItem.getProteinContent());
            System.out.print(" " + currFoodItem.getOtherNutrition());
            System.out.println("\n");
        }
    }

    public FoodItem getFoodItem(String foodItem){
        for (FoodItem currFood : foodItemArray){
            if (currFood.getItemName().equals(foodItem)){
                return currFood;
            }
        }
        throw new IllegalArgumentException("Food item does not exist into the database");
    }
}*/


package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.sql.*;

public class FoodItemDatabase {
    private ArrayList<FoodItem> foodItemArray = new ArrayList<FoodItem>();
    private Connection dbConnect;
    private ResultSet results;

    public FoodItemDatabase(){
        fetchFromFoodDatabase();
    }

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
            foodItemArray.remove(bestItem);
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
        foodItemArray.remove(bestItem);

        return hamper;
    }

    public void fetchFromFoodDatabase(){
        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/FOOD_INVENTORY", "user1", "ensf");
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

    public void deleteItem(String foodName){
        for (int i = 0; i < foodItemArray.size(); i++){
            if (foodItemArray.get(i).getItemName().equals(foodName)){
                foodItemArray.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Food Item: " + foodName + " was not found in database");
    }

    public ArrayList<FoodItem> getFoodItemArray(){
        return this.foodItemArray;
    }

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

    public void printDatabase(){
        for (FoodItem currFoodItem : foodItemArray){
            System.out.println(currFoodItem.getItemName());
            System.out.print(" " + currFoodItem.getGrainContent());
            System.out.print(" " + currFoodItem.getFruitsVeggiesContent());
            System.out.print(" " + currFoodItem.getProteinContent());
            System.out.print(" " + currFoodItem.getOtherNutrition());
            System.out.println("\n");
        }
    }

    public FoodItem getFoodItem(String foodItem){
        for (FoodItem currFood : foodItemArray){
            if (currFood.getItemName().equals(foodItem)){
                return currFood;
            }
        }
        throw new IllegalArgumentException("Food item does not exist into the database");
    }
}