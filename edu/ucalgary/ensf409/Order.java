package edu.ucalgary.ensf409;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Order implements PrintOutput{
    private ArrayList<Hamper> hampers;
    
    /**
     * Initialize a new Order with a list of hampers
     * @param hamperArray
     */
    public Order(ArrayList<Hamper> hamperArray){
        this.hampers = hamperArray;
    }

    /**
     * Getter method for hampers stored in order
     * @return hampers
     */
    public ArrayList<Hamper> getHampers(){
        return this.hampers;
    }

    /**
     * Add a new hamper to existing order
     * @param hamper
     */
    public void addHamper(Hamper hamper){
        this.hampers.add(hamper);
    }

    /**
     * Verify that all hampers in order can be built. If a hamper cannot be built,
     * return it's error code, otherwise, output order form
     */
    public int validateOrder(){
        for (Hamper hamper: hampers){
            if (!hamper.validateHamper()){
                return hamper.getError();
            }
        }
        printOrderForm();
        return 1;
    }

    public String getHamperForm(){
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < hampers.size(); i++){
            returnString.append("Hamper " + (i+1) + " Items:\n");
            ArrayList<FoodItem> foodItems = hampers.get(i).getFoodItems();
            for (FoodItem foodItem : foodItems){
                returnString.append(foodItem.getItemID() + "\t\t" + foodItem.getItemName() + "\n");
            }
            returnString.append("\n\n");
            }
        return returnString.toString();
    }

    /**
     * Prints out the order form for a successful order. Includes a title, and summary and item details for each hamper.
     */
    public void printOrderForm(){
        try {
            FileWriter writer = new FileWriter("OrderForm.txt");
            writer.write("Group 14 Food Bank\n");
            writer.write("Hamper Order Form\n");
            writer.write("\n");
            writer.write("Name:\n");
            writer.write("Date: " + "\n\n");
            writer.write("Original Request\n");
            // Write hamper summary to file
            for (int i = 0; i < hampers.size(); i++){
                writer.write("Hamper " + (i+1) + ": ");
                StringBuilder requestToWrite = new StringBuilder();
                if (hampers.get(i).getNumAdultsM() > 0){
                    requestToWrite.append(hampers.get(i).getNumAdultsM() + " Adult Male, ");
                }
                if (hampers.get(i).getNumAdultsF() > 0){
                    requestToWrite.append(hampers.get(i).getNumAdultsF() + " Adult Female, ");
                }
                if (hampers.get(i).getNumChildOver8() > 0){
                    requestToWrite.append(hampers.get(i).getNumChildOver8() + " Children Over 8, ");
                }
                if (hampers.get(i).getNumChildUnder8() > 0){
                    requestToWrite.append(hampers.get(i).getNumChildUnder8() + " Children Under 8, ");
                }
                writer.write(requestToWrite.substring(0, requestToWrite.length()-2));
                writer.write("\n");
            }
            writer.write("\n");
            // Write hamper details to file
            for (int i = 0; i < hampers.size(); i++){
                writer.write("Hamper " + (i+1) + " Items:\n");
                ArrayList<FoodItem> foodItems = hampers.get(i).getFoodItems();
                for (FoodItem foodItem : foodItems){
                    writer.write(foodItem.getItemID() + "\t\t" + foodItem.getItemName() + "\n");
                }
                writer.write("\n\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}