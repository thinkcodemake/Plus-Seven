package plusseven.ui.dicerollerui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import plusseven.diceroller.DiceRoller;

/**
 * 
 * @author James Dozier
 * @version 1.1, 9/17/12
 */
public class DD35DiceRoller extends DiceRollerUI{

	//CONSTRUCTOR
	/**
	 * Calls the DiceRollerUI with an array of all the dice used for the game.
	 */
	public DD35DiceRoller(){
		super(new int[] {20, 12, 100, 10, 8, 6, 4});
		setSize(650,300);
	}
}
