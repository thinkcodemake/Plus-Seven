package plusseven;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import plusseven.dungeons.DungeonGenerator;
import plusseven.ui.UserInterface;
import plusseven.ui.dicerollerui.DD35DiceRoller;
import plusseven.ui.dicerollerui.DiceRollerUI;

/**
 * The Main User Interface
 * 
 * @author James Dozier
 * @version 1.0,9/1/12
 */
public class PlusSeven extends UserInterface{
	
	//FIELDS
	JComboBox gameType;
	
	DungeonGenerator dgen;
	DiceRollerUI roller;
	
	//CONSTRUCTOR
	public PlusSeven(){
		initUI();
	}
	
	//METHODS
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PlusSeven cw = new PlusSeven();
                cw.setVisible(true);
            }
        });
	}
	
	/**
	 * Setup for additional User Interface features.
	 */
	public final void initUI(){
		//Overwrite User Interface's Default.  This now closes the whole program.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Menu Bar Setup
		JMenuBar mainMenu = new JMenuBar();
		
		setJMenuBar(mainMenu);
		
		//Panel Setup
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		panel.setLayout(new GridLayout(4, 1, 5, 5));
		
		//Adding Drop Down Box for GameType
		String[] gameNames = {"D&D 3.5"};
		gameType = new JComboBox(gameNames);
		panel.add(gameType);
		
		//Adding Character Window Launcher Button
		JButton character = new JButton("Character Window");
		
		character.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		panel.add(character);
		
		//Adding Dice Roller Window Launcher Button
		JButton diceRoller = new JButton("Dice Roller");
		
		diceRoller.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				roller = new DD35DiceRoller();
				roller.setVisible(true);
			}
			
		});
		
		panel.add(diceRoller);
		
		//Adding Random Dungeon Room Window Launcher Button
		JButton randDungRoom = new JButton("Random Dungeon Room Generator");
		
		randDungRoom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dgen = new DungeonGenerator((String) gameType.getSelectedItem());
				dgen.setVisible(true);
			}
			
		});
		
		panel.add(randDungRoom);
	}
}
