import java.sql.*;
import java.util.HashMap;

public class ClientSingleton {

    HashMap<String, Client> clients = new HashMap<String, Client>();

    public ClientSingleton() {
        fetchClientsFromDatabase();
    }

    private void fetchClientsFromDatabase() {
        Connection dbConnect;
        ResultSet results;
        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/FOOD_INVENTORY", "user1", "ensf");
            Statement myStatement = dbConnect.createStatement();
            results = myStatement.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS");
            while (results.next()){
                Client client = new Client(results.getInt("ClientID"), results.getString("Client"), results.getInt("WholeGrains"), results.getInt("FruitVeggies"), results.getInt("Protein"), results.getInt("Other"), results.getInt("Calories"));
                clients.put(results.getString("Client"), client);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Client getClient(String clientType) {
        return clients.get(clientType);
    }


}
