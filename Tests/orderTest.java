import edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.ArrayList;

public class orderTest {
    /**
     * The constructor should create a valid Order object given a valid Hamper ArrayList
     */
    @Test
    public void testValidOrderConstructor(){
        ArrayList<Hamper> hampers = new ArrayList<Hamper>();
        hampers.add(new Hamper(1,1,1,1,1));
        Order order = new Order(hampers);
        assertNotNull("Order constructor did not create an object when given a valid hamper array: ", order);
    }
    /**
     * The constructor should throw an IllegalArgumentException given an empty hamper
     */
    @Test
    public void testInvalidEmptyHamperOrderConstructor(){
        ArrayList<Hamper> hampers = new ArrayList<Hamper>();
        hampers.add(new Hamper(0,0,0,0,1));
        boolean error = false;
        try {
            Order order = new Order(hampers);
        } cactch(IllegalArgumentException e){
            error = true;
        }
        assertTrue("Order constructor did not catch an IllegalArgumentException given an ArrayList with an empty Hamper: ", error);
    }
    /**
     * The constructor should throw an IllegalArgumentException given a hamper with negative values
     */
    @Test
    public void testInvalidNegativeHamperOrderConstructor(){
        ArrayList<Hamper> hampers = new ArrayList<Hamper>();
        hampers.add(new Hamper(-2,1,0,1,1));
        boolean error = false;
        try {
            Order order = new Order(hampers);
        } cactch(IllegalArgumentException e){
            error = true;
        }
        assertTrue("Order constructor did not catch an IllegalArgumentException given an ArrayList with a Hamper containing negative values: ", error);
    }
    /**
     * The constructor should throw an IllegalArgumentException given a hamper with a quantity of 0
     */
    @Test
    public void testInvalidZeroQuantityHamperOrderConstructor(){
        ArrayList<Hamper> hampers = new ArrayList<Hamper>();
        hampers.add(new Hamper(2,1,0,1,0));
        boolean error = false;
        try {
            Order order = new Order(hampers);
        } cactch(IllegalArgumentException e){
            error = true;
        }
        assertTrue("Order constructor did not catch an IllegalArgumentException given an ArrayList with a Hamper with a quantity of 0: ", error);
    }
    /**
     * The constructor should throw an IllegalArgumentException given a hamper with a negative quantity
     */
    @Test
    public void testInvalidNegativeQuantityHamperOrderConstructor(){
        ArrayList<Hamper> hampers = new ArrayList<Hamper>();
        hampers.add(new Hamper(2,1,0,1,-2));
        boolean error = false;
        try {
            Order order = new Order(hampers);
        } cactch(IllegalArgumentException e){
            error = true;
        }
        assertTrue("Order constructor did not catch an IllegalArgumentException given an ArrayList with a Hamper containing a negative quantity: ", error);
    }
    /**
     * getHampers() should give all hampers that exist in the order
     */
    @Test
    public void testGetHampers(){
        ArrayList<Hamper> expectedHampers = new ArrayList<Hamper>();
        hampers.add(new Hamper(1,1,1,1,1));
        Order order = new Order(expectedHampers);
        ArrayList<Hamper> actualHampers = order.getHampers();
        assertEquals("Method getHampers did not return expected value: ", expectedHampers, actualHampers);
    }
    /**
     * addHamper() should add a Hamper to the hampers ArrayList given a valid Hamper object
     */
    @Test
    public void testValidAddHamper(){
        ArrayList<Hamper> expectedHampers = new ArrayList<Hamper>();
        expectedHampers.add(new Hamper(1,1,0,0,1));
        expectedHampers.add(new Hamper(1,2,0,0,1));
        Order order = new Order(expectedHampers.get(0));
        Hamper newHamper = new Hamper(1,2,0,0,1);
        order.addHamper(newHamper);
        ArrayList<Hamper> actualHampers = order.getHampers();
        assertEquals("Method getHampers did not return expected value after adding a new hamper with addHamper(): ", expectedHampers, actualHampers);
    }
    /**
     * addHamper() should throw an IllegalArgumentException given an empty Hamper
     */
    @Test
    public void testInvalidEmptyAddHamper(){
        ArrayList<Hamper> expectedHampers = new ArrayList<Hamper>();
        Order order = new Order(expectedHampers.get(0));
        boolean error = false;
        Hamper newHamper = new Hamper(0,0,0,0,2);
        try {
            order.addHamper(newHamper);
        } cacth(IllegalArgumentException e){
            error = true;
        }
        assertTrue("addHamper() did not throw an IllegalArgumentException given an invalid empty hamper", error);
    }
    /**
     * addHamper() should throw an IllegalArgumentException given a hamper with negative vallues
     */
    @Test
    public void testInvalidNegativeAddHamper(){
        ArrayList<Hamper> expectedHampers = new ArrayList<Hamper>();
        Order order = new Order(expectedHampers.get(0));
        boolean error = false;
        Hamper newHamper = new Hamper(0,-1,0,2,1);
        try {
            order.addHamper(newHamper);
        } cacth(IllegalArgumentException e){
            error = true;
        }
        assertTrue("addHamper() did not throw an IllegalArgumentException given an invalid hamper with negative values", error);
    }
    /**
     * addHamper() should throw an IllegalArgumentException given a hamper with a negative quantity
     */
    @Test
    public void testInvalidNegativeQuantityAddHamper(){
        ArrayList<Hamper> expectedHampers = new ArrayList<Hamper>();
        Order order = new Order(expectedHampers.get(0));
        boolean error = false;
        Hamper newHamper = new Hamper(0,1,0,2,-2);
        try {
            order.addHamper(newHamper);
        } cacth(IllegalArgumentException e){
            error = true;
        }
        assertTrue("addHamper() did not throw an IllegalArgumentException given an invalid hamper with a negative quantitiy", error);
    }
    /**
     * addHamper() should throw an IllegalArgumentException given a hamper with a quantity of 0
     */
    @Test
    public void testInvalidZeroQuantityAddHamper(){
        ArrayList<Hamper> expectedHampers = new ArrayList<Hamper>();
        Order order = new Order(expectedHampers.get(0));
        boolean error = false;
        Hamper newHamper = new Hamper(0,1,0,2,0);
        try {
            order.addHamper(newHamper);
        } cacth(IllegalArgumentException e){
            error = true;
        }
        assertTrue("addHamper() did not throw an IllegalArgumentException given an invalid hamper with a quantitiy of 0", error);
    }
}