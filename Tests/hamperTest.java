package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

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
	public static final FoodItem [] foodItems = new FoodItem();
	
	public static int expectedITEMID = 10;
	public static String expectedITEMNAME = "Apples";
	public static int expectedGRAINCONTENT = 10;
	public static int expectedFRUITVEGGIESCONTENT = 15;
	public static int expectedPROTIENCONTENT = 20;
	public static int expectedOTHERNUTRITION = 25;
	public static int expectedCALORIES = 500;
	
	public static Hamper testHamper = new Hamper(1, 1, 2, 1, 3);
	public static FoodItem foodObj = new FoodItem(expectedITEMID, expectedITEMNAME, expectedGRAINCONTENT, expectedFRUITVEGGIESCONTENT, expectedPROTIENCONTENT, expectedOTHERNUTRITION, expectedCALORIES);
	testHamper.getFoodItems().add(foodObj);
	
	/*
	 * This test makes sure that Hamper returns the correct number of hampers which is 3
	 */
	@Test
	public void testGetNumberOfHampers() {
		System.out.println("Test get number of hampers");
		int numOfHampers = testHamper.getNumberOfHampers();
		assertEquals("getNumberOfHampers was incorrect: ", numOfHampers, expectedquantity);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct number of Adult Males which is 1
	 */
	@Test
	public void testGetNumberOfAdultM() {
		System.out.println("Test get number of adult males");
		int numAdultM = testHamper.getNumAdultsM();
		assertEquals("getNumAdultsM was incorrect: ", numAdultM, expectedquantity);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct number of Adult Females which is 1
	 */
	@Test
	public void testGetNumberOfAdultF() {
		System.out.println("Test get number of adult females");
		int numAdultF = testHamper.getNumAdultsF();
		assertEquals("getNumAdultsF was incorrect: ", numAdultF, expectedquantity);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct number of children under 8 which is 1
	 */
	@Test
	public void testGetNumberOfChildUnder8() {
		System.out.println("Test get number of children under 8");
		int numChildU8 = testHamper.getNumChildUnder8();
		assertEquals("getNumChildUnder8 was incorrect: ", numChildU8, expectedquantity);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct number of children over 8 which is 2
	 */
	@Test
	public void testGetNumberOfChildOver8() {
		System.out.println("Test get number of children over 8");
		int numChildO8 = testHamper.getNumChildOver8();
		assertEquals("getNumChildOver8 was incorrect: ", numChildO8, expectedquantity);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct total whole grain which is 100
	 */
	@Test 
	public void testGetTotalWholeGrains() {
		System.out.println("Test getTotalWholeGrains");
		int actualWholeGrains = testHamper.getTotalWholeGrains();
		assertEquals("getNumChildOver8 was incorrect: ", actualWholeGrains, requiredWholeGrains);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct total fruit/veggies which is 200
	 */
	@Test 
	public void testGetTotalFruitVeggies() {
		System.out.println("Test getTotalFruitVeggies");
		int actualFruitVeggies = testHamper.getTotalFruitVeggies();
		assertEquals("getNumChildOver8 was incorrect: ", actualFruitVeggies, requiredFruitVeggies);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct total protein which is 500
	 */
	@Test 
	public void testGetTotalProtein() {
		System.out.println("Test getTotalProtein");
		int actualProtein = testHamper.getTotalProtein();
		assertEquals("getNumChildOver8 was incorrect: ", actualProtein, requiredProtein);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct total other which is 700
	 */
	@Test 
	public void testGetTotalOther() {
		System.out.println("Test getTotalOther");
		int actualOther = testHamper.getTotalOther();
		assertEquals("getNumChildOver8 was incorrect: ", actualOther, requiredOther);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct number of calories which is 5000
	 */
	@Test 
	public void testGetTotalCalories() {
		System.out.println("Test getTotalCalories");
		int actualCalories = testHamper.getTotalCalories();
		assertEquals("getNumChildOver8 was incorrect: ", actualCalories, requiredCalories);
	}
	
	/*
	 * This test makes sure that createHamper adds enough items to meet the requirements which it should meet
	 */
	@Test
	public void testCreateHamper() {
		System.out.println("Test create hamper");
		testHamper.createHamper();
		if (testHamper.getTotalWholeGrains() < requiredWholeGrains || testHamper.getTotalFruitVeggies() < requiredFruitVeggies
		|| testHamper.getTotalProtein() < requiredProtein || testHamper.getTotalOther() < requiredOther || testHamper.getTotalCalories() < requiredCalories) {
			assertEquals("createHamper did not meet the requirements: ", true, false);
		}
	}
	
	/*
	 * This test makes sure that Hamper throws an IllegalArgumentException when it is passed invalid input
	 */
	@Test 
	public void testHamperThrowsIllegalArgumentException() {
		System.out.println("Test Hamper throws IllegalArgumentException");
		boolean exceptionThrown = false;
		try {
			Hamper badHamper = new Hamper(-1, 0, 1, 2, 1);
		}
		catch (IllegalArgumentException e) {
			exceptionThrown = true;
		}
		assertTrue("Hamper did not throw an exception when given invalid input", exceptionThrown);
	}
	
	/*
	 * This test makes sure that getFoddItems returns the expected FoodItems
	 */
	@Test
	public void testGetFoodItems() {
		System.out.println("Test get food items");
		ArrayList<FoodItem> result = testHamper.getFoodItems();
		for (int i = 0; i < foodItems.length; i++) {
			assertEquals("getFoodItems did not return the correct foodItem: ", result.get(i), foodItems[i]);
		}
	}
	
	/*
	 * This test makes sure that ValidateHamper returns the correct value when the hamper is not done/valid
	 */
	@Test
	public void testValidateHamperInvalid() {
		System.out.println("Test invalid validate hamper");
		Hamper validHamper = new Hamper(0, 0, 0, 0, 1);
		validHamper.createHamper();
		boolean result = validHamper.validateHamper();
		assertEquals("validateHamper returned an incorrect value: ", result, false);
	}
	
	/*
	 * This test makes sure that Validate Hamper returns the correct value when the hamper is done
	 */
	@Test
	public void testValidateHamperValid() {
		System.out.println("Test valid validate hamper");
		Hamper validHamper = new Hamper(1, 0, 0, 1, 1);
		validHamper.createHamper();
		boolean result = validHamper.validateHamper();
		assertEquals("validateHamper returned an incorrect value: ", result, true);
	}
}


