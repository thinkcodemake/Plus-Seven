package plusseven.ui.dicerollerui;

/**
 * 
 * @author James Dozier
 * @version 1.1, 9/17/12
 */
@SuppressWarnings("serial")
public class PathfinderDiceRoller extends DiceRollerUI{

	//CONSTRUCTOR
	/**
	 * Calls the DiceRollerUI with an array of all the dice used for the game.
	 */
	public PathfinderDiceRoller(){
		super(new int[] {20, 12, 100, 10, 8, 6, 4});
	}
}
