import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @author Porter Youngman
 * Java Assignment GrapeVineContinuation - Product.java
 * Apr 28, 2022
 */

public class Product {
	private String productName = "product";
	private String[] productOptions;
	private int[] cost;
	private double tax = 0.06;
	private double orderTotal = 0;
	
	ArrayList<Integer> userChoice = new ArrayList<Integer>();
	ArrayList<String> altUserChoice = new ArrayList<String>(); // for finished option in GrapeVine
	ArrayList<Integer> userChoiceCost = new ArrayList<Integer>();
	ArrayList<Double> userChoiceTax = new ArrayList<Double>();
	
	public Product (String name, String[] item, int[] price) {
		productName = name;
		productOptions = item;
		cost = price;
	}
	public String getName() {
		return productName;
	}
	public int getCost(int item) {
		return cost[item];
	}
	public String getOptions(int item) {
		return productOptions[item];
	}
	public void promptUser(String storeName, boolean altChoice) {
		JOptionPane.showMessageDialog(null, "Welcome to "+ storeName + "!\nClick Ok To Begin " + productName + " Selection");
		String input = "";
		String itemCostDisplay = "Options:\n";
		for (int x=0; x<productOptions.length; x++) {
			itemCostDisplay += ("\n" + (x+1) + ": " + productOptions[x] + ": $" + String.format("%,d", cost[x]) + " + sales tax");
		}
		while (true) {
			input = JOptionPane.showInputDialog("Choose an option:\n" + itemCostDisplay);
			
			// if the 'x' is pressed or cancel is pressed (exits)
			if (input==null) {
				break; // Ends the loop
			}
			// avoids errors when user enters non numerical value or if out of bounds:
			try {
				if ((Integer.parseInt(input)>=1)&&(Integer.parseInt(input)<=productOptions.length)) {
					userChoice.add(Integer.parseInt(input)); // If the user enters an invalid option then will default to 1
				}
				else
					throw new java.lang.RuntimeException("Out of bounds"); // will go to catch if out of value range
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "You entered an invalid option, defaulted to Pine");
				userChoice.add(1);
			}
			// Adds the cost of the item to an array 
			if (JOptionPane.showConfirmDialog(null, "Would you like the wood finished?", "Confirm Finished", JOptionPane.YES_NO_OPTION) == 0) {
				altUserChoice.add("Yes");
				userChoiceCost.add(cost[userChoice.get(userChoice.size()-1)-1]+285);
			}else {
				altUserChoice.add("No");
				userChoiceCost.add(cost[userChoice.get(userChoice.size()-1)-1]);
			}
			// Adds the cost and tax of the item to an array 
			userChoiceTax.add((Math.round(((tax)*userChoiceCost.get(userChoiceCost.size()-1))*100.0)/100.0));
			orderTotal += userChoiceCost.get(userChoiceCost.size()-1) + userChoiceTax.get(userChoiceTax.size()-1);
			// Asks the user whether or not they want to go to checkout(breaks the loop), or add another item(continues loop).
			if (JOptionPane.showConfirmDialog(null, "Your Order: $" + String.format("%,.2f", orderTotal) + "\nAdd Another Table?\nChoose \"No\" to Proceed to Checkout", "Confirm Checkout", JOptionPane.YES_NO_OPTION) == 1) {
				//checkout = true;
				break;
			}
		}
	}
	public String toSting() {
		return productName + "s:\n";
	}
}
