package plusseven.ui;

import javax.swing.JFrame;

/**
 * This class acts as the Super Class for all User Interfaces.  It sets up
 * the window size, with a default of 300x200.  It also sets up instructions
 * for what to do on a window closing.
 * 
 * @author James Dozier
 * @version 1.0, 9/5/12
 */
public class UserInterface extends JFrame{
	
	//Fields
	
	//Constructor
	/**
	 * Default Constructor with a default Window Size of 300x200.
	 */
	public UserInterface(){
		setUpWindow(300, 200);
	}
	
	/**
	 * An overloaded Constructor allowing for custom window sizes.
	 * 
	 * @param sizeX	Window Width
	 * @param sizeY	Window Height
	 */
	public UserInterface(int sizeX, int sizeY){
		setUpWindow(sizeX, sizeY);
	}
	
	//Methods
	/**
	 * Sets up the default Window Properties for the User Interface.
	 * 
	 * @param sizeX	Window Width
	 * @param sizeY	Window Height
	 */
	private void setUpWindow(int sizeX, int sizeY){
		//Window Properties
		setTitle("Plus Seven");
		setSize(sizeX,sizeY);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
}
