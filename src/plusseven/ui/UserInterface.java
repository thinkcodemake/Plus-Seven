package plusseven.ui;

import javax.swing.JFrame;

public class UserInterface extends JFrame{
	
	//Fields
	
	//Constructor
	public UserInterface(){
		setUpWindow(300, 200);
	}
	
	public UserInterface(int sizeX, int sizeY){
		setUpWindow(sizeX, sizeY);
	}
	
	//Methods
	private void setUpWindow(int sizeX, int sizeY){
		//Window Properties
		setTitle("Plus Seven");
		setSize(sizeX,sizeY);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
