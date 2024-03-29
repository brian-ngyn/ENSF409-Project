package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.ArrayList;

/**
 * NOTE: Majority of invalid hamper input is handled by the GUI. For example,
 * negative quantities are not allowed, and empty hampers are caught by the GUI,
 * so Order will only ever receive valid Hampers as input
 */
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
     * getHampers() should give all hampers that exist in the order
     */
    @Test
    public void testGetHampers(){
        ArrayList<Hamper> expectedHampers = new ArrayList<Hamper>();
        expectedHampers.add(new Hamper(1,1,1,1,1));
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
        Order order = new Order(expectedHampers);
        expectedHampers.add(new Hamper(1,2,0,0,1));
        Hamper newHamper = new Hamper(1,2,0,0,1);
        order.addHamper(newHamper);
        ArrayList<Hamper> actualHampers = order.getHampers();
        assertEquals("Method getHampers did not return expected value after adding a new hamper with addHamper(): ", expectedHampers, actualHampers);
    }
}