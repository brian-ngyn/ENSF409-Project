import edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.ArrayList;

public class orderTest {
    @Test testOrderConstructor(){
        ArrayList<Hamper> hampers = new ArrayList<Hamper>();
        hampers.add(new Hamper(1,1,1,1,1));
        Order order = new Order(hampers);
        assertNotNull("Order constructor did not create an object when given a valid hamper array: ", order);
    }
    @Test
    public void testGetHampers(){
        ArrayList<Hamper> expectedHampers = new ArrayList<Hamper>();
        hampers.add(new Hamper(1,1,1,1,1));
        Order order = new Order(expectedHampers);
        ArrayList<Hamper> actualHampers = order.getHampers();
        assertEquals("Method getHampers did not return expected value: ", expectedHampers, actualHampers);
    }

    @Test
    public void testAddHamper(){
        ArrayList<Hamper> expectedHampers = new ArrayList<Hamper>();
        expectedHampers.add(new Hamper(1,1,0,0,1));
        expectedHampers.add(new Hamper(1,2,0,0,1));
        Order order = new Order(expectedHampers.get(0));
        Hamper newHamper = new Hamper(1,2,0,0,1);
        order.addHamper(newHamper);
        ArrayList<Hamper> actualHampers = order.getHampers();
        assertEquals("Method getHampers did not return expected value after adding a new hamper with addHamper(): ", expectedHampers, actualHampers);
    }
}