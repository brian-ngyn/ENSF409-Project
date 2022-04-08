import edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class foodTest {
    int expectedITEMID = 10;
    String expectedITEMNAME = "Apples";
    int expectedGRAINCONTENT = 10;
    int expectedFIBERCONTENT = 15;
    int expectedPROTIENCONTENT = 20;
    int expectedOTHERNUTRITION = 25;
    int expectedCALORIES = 500;

    @Test
    public void testGetItemId(){
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.foodItemArray.add(foodObj);
        int resultITEMID = db.FoodItemArray.get(0).getItemId();
        assertEquals("Expected Item ID was incorrect: ", expectedITEMID, resultITEMID);
    }

    @Test
    public void testGetItemName(){
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.foodItemArray.add(foodObj);
        int resultITEMNAME = db.FoodItemArray.get(0).getItemName();
        assertEquals("Expected Item name was incorrect: ", expectedITEMNAME, resultITEMNAME);
    }

    @Test
    public void testGetGrainContent(){
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.foodItemArray.add(foodObj);
        int resultGRAINCONTENT = db.FoodItemArray.get(0).getGrainContent();
        assertEquals("Expected Grain content was incorrect: ", expectedGRAINCONTENT, resultGRAINCONTENT);
    }

    @Test
    public void testGetFiberContent(){
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.foodItemArray.add(foodObj);
        int resultFIBERCONTENT = db.FoodItemArray.get(0).getFiberContent();
        assertEquals("Expected Fiber content was incorrect: ", expectedFIBERCONTENT, resultFIBERCONTENT);
    }

    @Test
    public void testGetProteinContent(){
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.foodItemArray.add(foodObj);
        int resultPROTIENCONTENT = db.FoodItemArray.get(0).getProteinContent();
        assertEquals("Expected Protein content was incorrect: ", expectedPROTIENCONTENT, resultPROTIENCONTENT);
    }

    @Test
    public void testGetOtherContent(){
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.foodItemArray.add(foodObj);
        int resultOTHERNUTRITION = db.FoodItemArray.get(0).getOtherNutrition();
        assertEquals("Exxpected Other nutrition content was incorrect: ", expectedOTHERNUTRITION, resultOTHERNUTRITION);
    }

    @Test
    public void testGetCalories(){
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.foodItemArray.add(foodObj);
        int resultCALORIES = db.FoodItemArray.get(0).getCalories();
        assertEquals("Expected Calories was incorrect: ", expectedCALORIES, resultCALORIES);
    }

    @Test
    public void testGetFoodItemArray(){
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        ArrayList<FoodItem> expectedFoodItemArray = new ArrayList<FoodItem>();
        expectedFoodItemArray.add(foodObj);

        db.foodItemArray.add(foodObj);
        ArrayList<FoodItem> resultFoodItemArray = db.getFoodItemArray();
        assertEquals("Food Item array was incorrect: ", expectedFoodItemArray, resultFoodItemArray);
    }
    
    @Test
    public void testDeleteItem(){
        FoodItemDatabase db = new FoodItemDatabase();
        FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
        db.foodItemArray.add(foodObj);
        
        db.delete(0);
        assertEquals("Food object was not deleted from foodItemArray: ", db.foodItemArray.get(0), null);
    }
}
