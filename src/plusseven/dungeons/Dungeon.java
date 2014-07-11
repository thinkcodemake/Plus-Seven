package plusseven.dungeons;

import java.util.ArrayList;
import java.util.Random;

public class Dungeon {
	
	//FIELDS
	long seed;
	Random rnd;
	ArrayList<Room> rooms = new ArrayList<Room>();
	
	//CONSTRUCTORS
	public Dungeon(){
		rnd = new Random();
		this.seed = rnd.nextLong();
		rnd = new Random(seed);
		
		generateRooms();
	}
	
	public Dungeon(long seed){
		this.seed = seed;
		rnd = new Random(seed);
		
		generateRooms();
	}
	
	//METHODS
	public void generateRooms(){
		int roomCount = rnd.nextInt(11);
		
		System.out.println(roomCount);
		
		for(int i = 0; i < roomCount; i++){
			rooms.add(new Room(seed, i));
		}
	}
	
	public String getDungeonDescription(){
		StringBuilder desc = new StringBuilder();
		
		desc.append(String.format("%d room(s).\n\n", rooms.size()));
		
		for(Room room : rooms){
			desc.append(room.getDescription());
		}
		
		return desc.toString();
		
	}
}
