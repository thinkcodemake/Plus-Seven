package plusseven.diceroller.ui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import plusseven.diceroller.DiceRoller;

public class DD35DiceRoller extends DiceRollerUI{
	
	//FIELDS
	DiceRoller dice;
	
	//CONSTRUCTOR
	public DD35DiceRoller(){
		dice = new DiceRoller();
		initUI();
	}
	
	//METHODS
	/**
	 * Initializes the User Interface
	 */
	private void initUI(){
		//Window Properties
		setTitle("Dice Roller");
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Window Panel Properties
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 1, 5, 5));
		
		//Creates a separate panel for the Dice Functionality
		JPanel dicePanel = new JPanel();
		
		panel.add(dicePanel);
		
		//Creates a JTextField for the Results Output
		
	}
}
