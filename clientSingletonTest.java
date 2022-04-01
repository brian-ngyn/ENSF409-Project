package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


public class clientSingletonTest {
    Client expectedClient1 = new Client("12", "Adult Male", [100, 50, 150, 200, 2500]);
    Client expectedClient2 = new Client("12", "Adult Female", [80, 40, 110, 190, 2000]);
    Client expectedClient3 = new Client("12", "Child Under 8", [40, 20, 70, 1000, 1000]);
    Client expectedClient4 = new Client("12", "Child Over 8", [60, 30, 100, 100, 1500]);

    ArrayList<Client> expectedArrayList = new ArrayList<Client>();
    expectedArrayList.append(expectedClient1);
    expectedArrayList.append(expectedClient2);
    expectedArrayList.append(expectedClient3);
    expectedArrayList.append(expectedClient4);

    ClientSingleton clientSingleton = new ClientSingleton();


    public void testFetchClientTypes() {
        System.out.println("Test fetch client types");
        ArrayList<Client> clientList = clientSingleton.fetchClientTypes();
        assertEquals("fetchClientTypes was incorrect: ", clientList, expectedArrayList);
    }

    public void testNewClient() {
        System.out.println("Test new client");
        Client client = clientSingleton.newClient("Adult Male");
        assertEquals("newClient was incorrect: ", client, expectedClient1);
    }
}
