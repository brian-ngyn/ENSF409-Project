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

    public void fetchFromFoodDatabase(){
        try {
            foodItemArray.clear();
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/FOOD_INVENTORY", "user1", "ensf");
            Statement myStatement = dbConnect.createStatement();
            results = myStatement.executeQuery("SELECT * FROM AVAILABLE_FOOD");
            while (results.next()){
                FoodItem currFood = new FoodItem(results.getInt("ItemID"), results.getString("Name"), results.getInt("GrainContent"), results.getInt("FVContent"), results.getInt("ProContent"), results.getInt("Other"), results.getInt("Calories"));
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
        throw new IllegalArgumentException("Food Item " + foodName + " was not found in database");
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