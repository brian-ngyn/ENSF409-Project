package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class clientTest {

    /**
     * getWholeGrains() should return the correct whole grains required for an adult amle
     */
    @Test
    public void testGetWholeGrains() {
        int clientID = 1;
        String clientType = "Adult Male";
        int expectedWholeGrains = 100;
        int expectedFruitVeggies = 50;
        int expectedProtein = 150;
        int expectedOther = 200;
        int expectedCalories = 2500;
        Client testClient = new Client(clientID, clientType, expectedWholeGrains, expectedProtein, expectedFruitVeggies,
                expectedCalories, expectedOther);
        int resultWholeGrains = testClient.getWholeGrains();
        assertEquals("Expected Whole Grains was incorrect: ", expectedWholeGrains, resultWholeGrains);
    }

    /**
     * getFruitVeggies() should return the correct fruit/veggies required for an adult amle
     */
    @Test
    public void testGetFruitVeggies() {
        int clientID = 1;
        String clientType = "Adult Male";
        int expectedWholeGrains = 100;
        int expectedFruitVeggies = 50;
        int expectedProtein = 150;
        int expectedOther = 200;
        int expectedCalories = 2500;
        Client testClient = new Client(clientID, clientType, expectedWholeGrains, expectedProtein, expectedFruitVeggies,
                expectedCalories, expectedOther);
        int resultFruitVeggies = testClient.getFruitVeggies();
        assertEquals("Expected Fruit Veggies was incorrect: ", expectedFruitVeggies, resultFruitVeggies);
    }

    /**
     * getProtein() should return the correct protein required for an adult amle
     */
    @Test
    public void testGetProtein() {
        int clientID = 1;
        String clientType = "Adult Male";
        int expectedWholeGrains = 100;
        int expectedFruitVeggies = 50;
        int expectedProtein = 150;
        int expectedOther = 200;
        int expectedCalories = 2500;
        Client testClient = new Client(clientID, clientType, expectedWholeGrains, expectedProtein, expectedFruitVeggies,
                expectedCalories, expectedOther);
        int resultProtein = testClient.getProtein();
        assertEquals("Expected Protein was incorrect: ", expectedProtein, resultProtein);
    }

    /**
     * getOther() should return the correct "other" required for an adult amle
     */
    @Test
    public void testGetOther() {
        int clientID = 1;
        String clientType = "Adult Male";
        int expectedWholeGrains = 100;
        int expectedFruitVeggies = 50;
        int expectedProtein = 150;
        int expectedOther = 200;
        int expectedCalories = 2500;
        Client testClient = new Client(clientID, clientType, expectedWholeGrains, expectedProtein, expectedFruitVeggies,
                expectedCalories, expectedOther);
        int resultOther = testClient.getOther();
        assertEquals("Expected Other was incorrect: ", expectedOther, resultOther);
    }

    /**
     * getCalories() should return the correct calories required for an adult amle
     */
    @Test
    public void testGetCalories() {
        int clientID = 1;
        String clientType = "Adult Male";
        int expectedWholeGrains = 100;
        int expectedFruitVeggies = 50;
        int expectedProtein = 150;
        int expectedOther = 200;
        int expectedCalories = 2500;
        Client testClient = new Client(clientID, clientType, expectedWholeGrains, expectedProtein, expectedFruitVeggies,
                expectedCalories, expectedOther);
        int resultCalories = testClient.getCalories();
        assertEquals("Expected Calories was incorrect: ", expectedCalories, resultCalories);
    }
}