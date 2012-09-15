package plusseven.ui.dicerollerui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import plusseven.diceroller.DiceRoller;
import plusseven.ui.UserInterface;

/**
 * Super type for all DiceRollerUI's.
 * 
 * @author James Dozier
 * @version 1.0, 9/5/12
 */
public class DiceRollerUI extends UserInterface{
	
	//FIELDS
	JTextArea results = new JTextArea(1, 20);
	DiceRoller dice;

	//CONSTRUCTOR
	public DiceRollerUI(){
		dice = new DiceRoller();
		initUI();
	}
	
	//METHODS
	/**
	 * Initializes the Default User Interface for all DiceRollers.
	 * Sets up the results Text Area.
	 */
	private void initUI(){
		//Window Properties
		setTitle("Dice Roller");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Set up JPanel
		JPanel resultsPanel = new JPanel();
		resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
		
		//Dice Results Text Field
		results.setEditable(false);
		results.setLineWrap(true);
		JScrollPane resultsPane = new JScrollPane(results);
		resultsPanel.add(resultsPane);
		
		//Button to clear the results field
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				results.setText("");
				dice.resetCount();
			}
			
		});
		resultsPanel.add(clear);
		
		//Add the Results Panel to the Frame
		add(resultsPanel, BorderLayout.LINE_END);
	}
	
	
}
