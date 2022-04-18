package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

/**
 * NOTE: Majority of invalid hamper input is handled by the GUI. For example,
 * 
 */
public class foodItemTest {
    
    /**
     * This test makes sure that getItemId() is returning the correct item ID
     */
    @Test
    public void testValidGetItemId(){
        int expectedITEMID = 10;
        String expectedITEMNAME = "Apples";
        int expectedGRAINCONTENT = 10;
        int expectedFIBERCONTENT = 15;
        int expectedPROTIENCONTENT = 20;
        int expectedOTHERNUTRITION = 25;
        int expectedCALORIES = 500;
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.getFoodItemArray().add(foodObj);
        int resultITEMID = db.getFoodItemArray().get(0).getItemID();
        assertEquals("Expected Item ID was incorrect: ", expectedITEMID, resultITEMID);
    }

    /**
     * This test makes sure that getItemName() is returning the correct item name
     */
    @Test
    public void testValidGetItemName(){
        int expectedITEMID = 10;
        String expectedITEMNAME = "Apples";
        int expectedGRAINCONTENT = 10;
        int expectedFIBERCONTENT = 15;
        int expectedPROTIENCONTENT = 20;
        int expectedOTHERNUTRITION = 25;
        int expectedCALORIES = 500;
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.getFoodItemArray().add(foodObj);
        String resultITEMNAME = db.getFoodItemArray().get(0).getItemName();
        assertEquals("Expected Item name was incorrect: ", expectedITEMNAME, resultITEMNAME);
    }

    /**
     * This test makes sure that getGrainContent() is returning the correct grain content
     */
    @Test
    public void testValidGetGrainContent(){
        int expectedITEMID = 10;
        String expectedITEMNAME = "Apples";
        int expectedGRAINCONTENT = 10;
        int expectedFIBERCONTENT = 15;
        int expectedPROTIENCONTENT = 20;
        int expectedOTHERNUTRITION = 25;
        int expectedCALORIES = 500;
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.getFoodItemArray().add(foodObj);
        int resultGRAINCONTENT = db.getFoodItemArray().get(0).getGrainContent();
        assertEquals("Expected Grain content was incorrect: ", expectedGRAINCONTENT, resultGRAINCONTENT);
    }

    /**
     * This test makes sure that getFiberContent() is returning the correct fiber content
     */
    @Test
    public void testValidGetFiberContent(){
        int expectedITEMID = 10;
        String expectedITEMNAME = "Apples";
        int expectedGRAINCONTENT = 10;
        int expectedFIBERCONTENT = 15;
        int expectedPROTIENCONTENT = 20;
        int expectedOTHERNUTRITION = 25;
        int expectedCALORIES = 500;
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.getFoodItemArray().add(foodObj);
        int resultFIBERCONTENT = db.getFoodItemArray().get(0).getFruitsVeggiesContent();
        assertEquals("Expected Fiber content was incorrect: ", expectedFIBERCONTENT, resultFIBERCONTENT);
    }

    /**
     * This test makes sure that getProteinContent() is returning the correct protein content
     */
    @Test
    public void testValidGetProteinContent(){
        int expectedITEMID = 10;
        String expectedITEMNAME = "Apples";
        int expectedGRAINCONTENT = 10;
        int expectedFIBERCONTENT = 15;
        int expectedPROTIENCONTENT = 20;
        int expectedOTHERNUTRITION = 25;
        int expectedCALORIES = 500;
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.getFoodItemArray().add(foodObj);
        int resultPROTIENCONTENT = db.getFoodItemArray().get(0).getProteinContent();
        assertEquals("Expected Protein content was incorrect: ", expectedPROTIENCONTENT, resultPROTIENCONTENT);
    }

    /**
     * This test makes sure that getOtherNutrition() is returning the correct other nutrition
     */
    @Test
    public void testValidGetOtherContent(){
        int expectedITEMID = 10;
        String expectedITEMNAME = "Apples";
        int expectedGRAINCONTENT = 10;
        int expectedFIBERCONTENT = 15;
        int expectedPROTIENCONTENT = 20;
        int expectedOTHERNUTRITION = 25;
        int expectedCALORIES = 500;
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.getFoodItemArray().add(foodObj);
        int resultOTHERNUTRITION = db.getFoodItemArray().get(0).getOtherNutrition();
        assertEquals("Exxpected Other nutrition content was incorrect: ", expectedOTHERNUTRITION, resultOTHERNUTRITION);
    }

