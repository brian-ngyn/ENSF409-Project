package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.sql.*;

public class FoodItemDatabase {
    private ArrayList<FoodItem> foodItemArray = new ArrayList<FoodItem>();
    private Connection dbConnect;
    private ResultSet results;

    public FoodItemDatabase(){

    }

    public void fetchFromFoodDatabase(){
        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/FOOD_INVENTORY", "user1", "ensf");
            Statement myStatement = dbConnect.createStatement();
            results = myStatement.executeQuery("SELECT * FROM AVILABLE_FOOD");
            while (results.next()){
                FoodItem currFood = new FoodItem(results.getInt("ItemID"), results.getString("Name"), results.getInt("GrainContent"), results.getInt("FVContent"), results.getInt("ProContent"), results.getInt("Other"), results.getInt("Calories"));
                foodItemArray.add(currFood);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteItem(FoodItem food){
        for (int i = 0; i < foodItemArray.size(); i++){
            if (foodItemArray.get(i).getItemName() == food.getItemName()){
                foodItemArray.remove(i);
            }
        }
    }

    public ArrayList<FoodItem> getFoodItemArray(){
        return this.foodItemArray;
    }

    public void updateDatabase(){
        Statement clearDatabaseStatement = dbConnect.createStatement();
        int executeClearDatabaseStatus = clearDatabaseStatement.executeUpdate("truncate AVAILABLE_FOOD");
        if (executeClearDatabaseStatus != 1){
            throw new Exception("Unable to clear database");
        }

        for (FoodItem currFoodItem : foodItemArray){
            String itemName = currFoodItem.getItemName();
            int grainContent = currFoodItem.getGrainContent();
            int fruitVeggiesContent = currFoodItem.getFruitsVeggiesContent();
            int proteinContent = currFoodItem.getProteinContent();
            int otherNutrition = currFoodItem.getOtherNutrition();
            int calories = currFoodItem.getCalories();

            Statement updateDatabaseStatement = dbConnect.createStatement();
            int executeUpdateDatabaseStatus = updateDatabaseStatement.executeUpdate("INSERT INTO AVAILABLE_FOOD(Name, GrainContent, FVContent, ProContent, Other, Calories)VALUES('"+ itemName + "', " + grainContent +", " + fruitVeggiesContent +", " + proteinContent + ", " + otherNutrition + ", " + calories + ")");
            if (executeUpdateDatabaseStatus != 1){
                throw new Exception("Unable to add " + itemName + "into the database");
            }
        }
    }
}
