import edu.ucalgary.ensf409;
import edu.ucalgary.ensf409.Order;

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
     * validOrder() should return false given an empty Hamper ArrayList
     */
    @Test
    public void testEmptyHamperArrayList(){
        Order order = new Order(new ArrayList<Hamper>());
        assertEquals("Method validateOrder() did not return false when Order was initialized with an empty ArrayList", order.validateOrder(), false);
    }
}