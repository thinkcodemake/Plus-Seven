package plusseven.dungeons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import plusseven.ui.UserInterface;

@SuppressWarnings("serial")
public class DungeonGenerator extends UserInterface{
	
	//FIELDS
	DD35Dungeon dungeon;
	
	JTextArea room = new JTextArea();
	JScrollPane scroll = new JScrollPane(room);
	JSpinner spin;
	JSpinner loadSeed;
	JMenu file;
	
	//CONSTRUCTOR
	public DungeonGenerator(String str) {
		super(400, 600);
		if (str == "Pathfinder"){
			initUI();
		}
	}
	
	//METHODS
	private void initUI(){
		
		//Panel Setup
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		//Menu Setup
		JMenuBar menubar = new JMenuBar();
		
		file = new JMenu("Load Seed");
		menubar.add(file);
		
		JLabel loadSeedL = new JLabel("Enter Seed");
		file.add(loadSeedL);
		
		long min = -9223372036854775808L;
		long max = 9223372036854775807L;
		
		SpinnerModel seedModel = new SpinnerNumberModel((Long) 0L,(Long) min,(Long) max, (Long) 1L);
		loadSeed = new JSpinner(seedModel);
		file.add(loadSeed);
		
		JButton loadRoom = new JButton("Load Seed");
		loadRoom.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dungeon = new DD35Dungeon((Integer)spin.getValue(), (Long)loadSeed.getValue());
				room.setText(dungeon.getRoom());
				file.setPopupMenuVisible(false);
			}
			
		});
		
		file.add(loadRoom);
		
		setJMenuBar(menubar);
		
		//CR Level Label
		JLabel spinL = new JLabel("CR Level");
		spinL.setBounds(10, 0, 60, 20);
		
		panel.add(spinL);
		
		//Level Spinner
		SpinnerModel model = new SpinnerNumberModel(1, 1, 20, 1);
		spin = new JSpinner(model);
		spin.setBounds(10, 20, 60, 20);
		
		panel.add(spin);
		
		//Randomizer Button
		JButton button = new JButton("Generate Room");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dungeon = new DD35Dungeon((Integer) spin.getValue());
				room.setText(dungeon.getRoom());
			}
			
		});
		button.setBounds(100, 0, 200, 50);
		panel.add(button);
		
		//Adding the Text Jazz
		room.setLineWrap(true);
		room.setWrapStyleWord(true);
		scroll.setBounds(0, 50, 400, 500);
		panel.add(scroll);
	}
}
