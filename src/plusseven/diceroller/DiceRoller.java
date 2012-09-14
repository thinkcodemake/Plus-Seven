package plusseven.diceroller;

import java.util.Random;

public class DiceRoller {
	
	//FIELDS
	private Random rnd = new Random();
	
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
	 * @param num	the number of dice simulated rolled
	 * @param size	the number of sides on the simulated die
	 * @return		returns an array with the results rolled
	 */
	public int[] rollDie(int num, int size){
		int[] rolls = new int[num];
		for (int i = 0; i < num; i++){
			rolls[i] = rnd.nextInt(size) + 1;
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
	
}
