package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class hamperTest {
	/*
	 * This test makes sure that Hamper returns the correct number of hampers which is 3
	 */
	@Test
	public void testGetNumberOfHampers() {
		int expectedquantity = 3;
		
		Hamper testHamper = new Hamper(1, 1, 2, 1, 3);
		int numOfHampers = testHamper.getNumberOfHampers();
		assertEquals("getNumberOfHampers was incorrect: ", numOfHampers, expectedquantity);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct number of Adult Males which is 1
	 */
	@Test
	public void testGetNumberOfAdultM() {
		int expectedAdultM = 1;
		
		Hamper testHamper = new Hamper(1, 1, 2, 1, 3);
		int numAdultM = testHamper.getNumAdultsM();
		assertEquals("getNumAdultsM was incorrect: ", numAdultM, expectedAdultM);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct number of Adult Females which is 1
	 */
	@Test
	public void testGetNumberOfAdultF() {
		int expectedAdultF = 1;
		
		Hamper testHamper = new Hamper(1, 1, 2, 1, 3);
		int numAdultF = testHamper.getNumAdultsF();
		assertEquals("getNumAdultsF was incorrect: ", numAdultF, expectedAdultF);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct number of children under 8 which is 1
	 */
	@Test
	public void testGetNumberOfChildUnder8() {
		int expectedChildU8 = 1;
		
		Hamper testHamper = new Hamper(1, 1, 2, 1, 3);
		int numChildU8 = testHamper.getNumChildUnder8();
		assertEquals("getNumChildUnder8 was incorrect: ", numChildU8, expectedChildU8);
	}
	
	/*
	 * This test makes sure that Hamper returns the correct number of children over 8 which is 2
	 */
	@Test
	public void testGetNumberOfChildOver8() {
		int expectedChildO8 = 2;
		
		Hamper testHamper = new Hamper(1, 1, 2, 1, 3);
		int numChildO8 = testHamper.getNumChildOver8();
		assertEquals("getNumChildOver8 was incorrect: ", numChildO8, expectedChildO8);
	}
	
	/*
	 * This test makes sure that Hamper throws an IllegalArgumentException when it is passed invalid input
	 */
	@Test 
	public void testHamperThrowsIllegalArgumentException() {
		boolean exceptionThrown = false;
		try {
			Hamper badHamper = new Hamper(-1, 0, 1, 2, 1);
		}
		catch (IllegalArgumentException e) {
			exceptionThrown = true;
		}
		assertTrue("Hamper did not throw an exception when given invalid input", exceptionThrown);
	}
}


