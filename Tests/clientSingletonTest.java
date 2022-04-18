package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


public class clientSingletonTest {

    /**
     * test a valid client type in the newClient function
     */
    @Test
    public void testValidNewClient() {
        int clientID = 1;
        String clientType = "Adult Male";
        int expectedWholeGrains = 16;
        int expectedFruitVeggies = 28;
        int expectedProtein = 26;
        int expectedOther = 30;
        int expectedCalories = 2500;
        Client expectedClient = new Client(clientID, expectedClientType, expectedWholeGrains, expectedProtein, expectedFruitVeggies,
                expectedCalories, expectedOther);
        ClientSingleton clientSingleton = new ClientSingleton();

        Client resultClient = clientSingleton.newClient("Adult Male");
        String resultClientType = resultClient.getClientType();
        String expectedClientType = expectedClient.getClientType();
        assertEquals("Expected Client type was incorrect: ", expectedClientType, resultClientType);
    }

     /**
     * test an invalid client type in the newClient function
     */
    @Test
    public void testInvalidNewClient() {
        ClientSingleton clientSingleton = new ClientSingleton();
        String clientType = "Senior Citizen";
        
        boolean passed = false;
        try {
            clientSingleton.newClient(clientType);
        }
        catch (IllegalArgumentException e){
            passed = true;
        }
        assertTrue("newClient() did not throw an error when trying to get a client type that does not exist", passed);
    }
}
