package plusseven.diceroller;

import java.util.Random;

public class DiceRoller {
	
	//FIELDS
	private Random rnd = new Random();
	private int rollNum = 1;
	
	//CONSTRUCTOR
	
	//METHODS
	/**
	 * This simulates rolling a die with the size as the number of sides.
	 * 
	 * @param size	the number of sides on the simulated die
	 * @return		returns the result of the roll
	 */
	public int rollDie(int size){
		return rnd.nextInt(size) + 1;
	}
	
	/**
	 * Returns a int[] of num amount of dice, each with size number of sides
	 * 
	 * @param int[] dice This represents an assortment of dice.  
	 * 		Roll Information:
	 * 		[0] - Qty
	 * 		[1] - # Sides of Die
	 * 		[2] - Modifier *Unused in this method
	 * @return		returns an array with the results rolled
	 */
	public int[] rollDice(int[] dice){
		
		int[] rolls = new int[dice[0]];
		for (int i = 0; i < dice[0]; i++){
			rolls[i] = rnd.nextInt(dice[1]) + 1;
		}
		return rolls;
	}
	
	/**
	 * This method returns the total of all the results in rolls
	 * 
	 * @param rolls	an array of results from dice rolls
	 * @return		the total of results from the rolls
	 */
	public int getTotal(int[] rolls){
		int t = 0;
		for (int i = 0; i < rolls.length; i++){
			t += rolls[i];
		}
		return t;
	}
	
	/**
	 * This creates a summary of the dice rolls to print out to the Results TextArea
	 * 
	 * @param dice	An array of dice sets.  The first array represents a set of die.
	 * 				The second is the appropriate values for the dice.  Qty, sides, & modifier.
	 * @return		Returns a String that's a summary of the rolls.
	 */
	public String rollAsString(int[][] dice){
		StringBuilder roll = new StringBuilder();
		
		//Add the Roll #
		roll.append("Roll Number: " + rollNum++ + "\n");
		
		//Add the Roll Description
		for (int i = 0; i < dice.length; i++){
			roll.append(dice[i][0] + "d" + dice[i][1] + (dice[i][2] == 0 ? "" : (dice[i][2] < 0 ? "" : "+")) + (dice[i][2] != 0 ? dice[i][2] : ""));
			
			if (i != dice.length - 1){
				roll.append(" + ");
			} else {
				roll.append("\n");
			}
		}
		
		//Total Initialization
		int total = 0;
		
		//Results Breakdown Line
		roll.append("(");
		for (int i = 0; i < dice.length; i++){
			roll.append("d" + dice[i][1] + ": ");
			int[] results = rollDice(dice[i]);
			for (int j = 0; j < results.length; j++){
				total += results[j];
				roll.append(results[j]);
				if (j != results.length - 1){
					roll.append(", ");
				} else {
					roll.append(" ");
				}
			}
			
		}
		roll.append(")\n");
		
		//Add all the modifiers to the total
		for (int i = 0; i < dice.length; i++){
			total += dice[i][2];
		}
		
		//Print the total
		roll.append("Total: " + total + "\n");
		
		//Add Extra Line Break
		roll.append("\n");
		
		//Returns the String
		return roll.toString();
	}
	
	/**
	 * Resets the Roll Counter.
	 */
	public void resetCount(){
		rollNum = 1;
	}
}