    /**
     * This test makes sure that getCalories() is returning the correct calories
     */
    @Test
    public void testValidGetCalories(){
        int expectedITEMID = 10;
        String expectedITEMNAME = "Apples";
        int expectedGRAINCONTENT = 10;
        int expectedFIBERCONTENT = 15;
        int expectedPROTIENCONTENT = 20;
        int expectedOTHERNUTRITION = 25;
        int expectedCALORIES = 500;
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.getFoodItemArray().add(foodObj);
        int resultCALORIES = db.getFoodItemArray().get(0).getCalories();
        assertEquals("Expected Calories was incorrect: ", expectedCALORIES, resultCALORIES);
    }

    /**
     * This test creates a single food item, and adds it to the database.
     * Call getFoodItemArray() and make sure that that food item is in the food item array.
     */
    @Test
    public void testGetFoodItemArray(){
        int expectedITEMID = 10;
        String expectedITEMNAME = "Apples";
        int expectedGRAINCONTENT = 10;
        int expectedFIBERCONTENT = 15;
        int expectedPROTIENCONTENT = 20;
        int expectedOTHERNUTRITION = 25;
        int expectedCALORIES = 500;
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        ArrayList<FoodItem> expectedFoodItemArray = new ArrayList<FoodItem>();
        expectedFoodItemArray.add(foodObj);

        db.getFoodItemArray().add(foodObj);
        ArrayList<FoodItem> resultFoodItemArray = db.getFoodItemArray();
        assertEquals("Food Item array was incorrect: ", expectedFoodItemArray, resultFoodItemArray);
    }

    /**
     * This test creates a single food item, and adds it to the database.
     * Call deleteItem() to delete that food item. Check to see if the food item array is null at the first index.
     */
    @Test
    public void testDeleteItem(){
        int expectedITEMID = 10;
        String expectedITEMNAME = "Apples";
        int expectedGRAINCONTENT = 10;
        int expectedFIBERCONTENT = 15;
        int expectedPROTIENCONTENT = 20;
        int expectedOTHERNUTRITION = 25;
        int expectedCALORIES = 500;
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.getFoodItemArray().add(foodObj);
        
        db.deleteItem("Apples");
        assertEquals("Food object was not deleted from foodItemArray: ", db.getFoodItemArray().size(), 0);
    }

    /**
     * This test creates a single food item with the name "Apple" and adds it to the database.
     * Call deleteItem("Oranges"). DeleteItem() should throw an exception as Oranges does not
     * exist in the database and cannot be deleted.
     */
    public void testInvalidDeleteItem(){
        int expectedITEMID = 10;
        String expectedITEMNAME = "Apples";
        int expectedGRAINCONTENT = 10;
        int expectedFIBERCONTENT = 15;
        int expectedPROTIENCONTENT = 20;
        int expectedOTHERNUTRITION = 25;
        int expectedCALORIES = 500;
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);

        boolean passed = false;
        try {
            db.deleteItem("Oranges");
        }
        catch (IllegalArgumentException e){
            passed = true;
        }
        assertTrue("deleteItem() did not throw an error when trying to delete an item that did not exist", passed);
    }

    /**
     * This test creates a single food item with the name "Apple" and adds it to the database.
     * Call getFoodItem("Oranges"). getFoodItem() should throw an exception as Oranges does not
     * exist in the database.
     */
    public void testInvalidGetItem(){
        int expectedITEMID = 10;
        String expectedITEMNAME = "Apples";
        int expectedGRAINCONTENT = 10;
        int expectedFIBERCONTENT = 15;
        int expectedPROTIENCONTENT = 20;
        int expectedOTHERNUTRITION = 25;
        int expectedCALORIES = 500;
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);

        boolean passed = false;
        try {
            db.getFoodItem("Oranges");
        }
        catch (IllegalArgumentException e){
            passed = true;
        }
        assertTrue("getItem() did not throw an error when trying to get an item that did not exist", passed);
    }
}
