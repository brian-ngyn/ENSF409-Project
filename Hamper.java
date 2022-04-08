package edu.ucalgary.ensf409;

import java.util.ArrayList;
/**
 * 
 * @author Will Perks
 * @version 1.7
 * @since 1.0
 * 
 * Hamper is part of a bigger program that is used to create hampers for families.
 * The role of Hamper is to look at the database and pick items so that the requirements are met.
 * The requirements were given by the database.
 * 
 */
public class Hamper {
	private int numAdultsM;
	private int numAdultsF;
	private int numChildOver8;
	private int numChildUnder8;
	private int totalWholeGrains;
	private int totalFruitVeggies;
	private int totalProtein;
	private int totalOther;
	private int totalCalories;
	private int requiredWholeGrains;
	private int requiredFruiVeggies;
	private int requiredProtein;
	private int requiredOther;
	private int requiredCalories;
	private ArrayList<FoodItem> foodItems;
	private int quantity;
	
	/**
	 *  This is the constructor which takes the number of adult males and females and children over and under
	 *  as well as the number of hampers and stores these numbers.  Also, the constructor will get all the nutrition 
	 *  values and store those values with respect to the number of adults and children.
	 * @param numAdultM
	 * @param numAdultF
	 * @param numChildOver8
	 * @param numChildUnder8
	 * @param numHampers
	 */
	public Hamper(int numAdultM, int numAdultF, int numChildOver8, int numChildUnder8, int numHampers) {
		this.numAdultsM = numAdultM;
		this.numAdultsF = numAdultF;
		this.numChildOver8 = numChildOver8;
		this.numChildUnder8 = numChildOver8;
		this.quantity = numHampers;
		ArrayList<Client> clients = ClientSingleton.FetchClientTypes();
		Client male = clients.getClient("Adult Male");
		Client female = clients.getClient("Adult Female");
		Client over8 = clients.getClient("Child over 8");
		Client under8 = clients.getClient("Child under 8");
		
		requiredWholeGrains = male.getWholeGrains() * numAdultM + female.getWholeGrains() * numAdultF 
							+ over8.getWholeGrains() * numChildOver8 + under8.getWholeGrains() * numChildUnder8;
		
		requiredFruiVeggies = male.getFruitsVeggies() * numAdultM + female.getFruitsVeggies() * numAdultF
							+ over8.getFruitsVeggies() * numChildOver8 + under8.getFruitsVeggies() * numChildUnder8;
		
		requiredProtein = male.getProtein() * numAdultM + female.getProtein() * numAdultF
						+ over8.getProtein() * numChildOver8 + under8.getProtein() * numChildUnder8;
		
		requiredOther = male.getOther() * numAdultM + female.getOther() * numAdultF
						+ over8.getOther() * numChildOver8 + under8.getOther() * numChildUnder8;
		
		requiredCalories = male.getCalories() * numAdultM + female.getCalories() * numAdultF
						+ over8.getCalories() * numChildOver8 + under8.getCalories() * numChildUnder8;
	}
	
