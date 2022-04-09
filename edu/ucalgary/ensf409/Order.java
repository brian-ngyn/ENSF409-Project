package edu.ucalgary.ensf409;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Order implements PrintOutput{
    private ArrayList<Hamper> hampers;
    private ArrayList<String> hamperOutputs;
    
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
     * print out an error message, otherwise, output the order form 
     */
    public boolean validateOrder(){
        boolean valid = true;
        for (Hamper hamper: hampers){
            if (!hamper.validateHamper()){
                valid = false;
                return valid;
            }
        }
        if (valid){
            printOrderForm();
            return valid;
        } else {
            System.out.println("Invalid hamper configuration. Please try again.");
            return valid;
        }
    }

    /**
     * Prints out the order form for a successful order. Includes a title, and summary and item details for each hamper.
     */
    public void printOrderForm(){
        try {
            FileWriter writer = new FileWriter("filename.txt");
            writer.write("Group 14 Food Bank\n");
            writer.write("Hamper Order Form\n");
            writer.write("=================================\n");
            writer.write("\n");
            writer.write("Original Request:\n");
            // Write hamper summary to file
            for (int i = 0; i < hampers.size(); i++){
                writer.write("Hamper " + i + "\n");
                writer.write("--------------------\n");
                if (hampers.get(i).getNumAdultsM() > 0){
                    writer.write(hampers.get(i).getNumAdultsM() + " Adult Males\n");
                }
                if (hampers.get(i).getNumAdultsF() > 0){
                    writer.write(hampers.get(i).getNumAdultsF() + " Adult Females\n");
                }
                if (hampers.get(i).getNumChildUnder8() > 0){
                    writer.write(hampers.get(i).getNumChildUnder8() + " Children Under 8\n");
                }
                if (hampers.get(i).getNumChildOver8() > 0){
                    writer.write(hampers.get(i).getNumChildOver8() + " Children Over 8\n");
                }
                writer.write("\n");
            }
            // Write hamper details to file
            for (int i = 0; i < hampers.size(); i++){
                writer.write("Hamper " + i + " items:\n");
                FoodItem[] foodItems = hampers.get(i).getFoodItems();
                for (FoodItem foodItem : foodItems){
                    writer.write(String.format("%-15f %s\n", foodItem.getItemID(), foodItem.getItemName()));
                }
                writer.write("\n");
            }
            writer.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
    }
}