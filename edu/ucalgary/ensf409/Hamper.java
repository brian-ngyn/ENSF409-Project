package edu.ucalgary.ensf409;

import java.util.ArrayList;
/**
 * 
 * @author Will Perks
 * @version 1.7
 * @since 1.0
 * 
 * Hamper is part of a bigger program that is used to create hampers for families.
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
	private int requiredFruitVeggies;
	private int requiredProtein;
	private int requiredOther;
	private int requiredCalories;
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
	private int quantity;
	private FoodItemDatabase db;
	
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
		if(numAdultM < 0 || numAdultF < 0 || numChildOver8 < 0 || numChildUnder8 < 0 || numHampers < 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		this.numAdultsM = numAdultM;
		this.numAdultsF = numAdultF;
		this.numChildOver8 = numChildOver8;
		this.numChildUnder8 = numChildUnder8;
		this.quantity = numHampers;
		ClientSingleton clients = new ClientSingleton();
		Client male = clients.getClient("Adult Male");
		Client female = clients.getClient("Adult Female");
		Client over8 = clients.getClient("Child over 8");
		Client under8 = clients.getClient("Child under 8");
		
		requiredWholeGrains = (int)((male.getWholeGrains() * numAdultM / 100.0 * male.getCalories()) + 
								(female.getWholeGrains() * numAdultF / 100.0 * female.getCalories()) +
								(over8.getWholeGrains() * numChildOver8 / 100.0 * over8.getCalories()) + 
								(under8.getWholeGrains() * numChildUnder8 / 100.0 * under8.getCalories())) * numHampers;
		
		requiredFruitVeggies = (int)((male.getFruitVeggies() * numAdultM / 100.0 * male.getCalories()) + 
								(female.getFruitVeggies() * numAdultF / 100.0 * female.getCalories()) +
								(over8.getFruitVeggies() * numChildOver8 / 100.0 * over8.getCalories()) + 
								(under8.getFruitVeggies() * numChildUnder8 / 100.0 * under8.getCalories())) * numHampers;
		
		requiredProtein = (int)((male.getProtein() * numAdultM / 100.0 * male.getCalories()) + 
							(female.getProtein() * numAdultF / 100.0 * female.getCalories()) +
							(over8.getProtein() * numChildOver8 / 100.0 * over8.getCalories()) + 
							(under8.getProtein() * numChildUnder8 / 100.0 * under8.getCalories())) * numHampers;
		
		requiredOther = (int)((male.getOther() * numAdultM / 100.0 * male.getCalories()) + 
							(female.getOther() * numAdultF / 100.0 * female.getCalories()) +
							(over8.getOther() * numChildOver8 / 100.0 * over8.getCalories()) + 
							(under8.getOther() * numChildUnder8 / 100.0 * under8.getCalories())) * numHampers;

		requiredCalories = (male.getCalories() * numAdultM + female.getCalories() * numAdultF
						+ over8.getCalories() * numChildOver8 + under8.getCalories() * numChildUnder8) * numHampers;
	}
	
	/**
	 * createHamper will call generateFoodItems from FoodItemDatabase which will add FoodItems to the hamper
	 */
	public void createHamper() {
		foodItems = db.generateFoodItems(requiredWholeGrains, requiredFruitVeggies, requiredProtein, requiredOther);
		if (foodItems.isEmpty()){
			return;
		}
		for (FoodItem currFoodItem : foodItems){
			if (currFoodItem == null){
				return;
			}
			totalWholeGrains += (int)(currFoodItem.getGrainContent() / 100.0 * currFoodItem.getCalories());
			totalFruitVeggies += (int)(currFoodItem.getFruitsVeggiesContent() / 100.0 * currFoodItem.getCalories());
			totalProtein += (int)(currFoodItem.getProteinContent() / 100.0 * currFoodItem.getCalories());
			totalOther += (int)(currFoodItem.getOtherNutrition() / 100.0 * currFoodItem.getCalories());
			totalCalories += (int)(currFoodItem.getCalories() / 100.0 * currFoodItem.getCalories());
		}
	}

	/**
	 * This function will verify that the hamper is not empty, and will return true if all the requirements are less than or equal 
	 * to the current total nutrition values, false otherwise
	 * @return
	 */
	public boolean validateHamper() {
		if (numAdultsM == 0 && numAdultsF == 0 && numChildOver8 == 0 && numChildUnder8 == 0){
			return false;
		} else {
			db = new FoodItemDatabase();
			db.fetchFromFoodDatabase();
			createHamper();
			if(totalWholeGrains >= requiredWholeGrains && totalFruitVeggies >= requiredFruitVeggies && 
			totalProtein >= requiredProtein && totalOther >= requiredOther && totalCalories >= requiredCalories) {
				db.updateDatabase();
				return true;
			}
			return false;
		}
	}

	public int getError(){
		if(!(totalWholeGrains >= requiredWholeGrains)){
			return -1;
		}
		if (!(totalFruitVeggies >= requiredFruitVeggies)){
			return -2;
		} 
		if (!(totalProtein >= requiredProtein)){
			return -3;
		}
		if (!(totalOther >= requiredOther)){
			return -4;
		}
		return 1;
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
	public int getTotalFruitVeggies() {
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
	public ArrayList<FoodItem> getFoodItems() {
		return this.foodItems;
	}
}
