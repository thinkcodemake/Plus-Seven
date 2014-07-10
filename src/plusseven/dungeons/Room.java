package plusseven.dungeons;

import java.util.Random;

public class Room {

	//FIELDS
	Random rnd;
	StringBuilder description = new StringBuilder();
	int roomNum;
	
	//CONSTRUCTOR
	public Room(long seed, int roomNum){
		rnd = new Random(seed);
		this.roomNum = roomNum;
		generateRoom();
	}
	
	//METHODS
	private void generateRoom(){
		description.append("Generated Room.\n\n");
	}
	
	public String getDescription(){
		return description.toString();
	}
}