	/**
	 * createHamper will add FoodItems to the variable foodItems and ensure that all requirements are met 
	 * will making sure that each nutrition variable is not excited by a large amount 
	 */
	public void createHamper() {
		ArrayList<FoodItem> allItems = FoodItemDatabase.getFoodItemArray();
		while(!validateHamper()) {
			// whichNutrition will indicate which nutrition variable is furthest away from meeting the requirement
			// based on a percentage.  0 indicates that more whole grains is needed, 1 indicates that more
			// fruit/veggies is needed, 2 indicates that more protein is needed, 3 indicates that more other
			// is needed, and 4 indicates that more calories is needed.
			// At the start all are equally needed and since calories is the last nutrition it will always be chosen
			// first time through the while loop
			int whichNutrition = 4;
			// bestNutrition is used to select the nutrition that is furthest away from the requirement based on a percentage
			double bestNutrition = 0;
			if ((double)totalWholeGrains/requiredWholeGrains <= bestNutrition) {
				bestNutrition = totalWholeGrains/requiredWholeGrains;
				whichNutrition = 0;
			}
			if ((double)totalFruitVeggies/requiredFruiVeggies <= bestNutrition) {
				bestNutrition = totalFruitVeggies/requiredFruiVeggies;
				whichNutrition = 1;
			}
			if ((double)totalProtein/requiredProtein <= bestNutrition) {
				bestNutrition = totalProtein/requiredProtein;
				whichNutrition = 2;
			}
			if ((double)totalOther/requiredOther <= bestNutrition) {
				bestNutrition = totalOther/requiredOther;
				whichNutrition = 3;
			}
			if ((double)totalCalories/requiredCalories <= bestNutrition) {
				bestNutrition = totalCalories/requiredCalories;
				whichNutrition = 4;
			}
			if(itemsInDatabase(allItems)) {
				System.exit(1);
			}
			int bestItem = 0;
			FoodItem chosenItem;
			boolean complete = false;
			// Go through the database and find the item that has the highest amount of the needed nutrition
			for (int i = 0; i < allItems.length(); i++) {
				FoodItem anItem = allItems.get(i);
				// The below if/else if/else statements are used to select an item from the database that has the highest
				// value of nutrition.  Which item is selected is based off of the nutrition that was selected by the above code.
				if (whichNutrition == 0) {
					if (anItem.getGrainContent() > bestItem) {
						bestItem = anItem.getGrainContent();
						chosenItem = anItem;
					}
				}
				else if (whichNutrition == 1) {
					if (anItem.getFruitVeggiesContent() > bestItem) {
						bestItem = anItem.getFruitVeggiesContent();
						chosenItem = anItem;
					}
				}
				else if (whichNutrition == 2) {
					if (anItem.getProteinContent() > bestItem) {
						bestItem = anItem.getProteinContent();
						chosenItem = anItem;
					}
				}
				else if (whichNutrition == 3) {
					if (anItem.getOtherNutrition() > bestItem) {
						bestItem = anItem.getOtherNutrition();
						chosenItem = anItem;
					}
				}
				else {
					if (anItem.getCalories() > bestItem) {
						bestItem = anItem.getCalories();
						chosenItem = anItem;
					}
				}
				if (isHamperDone(anItem)) {
					foodItems.add(anItem);
					complete = true;
					break;
				}
			}
			if (complete) {
				break;
			}
			foodItems.add(chosenItem);
		}
		updateItems();
	}
	
	/**
	 * Is a helper function for createrHamper, this function checks to see if the FoodItems that have already been chosen
	 * plus the FoodItem that is currently select meet the requirements.  If so, the function returns true, false otherwise
	 * This helps the function createHamper not go above the requirements by a large amount. 
	 * @param item
	 * @return
	 */
	private boolean isHamperDone(FoodItem item) {
		int WGDone = totalWholeGrains + item.getGrainContent();
		int FVDone = totalFruitVeggies + item.getFruitVeggiesContent();
		int PDone = totalProtein + item.getProteinContent();
		int ODone = totalOther + item.getOtherNutrition();
		int CDone = totalCalories + item.getCalories();
		if(WGDone >= requiredWholeGrains && FVDone >= requiredFruiVeggies && PDone >= requiredProtein && 
			ODone >= requiredOther && CDone >= requiredCalories) {
			return true;
		}
		return false;
	}
	
	/**
	 * This function will updated the database after the hamper has been successfully created 
	 */
	private void updateItems() {
		for (int i = 0; i < foodItems.length(); i++) {
			FoodItemDatabase.deleteItem(foodItems.get(i).getItemName());
		}
	}
	
	/**
	 * This function will check the database 
	 * @return
	 */
	private boolean itemsInDatabase(ArrayList<FoodItem> allItems) {
		
	}
	
	/**
	 * This function will return true if all the requirements are less than or equal 
	 * to the current total nutrition values, false otherwise
	 * @return
	 */
	public boolean validateHamper() {
		if(totalWholeGrains >= requiredWholeGrains && totalFruitVeggies >= requiredFruiVeggies && 
		totalProtein >= requiredProtein && totalOther >= requiredOther && totalCalories >= requiredCalories) {
			return true;
		}
		return false;
	}
	
	// Getters //
	public int getNumberOfHampers() {
		return this.quantity;
	}
	public int getNumAdultsM() {
		return this.numAdultsM;
	}
	public int getNumAdultsF() {
		return this.numAdultsF;
	}
	public int getNumChildOver8() {
		return this.numChildOver8;
	}
	public int getNumChildUnder8() {
		return this.numChildUnder8;
	}
	public int getTotalWholeGrains() {
		return this.totalWholeGrains;
	}
	public int getTotalFruiVeggies() {
		return this.totalFruitVeggies;
	}
	public int getTotalProtein() {
		return this.totalProtein;
	}
	public int getTotalOther() {
		return this.totalOther;
	}
	public int getTotalCalories() {
		return this.totalCalories;
	}
	public FoodItem [] getFoodItems() {
		return this.foodItems;
	}
}
