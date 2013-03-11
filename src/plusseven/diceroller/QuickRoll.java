package plusseven.diceroller;

import java.util.ArrayList;

/**
 * A collection of dice to be rolled.
 * 
 * @author James Dozier
 * @version 1.0
 */
public class QuickRoll {
	
	//FIELDS
	/**
	 * The dice to be rolled.  int[] set up as:
	 * int[0] = Qty of Dice
	 * int[1] = # of Sides
	 * int[2] = Modifiers
	 */
	private ArrayList<int[]> dice;
	
	//CONSTRUCTOR
	public QuickRoll(){
		dice = new ArrayList<int[]>();
	}
	
	//METHODS
	
	public void addDie(int[] die){
		dice.add(die);
	}
	
	public int[][] getAsArray(){
		
		int[][] diceArray = new int[dice.size()][3];
		for (int i = 0; i < dice.size(); i++){
			diceArray[i] = dice.get(i);
		}
		
		return diceArray;
	}
	
	public String getDescription(){
		StringBuilder string = new StringBuilder();
		
		for(int i = 0; i < dice.size(); i++){
			string.append(dice.get(i)[0]);
			string.append("d");
			string.append(dice.get(i)[1]);
			int mod = dice.get(i)[2];
			if (mod < 0){
				string.append(mod);
			} else if (mod > 0){
				string.append("+" + mod);
			}
			if (i != dice.size() - 1){
				string.append(" + ");
			}
		}
		
		return string.toString();
	}
}
