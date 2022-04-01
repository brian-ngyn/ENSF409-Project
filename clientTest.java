package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class clientTest {
    public static final int expectedWholeGrains = 100;
    public static final int expectedFruitVeggies = 50;
    public static final int expectedProtein = 150;
    public static final int expectedOther = 200;
    public static final int expectedCalories = 2500;
    public static Client testClient = new Client("12", "Adult Male", [100, 50, 150, 200, 2500]);

    @Test
    public void testGetWholeGrains() {
        System.out.println("Test get whole grains");
        int wholeGrains = testClient.getWholeGrains();
        assertEquals("getWholeGrains was incorrect: ", wholeGrains, expectedWholeGrains);
    }

    @Test
    public void testGetFruitVeggies() {
        System.out.println("Test get fruit veggies");
        int fruitVeggies = testClient.getFruitVeggies();
        assertEquals("getFruitVeggies was incorrect: ", fruitVeggies, expectedFruitVeggies);
    }

    @Test
    public void testGetProtein() {
        System.out.println("Test get protein");
        int protein = testClient.getProtein();
        assertEquals("getProtein was incorrect: ", protein, expectedProtein);
    }

    @Test
    public void testGetOther() {
        System.out.println("Test get other");
        int other = testClient.getOther();
        assertEquals("getOther was incorrect: ", other, expectedOther);
    }

    @Test
    public void testGetCalories() {
        System.out.println("Test get calories");
        int calories = testClient.getCalories();
        assertEquals("getCalories was incorrect: ", calories, expectedCalories);
    }
}
