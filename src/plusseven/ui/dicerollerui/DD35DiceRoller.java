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

public class DD35DiceRoller extends DiceRollerUI{
	
	//FIELDS
	private static final int NUM_OF_DICE = 7;
	private int[] dieTypes = {20, 12, 100, 10, 8, 6, 4};
	
	private JCheckBox[] checkBoxes = new JCheckBox[NUM_OF_DICE];
	private JSpinner[] qtySpinners = new JSpinner[NUM_OF_DICE];
	private JSpinner[] modSpinners = new JSpinner[NUM_OF_DICE];
	private JButton[] rollButtons = new JButton[NUM_OF_DICE];
	private JButton multiRollButton = new JButton("Multi");
	
	//CONSTRUCTOR
	public DD35DiceRoller(){
		setSize(650,300);
		addComponents();
	}
	
	//METHODS
	/**
	 * Adds components specific to D&D 3.5
	 */
	public void addComponents(){
		
		JPanel dicePanel = new JPanel();
		dicePanel.setLayout(new GridLayout(0, 5, 5, 5));
		add(dicePanel, BorderLayout.CENTER);
		
		//Setup Components
		JLabel[] labels = new JLabel[5];
		labels[0] = new JLabel("Multi");
		labels[1] = new JLabel("Qty");
		labels[2] = new JLabel("Die");
		labels[3] = new JLabel("Mod");
		labels[4] = new JLabel("Roll");
		
		JLabel[] dieNames = new JLabel[NUM_OF_DICE];
		dieNames[0] = new JLabel("d20");
		dieNames[1] = new JLabel("d12");
		dieNames[2] = new JLabel("d100");
		dieNames[3] = new JLabel("d10");
		dieNames[4] = new JLabel("d8");
		dieNames[5] = new JLabel("d6");
		dieNames[6] = new JLabel("d4");
		
		for (int i = 0; i < NUM_OF_DICE; i++){
			checkBoxes[i] = new JCheckBox();
			qtySpinners[i] = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
			modSpinners[i] = new JSpinner(new SpinnerNumberModel(0, -100, 100, 1));
			rollButtons[i] = new JButton("Roll");
		}

		
		//Setup Buttons
		rollButtons[0].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[][] rollDice = new int[1][3];
				rollDice[0][0] = (Integer) qtySpinners[0].getValue();
				rollDice[0][1] = 20;
				rollDice[0][2] = (Integer) modSpinners[0].getValue();
				results.append(dice.rollAsString(rollDice));
			}			
			
		});
		
		rollButtons[1].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[][] rollDice = new int[1][3];
				rollDice[0][0] = (Integer) qtySpinners[1].getValue();
				rollDice[0][1] = 12;
				rollDice[0][2] = (Integer) modSpinners[1].getValue();
				results.append(dice.rollAsString(rollDice));
			}			
			
		});
		
		rollButtons[2].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[][] rollDice = new int[1][3];
				rollDice[0][0] = (Integer) qtySpinners[2].getValue();
				rollDice[0][1] = 100;
				rollDice[0][2] = (Integer) modSpinners[2].getValue();
				results.append(dice.rollAsString(rollDice));
			}			
			
		});
		
		rollButtons[3].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[][] rollDice = new int[1][3];
				rollDice[0][0] = (Integer) qtySpinners[3].getValue();
				rollDice[0][1] = 10;
				rollDice[0][2] = (Integer) modSpinners[3].getValue();
				results.append(dice.rollAsString(rollDice));
			}			
			
		});
		
		rollButtons[4].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[][] rollDice = new int[1][3];
				rollDice[0][0] = (Integer) qtySpinners[4].getValue();
				rollDice[0][1] = 8;
				rollDice[0][2] = (Integer) modSpinners[4].getValue();
				results.append(dice.rollAsString(rollDice));
			}			
			
		});
		
		rollButtons[5].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[][] rollDice = new int[1][3];
				rollDice[0][0] = (Integer) qtySpinners[5].getValue();
				rollDice[0][1] = 6;
				rollDice[0][2] = (Integer) modSpinners[5].getValue();
				results.append(dice.rollAsString(rollDice));
			}			
			
		});
		
		rollButtons[6].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[][] rollDice = new int[1][3];
				rollDice[0][0] = (Integer) qtySpinners[6].getValue();
				rollDice[0][1] = 4;
				rollDice[0][2] = (Integer) modSpinners[6].getValue();
				results.append(dice.rollAsString(rollDice));
			}			
			
		});
		
		multiRollButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ArrayList<int[]> diceToRoll = new ArrayList<int[]>();
				for (int i = 0; i < NUM_OF_DICE; i++){
					if (checkBoxes[i].isSelected()){
						int[] die = {(Integer) qtySpinners[i].getValue(), dieTypes[i], (Integer) modSpinners[i].getValue()};
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
		
		for (int i = 0; i < NUM_OF_DICE; i++){
			dicePanel.add(checkBoxes[i]);
			dicePanel.add(qtySpinners[i]);
			dicePanel.add(dieNames[i]);
			dicePanel.add(modSpinners[i]);
			dicePanel.add(rollButtons[i]);
		}
		
		for (int i = 0; i < 4; i++){
			dicePanel.add(new JLabel(""));
		}
		
		dicePanel.add(multiRollButton);
		
	}
}
