package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests {
	public static final int expectedAdultM = 1;
	public static final int expectedAdultF = 1;
	public static final int expectedChildU8 = 1;
	public static final int expectedChildO8 = 2;
	public static final int expectedquantity = 3;
	public static final int requiredWholeGrains = 100;
	public static final int requiredFruitVeggies = 200;
	public static final int requiredProtein = 500;
	public static final int requiredOther = 700;
	public static final int requiredCalories = 5000;
	public static final int quntity = 1;
	public static final FoodItem [] foodItems = new FoodItem();
	
	public static int expectedITEMID = 10;
	public static String expectedITEMNAME = "Apples";
	public static int expectedGRAINCONTENT = 10;
	public static int expectedFIBERCONTENT = 15;
	public static int expectedPROTIENCONTENT = 20;
	public static int expectedOTHERNUTRITION = 25;
	public static int expectedCALORIES = 500;
	
	public static Hamper testHamper = new Hamper(1, 1, 2, 1, 3);
	public static FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFIBERCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
	testHamper.getFoodItems().add(foodObj);
	
	
	@Test
	public void testGetNumberOfHampers() {
		System.out.println("Test get number of hampers");
		int numOfHampers = testHamper.getNumberOfHampers();
		assertEquals("getNumberOfHampers was incorrect: ", numOfHampers, expectedquantity);
	}
	
	@Test
	public void testGetNumberOfAdultM() {
		System.out.println("Test get number of adult males");
		int numAdultM = testHamper.getNumAdultsM();
		assertEquals("getNumAdultsM was incorrect: ", numAdultM, expectedquantity);
	}
	
	@Test
	public void testGetNumberOfAdultF() {
		System.out.println("Test get number of adult females");
		int numAdultF = testHamper.getNumAdultsF();
		assertEquals("getNumAdultsF was incorrect: ", numAdultF, expectedquantity);
	}
	
	@Test
	public void testGetNumberOfChildUnder8() {
		System.out.println("Test get number of children under 8");
		int numChildU8 = testHamper.getNumChildUnder8();
		assertEquals("getNumChildUnder8 was incorrect: ", numChildU8, expectedquantity);
	}
	
	@Test
	public void testGetNumberOfChildOver8() {
		System.out.println("Test get number of children over 8");
		int numChildO8 = testHamper.getNumChildOver8();
		assertEquals("getNumChildOver8 was incorrect: ", numChildO8, expectedquantity);
	}
	
	@Test 
	public void testGetTotalWholeGrains() {
		System.out.println("Test getTotalWholeGrains");
		int actualWholeGrains = testHamper.getTotalWholeGrains();
		assertEquals("getNumChildOver8 was incorrect: ", actualWholeGrains, requiredWholeGrains);
	}
	
	@Test 
	public void testGetTotalFruitVeggies() {
		System.out.println("Test getTotalFruitVeggies");
		int actualFruitVeggies = testHamper.getTotalFruitVeggies();
		assertEquals("getNumChildOver8 was incorrect: ", actualFruitVeggies, requiredFruitVeggies);
	}
	
	@Test 
	public void testGetTotalProtein() {
		System.out.println("Test getTotalProtein");
		int actualProtein = testHamper.getTotalProtein();
		assertEquals("getNumChildOver8 was incorrect: ", actualProtein, requiredProtein);
	}
	
	@Test 
	public void testGetTotalOther() {
		System.out.println("Test getTotalOther");
		int actualOther = testHamper.getTotalOther();
		assertEquals("getNumChildOver8 was incorrect: ", actualOther, requiredOther);
	}
	
	@Test 
	public void testGetTotalCalories() {
		System.out.println("Test getTotalCalories");
		int actualCalories = testHamper.getTotalCalories();
		assertEquals("getNumChildOver8 was incorrect: ", actualCalories, requiredCalories);
	}
	
	@Test
	public void testCreateHamper() {
		System.out.println("Test create hamper");
		testHamper.createHamper();
		if (testHamper.totalWholeGrains < requiredWholeGrains || testHamper.totalFruitVeggies < requiredFruitVeggies
		|| testHamper.totalProtein < requiredProtein || testHamper.totalOther < requiredOther || testHamper.totalCalories < requiredCalories) {
			assertEquals("createHamper did not meet the requirements: ", true, false);
		}
	}
	
	@Test
	public void testGetFoodItems() {
		System.out.println("Test get food items");
		
		FoodItem [] result = testHamper.getFoodItems();
		for (int i = 0; i < foodItems.length; i++) {
			assertEquals("getFoodItems did not return the correct foodItem: ", result[i], foodItems[i]);
		}
	}
	
	@Test
	public void testValidateHamper() {
		System.out.println("Test validate hamper");
		boolean result = testHamper.validateHamper();
		assertEquals("validateHamper was incorrect: ", result, true);
	}
}