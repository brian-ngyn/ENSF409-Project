import edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class foodTest {
    
    /**
     * Check getItemId()
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
        db.foodItemArray.add(foodObj);
        int resultITEMID = db.FoodItemArray.get(0).getItemId();
        assertEquals("Expected Item ID was incorrect: ", expectedITEMID, resultITEMID);
    }

    /**
     * Test getItemName()
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
        db.foodItemArray.add(foodObj);
        int resultITEMNAME = db.FoodItemArray.get(0).getItemName();
        assertEquals("Expected Item name was incorrect: ", expectedITEMNAME, resultITEMNAME);
    }

    /**
     * Check getGrainContent()
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
        db.foodItemArray.add(foodObj);
        int resultGRAINCONTENT = db.FoodItemArray.get(0).getGrainContent();
        assertEquals("Expected Grain content was incorrect: ", expectedGRAINCONTENT, resultGRAINCONTENT);
    }

    /**
     * Test getFiberContent()
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
        db.foodItemArray.add(foodObj);
        int resultFIBERCONTENT = db.FoodItemArray.get(0).getFiberContent();
        assertEquals("Expected Fiber content was incorrect: ", expectedFIBERCONTENT, resultFIBERCONTENT);
    }

    /**
     * Test getProteinContent()
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
        db.foodItemArray.add(foodObj);
        int resultPROTIENCONTENT = db.FoodItemArray.get(0).getProteinContent();
        assertEquals("Expected Protein content was incorrect: ", expectedPROTIENCONTENT, resultPROTIENCONTENT);
    }

    /**
     * Test getOtherNutrition()
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
        db.foodItemArray.add(foodObj);
        int resultOTHERNUTRITION = db.FoodItemArray.get(0).getOtherNutrition();
        assertEquals("Exxpected Other nutrition content was incorrect: ", expectedOTHERNUTRITION, resultOTHERNUTRITION);
    }

    /**
     * test getCalories()
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
        db.foodItemArray.add(foodObj);
        int resultCALORIES = db.FoodItemArray.get(0).getCalories();
        assertEquals("Expected Calories was incorrect: ", expectedCALORIES, resultCALORIES);
    }

    /**
     * test getFoodItemArray()
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

        db.foodItemArray.add(foodObj);
        ArrayList<FoodItem> resultFoodItemArray = db.getFoodItemArray();
        assertEquals("Food Item array was incorrect: ", expectedFoodItemArray, resultFoodItemArray);
    }

    /**
     * Test deleteItem()
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
        db.foodItemArray.add(foodObj);
        
        db.delete(0);
        assertEquals("Food object was not deleted from foodItemArray: ", db.foodItemArray.get(0), null);
    }

    /**
     * Test deleting a food item that is not in the database 
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
            db.getItem("Oranges");
        }
        catch (IllegalArgumentException e){
            passed = true;
        }
        assertTrue("getItem() did not throw an error when trying to get an item that did not exist", passed);
    }
}
