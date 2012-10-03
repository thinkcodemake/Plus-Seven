package plusseven.ui.dicerollerui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import plusseven.diceroller.DiceRoller;
import plusseven.ui.UserInterface;

/**
 * Super type for all DiceRollerUI's.
 * 
 * @author James Dozier
 * @version 1.1, 9/17/12
 */
public class DiceRollerUI extends UserInterface{
	
	//FIELDS
	DiceRoller dice;
	
	private static final int NUM_QUICK_ROLLS = 4;
	private static final int BORDER_THICKNESS = 1;
	private static final Color LINE_COLOR = Color.gray;
	//Dice Fields
	private int[] diceTypes;
	private JCheckBox[] checkBoxes;
	private JSpinner[] qtySpinners;
	private JSpinner[] modSpinners;
	private JButton[] rollButtons;
	private JButton multiRollButton = new JButton("Multi");
	private JLabel[] quickLabels;
	
	//Results Fields
	JTextArea results = new JTextArea(1, 20);

	//CONSTRUCTOR
	public DiceRollerUI(int[] types){
		// 0 - 1 for 1st Quick Roll, 2 - 3 for 2nd, etc.
		quickLabels = new JLabel[NUM_QUICK_ROLLS * 2];
		diceTypes = types;
		dice = new DiceRoller();
		checkBoxes = new JCheckBox[diceTypes.length];
		qtySpinners = new JSpinner[diceTypes.length];
		modSpinners = new JSpinner[diceTypes.length];
		rollButtons = new JButton[diceTypes.length];
		multiRollButton = new JButton("Multi");
		initUI();
	}
	
	//METHODS
	/**
	 * Initializes the Default User Interface for all DiceRollers.
	 */
	private void initUI(){
		//Window Properties
		setTitle("Dice Roller");
		setLocationRelativeTo(null);
		setSize(650,400);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		initDice();
		initResults();
		initQuickRolls();
	}
	
	/**
	 * Initializes the Dice Information Panel
	 */
	public void initDice(){
		
		//Setup Dice Panel
		JPanel dicePanel = new JPanel();
		dicePanel.setBorder(BorderFactory.createLineBorder(LINE_COLOR, BORDER_THICKNESS));
		dicePanel.setLayout(new GridLayout(0, 5, 5, 5));
		add(dicePanel, BorderLayout.CENTER);
		
		//Setup Top Labels
		JLabel[] labels = new JLabel[5];
		labels[0] = new JLabel("Multi");
		labels[1] = new JLabel("Qty");
		labels[2] = new JLabel("Die");
		labels[3] = new JLabel("Mod");
		labels[4] = new JLabel("Roll");
		
		//Setup Dice Labels
		JLabel[] dieNames = new JLabel[diceTypes.length];
		for (int i = 0; i < diceTypes.length; i++){
			dieNames[i] = new JLabel("d" + diceTypes[i]);
		}
		
		//Initialize Components
		for (int i = 0; i < diceTypes.length; i++){
			checkBoxes[i] = new JCheckBox();
			qtySpinners[i] = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
			modSpinners[i] = new JSpinner(new SpinnerNumberModel(0, -100, 100, 1));
			rollButtons[i] = new JButton("Roll");
		}

		//Setup Buttons
		for (int i = 0; i < diceTypes.length; i++){
			rollButtons[i].addActionListener(getButtonListener(diceTypes[i]));
		}
		
		//Setup MulitRollButton
		multiRollButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<int[]> diceToRoll = new ArrayList<int[]>();
				for (int i = 0; i < diceTypes.length; i++){
					if (checkBoxes[i].isSelected()){
						int[] die = {(Integer) qtySpinners[i].getValue(), diceTypes[i], (Integer) modSpinners[i].getValue()};
						diceToRoll.add(die);
					}
				}
				int[][] toRoll = new int[diceToRoll.size()][3];
				for (int i = 0; i < diceToRoll.size(); i++){
					for (int j = 0; j < 3; j++){
						toRoll[i][j] = diceToRoll.get(i)[j];
					}
				}
				results.append(dice.rollAsString(toRoll));
			}
			
		});
		
		//Add Components
		for (int i = 0; i < labels.length; i++){
			dicePanel.add(labels[i]);
		}
		
		for (int i = 0; i < diceTypes.length; i++){
			dicePanel.add(checkBoxes[i]);
			dicePanel.add(qtySpinners[i]);
			dicePanel.add(dieNames[i]);
			dicePanel.add(modSpinners[i]);
			dicePanel.add(rollButtons[i]);
		}
		
		//Fill in blanks
		for (int i = 0; i < 7 - diceTypes.length; i++){
			for (int j = 0; j < 5; j++){
				dicePanel.add(new JLabel(""));
			}
		}
		
		for (int i = 0; i < 4; i++){
			dicePanel.add(new JLabel(""));
		}
		
		dicePanel.add(multiRollButton);
		
	}
	
	/**
	 * Gets an ActionListener based on the die size;
	 * 
	 * @param dieSize	The number of sides on the die rolled with the button.
	 * @return			An ActionListener for the "Roll" Button for a die.
	 */
	private ActionListener getButtonListener(final int dieSize){
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[][] rollDice = new int[1][3];
				//Number of Dice Rolled
				rollDice[0][0] = (Integer) qtySpinners[0].getValue();
				//Number of Sides on the Dice Rolled
				rollDice[0][1] = dieSize;
				//Modifier added to the Dice Total
				rollDice[0][2] = (Integer) modSpinners[0].getValue();
				results.append(dice.rollAsString(rollDice));
			}			
			
		};
	}
	
	/**
	 * Sets up the Results panel
	 */
	private void initResults(){
		//Set up Results JPanel
		JPanel resultsPanel = new JPanel();
		resultsPanel.setBorder(BorderFactory.createLineBorder(LINE_COLOR, BORDER_THICKNESS));
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
	
	/**
	 * Sets up the Quick Roll Panel
	 */
	private void initQuickRolls(){
		JPanel quickPanel = new JPanel(new GridBagLayout());
		quickPanel.setBorder(BorderFactory.createLineBorder(LINE_COLOR, BORDER_THICKNESS));
		add(quickPanel, BorderLayout.SOUTH);
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 0.5;
		c.weighty = 0.5;
		
		JLabel label = new JLabel("Description");
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		quickPanel.add(label, c);
		
		label = new JLabel("Dice Roll");
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 2;
		quickPanel.add(label, c);
		
		for (int i = 0; i < NUM_QUICK_ROLLS; i++){
			label = new JLabel(new Integer(i + 1).toString());
			c.gridx = 0;
			c.gridy = i + 1;
			quickPanel.add(label, c);
			
			quickLabels[2 * i] = new JLabel("Quick Roll One");
			c.gridx = 1;
			c.gridy = i + 1;
			c.gridwidth = 2;
			quickPanel.add(quickLabels[2 * i], c);
			
			quickLabels[(2 * i) + 1] = new JLabel("Quick Roll One Breakdown");
			c.gridx = 3;
			c.gridy = i + 1;
			c.gridwidth = 2;
			quickPanel.add(quickLabels[(2 * i) + 1], c);
			
			JButton button = new JButton("Quick Roll");
			c.gridx = 5;
			c.gridy = i + 1;
			quickPanel.add(button, c);
			
		}
		
	}
	
	private class QuickRoll{
		
	}
	
}
