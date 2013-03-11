package plusseven.dungeons;

import java.util.Random;

public class DD35Dungeon {
	
	//FIELDS	
	long seed;
	Random rnd;
	StringBuilder room;
	
	//CONSTRUCTOR
	public DD35Dungeon(int level){
		Random r = new Random();
		seed = r.nextLong();
		rnd = new Random(seed);
		room = new StringBuilder();		
		generateDungeon(level);
	}
	
	//Finished
	public DD35Dungeon(int level, long seed) {
		this.seed = seed;
		rnd = new Random(seed);
		room = new StringBuilder();
		generateDungeon(level);
	}
	
	//METHODS
	//Finished
	private void generateDungeon(final int level){
		room.append("Dungeon Room Seed: " + seed+ "\n\n");
		
		int test = rollDie(1, 100);
		
		if (1 <= test && test <= 18){
			addMonsters(level);
		} else if (19 <= test && test <= 44){
			addFeatures();
			addMonsters(level);
		} else if (test == 45){
			addMonsters(level);
			addTreasures(level);
		} else if (test == 46){
			addMonsters(level);
			addTreasures(level);
		} else if (test == 47){
			addFeatures();
			addMonsters(level);
			addTreasures(level);
		} else if (test == 48){
			addFeatures();
			addMonsters(level);
			addTraps(level);
		} else if (test == 49){
			addMonsters(level);
			addTraps(level);
			addTreasures(level);
		} else if (test == 50){
			addFeatures();
			addMonsters(level);
			addTraps(level);
			addTreasures(level);
		} else if (51 <= test && test <= 76){
			addFeatures();
		} else if (test == 77){
			addFeatures();
			addTreasures(level);
		} else if (test == 78){
			addFeatures();
			addTraps(level);
		} else if (test == 79){
			addFeatures();
			addTraps(level);
			addTreasures(level);
		} else if (test == 80){
			addTreasures(level);
		} else if (test == 81){
			addTraps(level);
			addTreasures(level);
		} else if (test == 82){
			addTraps(level);
		} else {
			room.append("***The Room is Empty.\n\n");
		}
		
		//End Warning!
		room.append("***Note: This does not contain treasures for defeated Monsters!");
	}
	
	//Finished
	private void addFeatures(){
		int test = rollDie(1, 100);
		room.append("***Features:");
		room.append("\n");
		room.append("\n");
		
		if(1 <= test && test <= 40){
			generateMinorFeatures();
		} else if (41 <= test && test <= 80){
			generateMajorFeatures();
		} else {
			generateMajorFeatures();
			generateMinorFeatures();
		}
		room.append("\n");
	}
	
	//Finished
	private void generateMinorFeatures(){
		int amount = rollDie(1, 4);
		
		for (int i = 0; i < amount; i++){
			int test = rollDie(1, 100);
			switch (test){
			case 1:
				room.append("Anvil\n");
				break;
			case 2:
				room.append("Ash\n");
				break;
			case 3:
				room.append("Backpack\n");
				break;
			case 4:
				room.append("Bale (straw)\n");
				break;
			case 5:
				room.append("Bellows\n");
				break;
			case 6:
				room.append("Belt\n");
				break;
			case 7:
				room.append("Bits of fur\n");
				break;
			case 8:
				room.append("Blanket\n");
				break;
			case 9:
				room.append("Bloodstain\n");
				break;
			case 10:
				room.append("Bones (humanoid)\n");
				break;
			case 11:
				room.append("Bones (nonhumanoid)\n");
				break;
			case 12:
				room.append("Books\n");
				break;
			case 13:
				room.append("Boots\n");
				break;
			case 14:
				room.append("Bottle\n");
				break;
			case 15:
				room.append("Box\n");
				break;
			case 16:
				room.append("Branding iron\n");
				break;
			case 17:
				room.append("Broken glass\n");
				break;
			case 18:
				room.append("Bucket\n");
				break;
			case 19:
				room.append("Candle\n");
				break;
			case 20:
				room.append("Candelabra\n");
				break;
			case 21:
				room.append("Cards (playing cards)\n");
				break;
			case 22:
				room.append("Chains\n");
				break;
			case 23:
				room.append("Claw marks\n");
				break;
			case 24:
				room.append("Cleaver\n");
				break;
			case 25:
				room.append("Clothing\n");
				break;
			case 26:
				room.append("Cobwebs\n");
				break;
			case 27:
				room.append("Cold spot\n");
				break;
			case 28:
				room.append("Corpse (adventurer)\n");
				break;
			case 29:
				room.append("Corpse (monster)\n");
				break;
			case 30:
				room.append("Cracks\n");
				break;
			case 31:
				room.append("Dice\n");
				break;
			case 32:
				room.append("Discarded weapons\n");
				break;
			case 33:
				room.append("Dishes\n");
				break;
			case 34:
				room.append("Dripping water\n");
				break;
			case 35:
				room.append("Drum\n");
				break;
			case 36:
				room.append("Dust\n");
				break;
			case 37:
				room.append("Engraving\n");
				break;
			case 38:
				room.append("Equipment (broken)\n");
				break;
			case 39:
				room.append("Equipment (usable)\n");
				break;
			case 40:
				room.append("Flask\n");
				break;
			case 41:
				room.append("Flint and tinder\n");
				break;
			case 42:
				room.append("Foodstuffs (spoiled)\n");
				break;
			case 43:
				room.append("Foodstuffs (edible)\n");
				break;
			case 44:
				room.append("Fungus\n");
				break;
			case 45:
				room.append("Grinder\n");
				break;
			case 46:
				room.append("Hook\n");
				break;
			case 47:
				room.append("Horn\n");
				break;
			case 48:
				room.append("Hourglass\n");
				break;
			case 49:
				room.append("Insects\n");
				break;
			case 50:
				room.append("Jar\n");
				break;
			case 51:
				room.append("Keg\n");
				break;
			case 52:
				room.append("Key\n");
				break;
			case 53:
				room.append("Lamp\n");
				break;
			case 54:
				room.append("Lantern\n");
				break;
			case 55:
				room.append("Markings\n");
				break;
			case 56:
				room.append("Mold\n");
				break;
			case 57:
				room.append("Mud\n");
				break;
			case 58:
				room.append("Mug\n");
				break;
			case 59:
				room.append("Musical instrument\n");
				break;
			case 60:
				room.append("Mysterious stain\n");
				break;
			case 61:
				room.append("Nest (animal)\n");
				break;
			case 62:
				room.append("Odor (unidentifiable)\n");
				break;
			case 63:
				room.append("Oil (fuel)\n");
				break;
			case 64:
				room.append("Oil (scented)\n");
				break;
			case 65:
				room.append("Paint\n");
				break;
			case 66:
				room.append("Paper\n");
				break;
			case 67:
				room.append("Pillows\n");
				break;
			case 68:
				room.append("Pipe (smoking pipe)\n");
				break;
			case 69:
				room.append("Pole\n");
				break;
			case 70:
				room.append("Pot\n");
				break;
			case 71:
				room.append("Pottery Shard\n");
				break;
			case 72:
				room.append("Pouch\n");
				break;
			case 73:
				room.append("Puddle (water)\n");
				break;
			case 74:
				room.append("Rags\n");
				break;
			case 75:
				room.append("Razor\n");
				break;
			case 76:
				room.append("Rivulet\n");
				break;
			case 77:
				room.append("Ropes\n");
				break;
			case 78:
				room.append("Runes\n");
				break;
			case 79:
				room.append("Sack\n");
				break;
			case 80:
				room.append("Scattered stones\n");
				break;
			case 81:
				room.append("Scorch marks\n");
				break;
			case 82:
				room.append("Scroll (nonmagical)\n");
				break;
			case 83:
				room.append("Scroll case (empty)\n");
				break;
			case 84:
				room.append("Skull\n");
				break;
			case 85:
				room.append("Slime\n");
				break;
			case 86:
				room.append("Sound (unexplained)\n");
				break;
			case 87:
				room.append("Spices\n");
				break;
			case 88:
				room.append("Spike\n");
				break;
			case 89:
				room.append("Teeth\n");
				break;
			case 90:
				room.append("Tongs\n");
				break;
			case 91:
				room.append("Tools\n");
				break;
			case 92:
				room.append("Torch (stub)\n");
				break;
			case 93:
				room.append("Tray\n");
				break;
			case 94:
				room.append("Trophy\n");
				break;
			case 95:
				room.append("Twine\n");
				break;
			case 96:
				room.append("Urn\n");
				break;
			case 97:
				room.append("Utensils\n");
				break;
			case 98:
				room.append("Whetstone\n");
				break;
			case 99:
				room.append("Wood (scraps)\n");
				break;
			case 100:
				room.append("Words (scrawled)\n");
				break;
			}
		}
	}
	
	//Finished
	private void generateMajorFeatures(){
		int amount = rollDie(1, 4);
		
		for (int i = 0; i < amount; i++){
			int test = rollDie(1,100);
			switch (test){
			case 1:
				room.append("Alcove\n");
				break;
			case 2:
				room.append("Altar\n");
				break;
			case 3:
				room.append("Arch\n");
				break;
			case 4:
				room.append("Arrow slit (wall)/murder hole (ceiling)\n");
				break;
			case 5:
				room.append("Balcony\n");
				break;
			case 6:
				room.append("Barrel\n");
				break;
			case 7:
				room.append("Bed\n");
				break;
			case 8:
				room.append("Bench\n");
				break;
			case 9:
				room.append("Bookcase\n");
				break;
			case 10:
				room.append("Brazier\n");
				break;
			case 11:
				room.append("Cage\n");
				break;
			case 12:
				room.append("Caldron\n");
				break;
			case 13:
				room.append("Carpet\n");
				break;
			case 14:
				room.append("Carving\n");
				break;
			case 15:
				room.append("Casket\n");
				break;
			case 16:
				room.append("Catwalk\n");
				break;
			case 17:
				room.append("Chair\n");
				break;
			case 18:
				room.append("Chandelier\n");
				break;
			case 19:
				room.append("Charcoal bin\n");
				break;
			case 20:
				room.append("Chasm\n");
				break;
			case 21:
				room.append("Chest\n");
				break;
			case 22:
				room.append("Chest of drawers\n");
				break;
			case 23:
				room.append("Chute\n");
				break;
			case 24:
				room.append("Coat rack\n");
				break;
			case 25:
				room.append("Collapsed wall\n");
				break;
			case 26:
				room.append("Crate\n");
				break;
			case 27:
				room.append("Cupboard\n");
				break;
			case 28:
				room.append("Curtain\n");
				break;
			case 29:
				room.append("Divan\n");
				break;
			case 30:
				room.append("Dome\n");
				break;
			case 31:
				room.append("Door (broken)\n");
				break;
			case 32:
				room.append("Dung heap\n");
				break;
			case 33:
				room.append("Evil symbol\n");
				break;
			case 34:
				room.append("Fallen stones\n");
				break;
			case 35:
				room.append("Firepit\n");
				break;
			case 36:
				room.append("Fireplace\n");
				break;
			case 37:
				room.append("Font\n");
				break;
			case 38:
				room.append("Forge\n");
				break;
			case 39:
				room.append("Fountain\n");
				break;
			case 40:
				room.append("Furniture (broken)\n");
				break;
			case 41:
				room.append("Gong\n");
				break;
			case 42:
				room.append("Hay (pile)\n");
				break;
			case 43:
				room.append("Hole\n");
				break;
			case 44:
				room.append("Hole (blasted)\n");
				break;
			case 45:
				room.append("Idol\n");
				break;
			case 46:
				room.append("Iron bars\n");
				break;
			case 47:
				room.append("Iron maiden\n");
				break;
			case 48:
				room.append("Kiln\n");
				break;
			case 49:
				room.append("Ladder\n");
				break;
			case 50:
				room.append("Ledge\n");
				break;
			case 51:
				room.append("Loom\n");
				break;
			case 52:
				room.append("Loose masonry\n");
				break;
			case 53:
				room.append("Manacles\n");
				break;
			case 54:
				room.append("Manger\n");
				break;
			case 55:
				room.append("Mirror\n");
				break;
			case 56:
				room.append("Mosaic\n");
				break;
			case 57:
				room.append("Mound of Rubble\n");
				break;
			case 58:
				room.append("Oven\n");
				break;
			case 59:
				room.append("Overhang\n");
				break;
			case 60:
				room.append("Painting\n");
				break;
			case 61:
				room.append("Partially collapsed ceiling\n");
				break;
			case 62:
				room.append("Pedestal\n");
				break;
			case 63:
				room.append("Peephole\n");
				break;
			case 64:
				room.append("Pillar\n");
				break;
			case 65:
				room.append("Pillory\n");
				break;
			case 66:
				room.append("Pit (shallow)\n");
				break;
			case 67:
				room.append("Platform\n");
				break;
			case 68:
				room.append("Pool\n");
				break;
			case 69:
				room.append("Portcullis\n");
				break;
			case 70:
				room.append("Rack\n");
				break;
			case 71:
				room.append("Ramp\n");
				break;
			case 72:
				room.append("Recess\n");
				break;
			case 73:
				room.append("Relief\n");
				break;
			case 74:
				room.append("Sconce\n");
				break;
			case 75:
				room.append("Screen\n");
				break;
			case 76:
				room.append("Shaft\n");
				break;
			case 77:
				room.append("Shelf\n");
				break;
			case 78:
				room.append("Shrine\n");
				break;
			case 79:
				room.append("Spinning wheel\n");
				break;
			case 80:
				room.append("Stall or pen\n");
				break;
			case 81:
				room.append("Statue\n");
				break;
			case 82:
				room.append("Statue (toppled)\n");
				break;
			case 83:
				room.append("Steps\n");
				break;
			case 84:
				room.append("Stool\n");
				break;
			case 85:
				room.append("Stuffed beast\n");
				break;
			case 86:
				room.append("Sunken area\n");
				break;
			case 87:
				room.append("Table (large)\n");
				break;
			case 88:
				room.append("Table (small)\n");
				break;
			case 89:
				room.append("Tapestry\n");
				break;
			case 90:
				room.append("Throne\n");
				break;
			case 91:
				room.append("Trash (pile)\n");
				break;
			case 92:
				room.append("Tripod\n");
				break;
			case 93:
				room.append("Trough\n");
				break;
			case 94:
				room.append("Tub\n");
				break;
			case 95:
				room.append("Wall basin\n");
				break;
			case 96:
				room.append("Wardrobe\n");
				break;
			case 97:
				room.append("Weapon rack\n");
				break;
			case 98:
				room.append("Well\n");
				break;
			case 99:
				room.append("Winch and pulley\n");
				break;
			case 100:
				room.append("Workbench\n");
				break;
			}
		}
	}
	
	//TODO Create past 4th CR
	private void addMonsters(int level){
		int test = rollDie(1, 100);
		
		boolean space = true;
		if (room.indexOf("***Monsters:") == -1){
			room.append("***Monsters:");
			room.append("\n");
			room.append("\n");
		} else {
			space = false;
		}
		
		switch (level){
			case 1:
				if (test <= 3){
					room.append(rollDie(1, 3) + " Medium monstrous centipedes (vermin)\n");
				} else if (test <= 8){
					room.append(rollDie(1, 4) + " dire rats\n");
				} else if (test <= 10){
					room.append(rollDie(1, 4) + " giant fire beetles (vermin)\n");
				} else if (test <= 13){
					room.append(rollDie(1, 3) + " Small monstrous scorpions (vermin)\n");
				} else if (test <= 16){
					room.append(rollDie(1,3) + " Small monstrous spiders (vermin)\n");
				} else if (test <= 20){
					room.append(rollDie(1,3) + " dwarf warriors\n");
				} else if (test <= 22){
					room.append(rollDie(1, 3) + " elf warriors\n");
				} else if (test <= 25){
					room.append("1 darkmantle\n");
				} else if (test <= 28){
					room.append("1 krenshar\n");
				} else if (test <= 30){
					room.append("1 lemure(devil)\n");
				} else if (test <= 40){
					room.append(rollDie(1, 3) + 1 + " golblin warriors\n");
				} else if (test <= 50){
					room.append(rollDie(1, 4) + 2 + " kobold warriors\n");
				} else if (test <= 56){
					room.append(rollDie(1, 4) + " human warrior skeletons\n");
				} else if (test <= 62){
					room.append(rollDie(1, 3) + " human commoner zombies\n");
				} else if (test <= 71){
					room.append(rollDie(1, 4) + 1 + " Tiny viper snakes (animal)\n");
				} else if (test <= 80){
					room.append(rollDie(1, 3) + " orc warriors\n");
				} else if (test <= 85){
					room.append(rollDie(1, 3) + " stirges\n");
				} else if (test <= 90){
					room.append("1 spider swarm\n");
				} else {
					addMonsters(2);
				}
				break;
			case 2:
				if (test <= 10){
					addMonsters(1);
				} else if (test <= 12){
					room.append("1 lantern archon\n");
				} else if (test <= 19){
					room.append("1 hobgoblin warrior and " + rollDie(1, 4) + " goblin warriors\n");
				} else if (test <= 23){
					room.append("1 bugbear\n");
				} else if (test <= 26){
					room.append("1 choker\n");
				} else if (test <= 28){
					room.append("1 dretch (demon)\n");
				} else if (test <= 30){
					room.append("1 quasit (demon)\n");
				} else if (test <= 32){
					room.append("1 imp (devil)\n");
				} else if (test <= 35){
					room.append("1 dire bat\n");
				} else if (test <= 38){
					room.append(rollDie(1, 4) + 1 + " fiendish dire rats\n");
				} else if (test <= 40){
					room.append(rollDie(1, 3) + 1 + " formian workers\n");
				} else if (test <= 43){
					room.append(rollDie(1, 3) + 1 + "halfling warriors\n");
				} else if (test <= 50){
					room.append(rollDie(2, 4) + 1 + " kobold warriors\n");
				} else if (test <= 55){
					room.append("1 wererat (lycanthrope)\n");
				} else if (test <= 62){
					room.append(rollDie(1, 3) + 1 + " orc warriors\n");
				} else if (test <= 65){
					room.append("1 shocker lizard\n");
				} else if (test <= 68){
					room.append("1 owlbear skeleton\n");
				} else if (test <= 70){
					room.append("1 bat swarm\n");
				} else if (test <= 72){
					room.append("1 rat swarm\n");
				} else if (test <= 74){
					room.append("1 thoqqua\n");
				} else if (test <= 79){
					room.append("1 worg\n");
				} else if (test <= 83){
					room.append("1 constrictor snake (animal)\n");
				} else if (test <= 87){
					room.append(rollDie(1, 4) + 2 + " Small viper snakes (animal)\n");
				} else if (test <= 90){
					room.append("1 Huge monstrous centipede (vermin)\n");
				} else if (test <= 100){
					addMonsters(3);
				}
				break;
			case 3:
				if (test <= 10){
					addMonsters(2);
				} else if (test <= 13){
					room.append("1 allip\n");
				} else if (test <= 16){
					room.append("1 cockatrice\n");
				} else if (test <= 19){
					room.append(rollDie(2, 4) + 1 + " dire rats\n");
				} else if (test <= 21){
					room.append("1 doppelganger\n");
				} else if (test <= 23){
					room.append("1 wyrmling brass dragon\n");
				} else if (test <= 27){
					room.append(rollDie(1, 3) + " drow elves\n");
				} else if (test <= 29){
					room.append("1 ethereal filcher\n");
				} else if (test <= 31){
					room.append("1 ethereal maurauder\n");
				} else if (test <= 33){
					room.append("1 ettercap");
				} else if (test <= 35){
					room.append("1 violet fungus (fungus)");
				} else if (test <= 38){
					room.append("1 ghast (ghoul)\n");
				} else if (test <= 43){
					room.append(rollDie(1, 3) + " gnolls\n");
				} else if (test <= 45){
					room.append("1 grick\n");
				} else if (test <= 48){
					room.append("1 hell hound\n");
				} else if (test <= 50){
					room.append("1 howler\n");
				} else if (test <= 52){
					room.append(rollDie(1, 3) + " krenshars\n");
				} else if (test <= 55){
					room.append(rollDie(1, 3) + " lizardfolk\n");
				} else if (test <= 57){
					room.append("1 werewolf (lycanthrope)\n");
				} else if (test <= 62){
					room.append("1 ogre\n");
				} else if (test <= 65){
					room.append("1 gelatinous cube (ooze)\n");
				} else if (test <= 67){
					room.append("1 phantom fungus\n");
				} else if (test <= 69){
					room.append("1 rust monster\n");
				} else if (test <= 72){
					room.append("1 shadow\n");
				} else if (test <= 75){
					room.append(rollDie(2, 4) + " stirges\n");
				} else if (test <= 77){
					room.append("1 locust swarm\n");
				} else if (test <= 80){
					room.append("1 wight\n");
				} else if (test <= 82){
					room.append("1 yuan-ti pureblood\n");
				} else if (test <= 84){
					room.append(rollDie(1, 3) + " troglodyte zombies\n");
				} else if (test <= 86){
					room.append(rollDie(1, 3) + " Medium viper snakes\n");
				} else if (test <= 88){
					room.append("1 giant praying mantis(vermin)\n");
				} else if (test <= 90){
					room.append(rollDie(1, 3) + " Medium monstrous scorpions (vermin)\n");
				} else {
					addMonsters(4);
				}
				break;
			case 4:
				if (test <= 10){
					addMonsters(3);
				} else if (test <= 12){
					room.append("1 barghest\n");
				} else if (test <= 14){
					room.append(rollDie(1, 3) + " lantern archons\n");
				} else if (test <= 16){
					room.append("1 hound archon\n");
				} else if (test <= 20){
					room.append("1 carrion crawler\n");
				} else if (test <= 22){
					room.append(rollDie(1, 4) + 1 + " darkmantles\n");
				} else if (test <= 27){
					room.append("1 displacer beast\n");
				} else if (test <= 30){
					room.append("1 young white dragon\n");
				} else if (test <= 33){
					room.append(rollDie(1, 3) + 1 + " duergar dwarves\n");
				} else if (test <= 38){
					room.append("1 gargoyle\n");
				} else if (test <= 40){
					room.append("1 janni (genie)\n");
				} else if (test <= 44){
					room.append(rollDie(1, 3) + 1 + " ghouls\n");
				} else if (test <= 47){
					room.append(rollDie(1, 3) + 1 + " svirfneblin gnomes\n");
				} else if (test <= 50){
					room.append(rollDie(1, 3) + 1 + " grimlocks\n");
				} else if (test <= 52){
					room.append("1 harpy\n");
				} else if (test <= 54){
					room.append("1 five-headed hydra\n");
				} else if (test <= 56){
					room.append("1 wereboar (lycanthrope)\n");
				} else if (test <= 59){
					room.append("1 mimic\n");
				} else if (test <= 62){
					room.append("1 minotaur\n");
				} else if (test <= 64){
					room.append("1 gray ooze (ooze)\n");
				} else if (test <= 67){
					room.append("1 otyugh\n");
				} else if (test <= 69){
					room.append("1 owlbear\n");
				} else if (test <= 71){
					room.append("1 centipede swarm\n");
				} else if (test <= 73){
					room.append(rollDie(1, 3) + 1 + " spider swarm\n");
				} else if (test <= 76){
					room.append(rollDie(1, 4) + 1 + " troglodytes\n");
				} else if (test <= 78){
					room.append("1 vampire spawn\n");
				} else if (test <= 80){
					room.append(rollDie(1, 3) + " worgs\n");
				} else if (test <= 83){
					room.append("1 minotaur zombie\n");
				} else if (test <= 85){
					room.append(rollDie(1, 3) + " Large viper snakes (animal)\n");
				} else if (test <= 88){
					room.append(rollDie(1, 4) + 1 + " Large monstrous centipedes (vermin)\n");
				} else if (test <= 90){
					room.append(rollDie(1, 3) + " Large monstrous spiders (vermin)\n");
				} else {
					addMonsters(5);
				}
				break;
			case 5:
				
				break;
		}
		if (space){
			room.append("\n");
		}
	}
	
	//TODO Create
	private void addTraps(int level){
		room.append("***Traps:");
		room.append("\n");
		room.append("\n");
	}
	
	//Finished
	private void addTreasures(int level){
		room.append("***Treasures (Possibly Hidden):");
		room.append("\n");
		room.append("\n");
		addCoins(level);
		addGoods(level);
		addItems(level);
		room.append("\n");
	}
	
	//TODO Create past 4th CR
	private void addCoins(int level){
		int test = rollDie(1, 100);
		switch (level){
			case 1:
				if (test <= 14){
					//Nothing
				} else if (test <= 29){
					room.append(rollDie(1, 6) * 1000 + " cp\n");
				} else if (test <= 52){
					room.append(rollDie(1, 8) * 100 + " sp\n");
				} else if (test <= 95){
					room.append(rollDie(2, 8) * 10 + " gp\n");
				} else if (test <= 100){
					room.append(rollDie(1, 4) * 10 + " pp\n");
				}
				break;
			case 2:
				if (test <= 13){
					//Nothing
				} else if (test <= 23){
					room.append(rollDie(1, 10) * 1000 + " cp\n");
				} else if (test <= 43){
					room.append(rollDie(2, 10) * 100 + " sp\n");
				} else if (test <= 95){
					room.append(rollDie(4, 10) * 10 + " gp\n");
				} else if (test <= 100){
					room.append(rollDie(2, 8) * 10 + " pp\n");
				}
				break;
			case 3:
				if (test <= 11){
					//Nothing
				} else if (test <= 21){
					room.append(rollDie(2, 10) * 1000 + " cp\n");
				} else if (test <= 41){
					room.append(rollDie(4, 8) * 100 + " sp\n");
				} else if (test <= 95){
					room.append(rollDie(1, 4) * 100 + " gp\n");
				} else if (test <= 100){
					room.append(rollDie(1, 10) * 10 + " pp\n");
				}
				break;
			case 4:
				if (test <= 11){
					//Nothing
				} else if (test <= 21){
					room.append(rollDie(3, 10) * 1000 + " cp\n");
				} else if (test <= 41){
					room.append(rollDie(4, 12) * 1000 + " sp\n");
				} else if (test <= 95){
					room.append(rollDie(1, 6) * 100 + " gp\n");
				} else if (test <= 100){
					room.append(rollDie(1, 8) * 10 + " pp\n");
				}
				break;
		}
	}
	
	//TODO Create past 4th CR
	private void addGoods(int level){
		int test = rollDie(1, 100);
		switch(level){
			case 1:
				if (test <= 90){
					//Nothing
				} else if (test <= 95){
					generateGems(1);
				} else {
					generateArt(1);
				}
			case 2:
				if (test <= 81){
					//Nothing
				} else if (test <= 95){
					generateGems(rollDie(1, 3));
				} else {
					generateArt(rollDie(1, 3));
				}
			case 3:
				if (test <= 77){
					//Nothing
				} else if (test <= 95){
					generateGems(rollDie(1, 3));
				} else {
					generateArt(rollDie(1, 3));
				}
			case 4:
				if (test <= 70){
					//Nothing
				} else if (test <= 95){
					generateGems(rollDie(1, 4));
				} else {
					generateArt(rollDie(1, 3));
				}
		}
	}
	
	//Finished
	private void generateGems(int times){
		String[] gems1 = new String[10];
		gems1[0] = "banded, eye, or moss agate\n";
		gems1[1] = "azurite\n";
		gems1[2] = "blue quartz\n";
		gems1[3] = "hematite\n";
		gems1[4] = "lapis lazuli\n";
		gems1[5] = "malachite\n";
		gems1[6] = "obsidiam\n";
		gems1[7] = "rhodoscrosite\n";
		gems1[8] = "tiger eye turquoise\n";
		gems1[9] = "freshwater (irregular) pearl\n";
		
		String[] gems2 = new String[14];
		gems2[0] = "bloodstone\n";
		gems2[1] = "carnelian\n";
		gems2[2] = "chalcedony\n";
		gems2[3] = "chrysoprase\n";
		gems2[4] = "citirine\n";
		gems2[5] = "iolite, jasper\n";
		gems2[6] = "moonstone\n";
		gems2[7] = "onyx\n";
		gems2[8] = "peridot\n";
		gems2[9] = "rock crystal (clear quartz)\n";
		gems2[10] = "sard\n";
		gems2[11] = "sardonyx\n";
		gems2[12] = "rose, smoky, or star rose quartz\n";
		gems2[13] = "zircon\n";
		
		String[] gems3 = new String[10];
		gems3[0] = "amber\n";
		gems3[1] = "amethyst\n";
		gems3[2] = "chrysoberyl\n";
		gems3[3] = "coral\n";
		gems3[4] = "red or brown-green garnet\n";
		gems3[5] = "jade\n";
		gems3[6] = "jet\n";
		gems3[7] = "white, goldern, pink, or silver pearl\n";
		gems3[8] = "red spinel, red-brown or deep green spinel\n";
		gems3[9] = "tourmaline\n";
		
		String[] gems4 = new String[6];
		gems4[0] = "alexandrite\n";
		gems4[1] = "aquamarine\n";
		gems4[2] = "violet garnet\n";
		gems4[3] = "black pearl\n";
		gems4[4] = "deep blue spinel\n";
		gems4[5] = "golden yellow topaz\n";
		
		String[] gems5 = new String[6];
		gems5[0] = "emerald\n";
		gems5[1] = "white, black, or fire opal\n";
		gems5[2] = "blue sapphire\n";
		gems5[3] = "fiery yellow or rich purple corundum\n";
		gems5[4] = "blue or black star sapphire\n";
		gems5[5] = "star ruby\n";
		
		String[] gems6 = new String[3];
		gems6[0] = "clearest bright green emerald\n";
		gems6[1] = "blue-white, canary, pink, brown, or blue diamond\n";
		gems6[2] = "jacinth\n";
		
		for (int i = 0; i < times; i++){
			int test = rollDie(1, 100);
			if (test <= 25){
				room.append(rollDie(4, 4) + " gp worth of ");
				room.append(gems1[rnd.nextInt(gems1.length)]);
			} else if (test <= 50){
				room.append(rollDie(2, 4) * 10 + " gp worth of ");
				room.append(gems2[rnd.nextInt(gems2.length)]);
			} else if (test <= 70){
				room.append(rollDie(4, 4) * 10 + " gp worth of ");
				room.append(gems3[rnd.nextInt(gems3.length)]);
			} else if (test <= 90){
				room.append(rollDie(2, 4) * 100 + " gp worth of ");
				room.append(gems4[rnd.nextInt(gems4.length)]);
			} else if (test <= 99){
				room.append(rollDie(4, 4) * 100 + " gp worth of ");
				room.append(gems5[rnd.nextInt(gems5.length)]);
			} else {
				room.append(rollDie(2, 4) * 1000 + " gp worth of ");
				room.append(gems6[rnd.nextInt(gems6.length)]);
			}
		}
	}
	
	//Finished
	private void generateArt(int times){
		String[] art1 = new String[3];
		art1[0] = "silver ewer\n";
		art1[1] = "carved bone or ivory statuette\n";
		art1[2] = "finely wrought small gold bracelet\n";
		
		String[] art2 = new String[3];
		art2[0] = "cloth of gold vestments\n";
		art2[1] = "black velvet mask with numerous citrines\n";
		art2[2] = "silver chalice with lapis lazuli gems\n";
		
		String[] art3 = new String[2];
		art3[0] = "large well-done wool tapestry\n";
		art3[1] = "brass mug with jade inlays\n";
		
		String[] art4 = new String[2];
		art4[0] = "silver comb with moonstones\n";
		art4[1] = "silver=plated steel longsword with jet jewel hilt\n";
		
		String[] art5 = new String[2];
		art5[0] = "carved harp of exotic wood with ivory inlay and zircon gems\n";
		art5[1] = "solid gold idol (10 lb.)\n";
		
		String[] art6 = new String[3];
		art6[0] = "gold dragon comb with red garnet eye\n";
		art6[1] = "gold and topaz bottle stopper cork\n";
		art6[2] = "ceremonial electrum dagger with a star ruby in the pommel\n";
		
		String[] art7 = new String[3];
		art7[0] = "eyepatch with mock eye of sapphire and moonstone\n";
		art7[1] = "fire opal pendant on a fine gold chain\n";
		art7[2] = "old masterpiece painting\n";
		
		String[] art8 = new String[2];
		art8[0] = "embroidered silk and velvet mantle with numerous moonstones\n";
		art8[1] = "sapphire pendant on gold chain\n";
		
		String[] art9 = new String[3];
		art9[0] = "embroidered and bejeweled glove\n";
		art9[1] = "jeweled anklet\n";
		art9[2] = "gold music box\n";
		
		String[] art10	= new String[2];
		art10[0] = "golden circlet with four aquamarines\n";
		art10[1] = "a string of small pink pearls (necklace)\n";
		
		String[] art11 = new String[2];
		art11[0] = "jeweled gold crown\n";
		art11[1] = "jeweled electrum ring\n";
		
		String[] art12 = new String[2];
		art12[0] = "gold and ruby ring\n";
		art12[1] = "gold cup set with emeralds\n";
		
		for (int i = 0; i < times; i++){
			int test = rollDie(1, 100);
			
			if (test <= 10){
				room.append(rollDie(1, 10) * 10 + " gp ");
				room.append(art1[rnd.nextInt(art1.length)]);
			} else if (test <= 25){
				room.append(rollDie(3, 6) * 10 + " gp ");
				room.append(art2[rnd.nextInt(art2.length)]);
			} else if (test <= 40){
				room.append(rollDie(1, 6) * 100 + " gp ");
				room.append(art3[rnd.nextInt(art3.length)]);
			} else if (test <= 50){
				room.append(rollDie(1, 10) * 100 + " gp ");
				room.append(art4[rnd.nextInt(art4.length)]);
			} else if (test <= 60){
				room.append(rollDie(2, 6) * 100 + " gp ");
				room.append(art5[rnd.nextInt(art5.length)]);
			} else if (test <= 70){
				room.append(rollDie(3, 6) * 100 + " gp ");
				room.append(art6[rnd.nextInt(art6.length)]);
			} else if (test <= 80){
				room.append(rollDie(4, 6) * 100 + " gp ");
				room.append(art7[rnd.nextInt(art7.length)]);
			} else if (test <= 85){
				room.append(rollDie(5, 6) * 100 + " gp ");
				room.append(art8[rnd.nextInt(art8.length)]);
			} else if (test <= 90){
				room.append(rollDie(1, 4) * 1000 + " gp ");
				room.append(art9[rnd.nextInt(art9.length)]);
			} else if (test <= 95){
				room.append(rollDie(1, 6) * 1000 + " gp ");
				room.append(art10[rnd.nextInt(art10.length)]);
			} else if (test <= 99){
				room.append(rollDie(2, 4) * 1000 + " gp ");
				room.append(art11[rnd.nextInt(art11.length)]);
			} else {
				room.append(rollDie(2, 6) * 1000 + " gp ");
				room.append(art12[rnd.nextInt(art12.length)]);
			}
		}
	}
	
	//Finished
	private void addItems(int level){
		int test = rollDie(1, 100);
		
		switch(level){
			case 1:
				if (test <= 71){
					//Nothing
				} else if (test <= 95){
					generateMundane(1);
				} else {
					generateMinor(1);
				}
				break;
			case 2:
				if (test <= 49){
					//Nothing
				} else if (test <= 85){
					generateMundane(1);
				} else {
					generateMinor(1);
				}
				break;
			case 3:
				if (test <= 49){
					//Nothing
				} else if (test <= 79){
					generateMundane(rollDie(1, 3));
				} else {
					generateMinor(1);
				}
				break;
			case 4:
				if (test <= 42){
					//Nothing
				} else if (test <= 62){
					generateMundane(rollDie(1, 4));
				} else {
					generateMinor(1);
				}
				break;
			case 5:
				if (test <= 57){
					//Nothing
				} else if (test <= 67){
					generateMundane(rollDie(1, 4));
				} else {
					generateMinor(rollDie(1, 3));
				}
				break;
			case 6:
				if (test <= 54){
					//Nothing
				} else if (test <= 59){
					generateMundane(rollDie(1, 4));
				} else if (test <= 99){
					generateMinor(rollDie(1, 3));
				} else {
					generateMedium(1);
				}
				break;
			case 7:
				if (test <= 51){
					//Nothing
				} else if (test <= 97){
					generateMinor(rollDie(1, 3));
				} else {
					generateMedium(1);
				}
				break;
			case 8:
				if (test <= 48){
					//Nothing
				} else if (test <= 96){
					generateMinor(rollDie(1, 4));
				} else {
					generateMedium(1);
				}
				break;
			case 9:
				if (test <= 43){
					//Nothing
				} else if (test <= 91){
					generateMinor(rollDie(1, 4));
				} else {
					generateMedium(1);
				}
				break;
			case 10:
				if (test <= 40){
					//Nothing
				} else if (test <= 88){
					generateMinor(rollDie(1, 4));
				} else if (test <= 99){
					generateMedium(1);
				} else {
					generateMajor(1);
				}
				break;
			case 11:
				if (test <= 31){
					//Nothing
				} else if (test <= 84){
					generateMinor(rollDie(1, 4));
				} else if (test <= 98){
					generateMedium(1);
				} else {
					generateMajor(1);
				}
				break;
			case 12:
				if (test <= 27){
					//Nothing
				} else if (test <= 82){
					generateMinor(rollDie(1, 6));
				} else if (test <= 97){
					generateMedium(1);
				} else {
					generateMajor(1);
				}
				break;
			case 13:
				if (test <= 19){
					//Nothing
				} else if (test <= 73){
					generateMinor(rollDie(1, 6));
				} else if (test <= 95){
					generateMedium(1);
				} else {
					generateMajor(1);
				}
				break;
			case 14:
				if (test <= 19){
					//Nothing
				} else if (test <= 58){
					generateMinor(rollDie(1, 6));
				} else if (test <= 92){
					generateMedium(1);
				} else {
					generateMajor(1);
				}
				break;
			case 15:
				if (test <= 11){
					//Nothing
				} else if (test <= 46){
					generateMinor(rollDie(1, 10));
				} else if (test <= 90){
					generateMedium(1);
				} else {
					generateMajor(1);
				}
				break;
			case 16:
				if (test <= 40){
					//Nothing
				} else if (test <= 46){
					generateMinor(rollDie(1, 10));
				} else if (test <= 90){
					generateMajor(rollDie(1, 3));
				} else {
					generateMajor(1);
				}
				break;
			case 17:
				if (test <= 33){
					//Nothing
				} else if (test <= 83){
					generateMedium(rollDie(1, 3));
				} else {
					generateMajor(1);
				}
				break;
			case 18:
				if (test <= 24){
					//Nothing
				} else if (test <= 80){
					generateMedium(rollDie(1, 4));
				} else {
					generateMajor(1);
				}
				break;
			case 19:
				if (test <= 4){
					//Nothing
				} else if (test <= 70){
					generateMedium(rollDie(1, 4));
				} else {
					generateMajor(1);
				}
				break;
			case 20:
				if (test <= 25){
					//Nothing
				} else if (test <= 65){
					generateMedium(rollDie(1, 4));
				} else {
					generateMajor(rollDie(1, 3));
				}
				break;
		} 
	}
	
	//Finished
	private void generateMundane(int times){
		
		for (int i = 0; i < times; i++){
			int test = rollDie(1, 100);
			
			if (test <= 17){
				generateAlchemicalItem();
			} else if (test <= 50){
				generateArmor();
			} else if (test <= 83){
				generateWeapon();
			} else if (test <= 100){
				generateToolsGear();
			}
		}
	}
	
	//Finished
	private void generateAlchemicalItem(){
		int test = rollDie(1, 100);
		
		if (test <= 12){
			room.append("Alchemist's fire (" + rollDie(1, 4) + " flasks, 20gp each)\n");
		} else if (test <= 24){
			room.append("Acid (" + rollDie(2, 4) + " flasks, 10gp each)\n");
		} else if (test <= 36){
			room.append("Smokesticks (" + rollDie(1, 4) + " sticks, 20 gp each)\n");
		} else if (test <= 48){
			room.append("Holy water (" + rollDie(1, 4) + " flasks, 25gp each)\n");
		} else if (test <= 62){
			room.append("Antitoxin (" + rollDie(1, 4) + " doses, 50gp each)\n");
		} else if (test <= 74){
			room.append("Everburning torch\n");
		} else if (test <= 88){
			room.append("Tanglefoot bags (" + rollDie(1, 4) + " bags, 50 gp each)\n");
		} else {
			room.append("Thunderstones (" + rollDie(1, 4) + " stones, 30gp each)\n");
		}
	}
	
	//Finished
	private void generateArmor(){
		int test = rollDie(1, 100);
		
		if (test <= 12){
			room.append("Chain shirt (100 gp)\n");
		} else if (test <= 18){
			room.append("Masterwork studded leather (175 gp)\n");
		} else if (test <= 26){
			room.append("Breastplate (200 gp)\n");
		} else if (test <= 34){
			room.append("Banded mail (250 gp)\n");
		} else if (test <= 54){
			room.append("Half-plate (600 gp)\n");
		} else if (test <= 80){
			room.append("Full plate (1,500 gp)\n");
		} else if (test <= 90){
			int test2 = rollDie(1, 100);
			
			if (test2 <= 50){
				room.append("Darkwood Buckler (205 gp)\n");
			} else {
				room.append("Darkwood Shield (257 gp)\n");
			}
		} else {
			int test2 = rollDie(1, 100);
			
			if (test2 <= 17){
				room.append("Masterwork buckler (165 gp)\n");
			} else if (test2 <= 40){
				room.append("Masterwork light wooden shield (153 gp)\n");
			} else if (test2 <= 60){
				room.append("Masterwork light steel shield (159 gp)\n");
			} else if (test2 <= 83){
				room.append("Masterwork heavy wooden shield (157 gp)\n");
			} else {
				room.append("Masterwork heavy steel shield (170 gp)\n");
			}
		}
	}
	
	//TODO Create
	private void generateWeapon(){
		
	}
	
	//Finished
	private void generateToolsGear(){
		int test = rollDie(1, 100);
		
		if (test <= 3){
			room.append("Backpack, empty (2 gp)\n");
		} else if (test <= 6){
			room.append("Crowbar (2 gp)\n");
		} else if (test <= 11){
			room.append("Lantern, bullseye (12 gp)\n");
		} else if (test <= 16){
			room.append("Lock, simple (20 gp)\n");
		} else if (test <= 21){
			room.append("Lock, average (40 gp)\n");
		} else if (test <= 28){
			room.append("Lock, good (80 gp)\n");
		} else if (test <= 35){
			room.append("Lock, superior (150 gp)\n");
		} else if (test <= 40){
			room.append("Manacles, masterwork (50 gp)\n");
		} else if (test <= 43){
			room.append("Mirror, small steel (10 gp)\n");
		} else if (test <= 46){
			room.append("Rope, silk (50 ft.) (10 gp)\n");
		} else if (test <= 53){
			room.append("Spyglass (1,000 gp)\n");
		} else if (test <= 58){
			room.append("Artisan's tools, masterwork (55 gp)\n");
		} else if (test <= 63){
			room.append("Climber's kit (80 gp)\n");
		} else if (test <= 68){
			room.append("Disguise kit (50 gp)\n");
		} else if (test <= 73){
			room.append("Healer's kit (50 gp)\n");
		} else if (test <= 77){
			room.append("Holy, symbol, silver (25 gp)\n");
		} else if (test <= 81){
			room.append("Hourglass (25 gp)\n");
		} else if (test <= 88){
			room.append("Magnifying glass (100 gp)\n");
		} else if (test <= 95){
			room.append("Musical instrument, masterwork (100gp)\n");
		} else {
			room.append("Thieves' tools, masterwork (50 gp)\n");
		}
	}
	
	//TODO Create
	private void generateMinor(int times){
		
	}
	
	//TODO Create
	private void generateMedium(int times){
		
	}
	
	//TODO Create
	private void generateMajor(int times){
		
	}
	
	//Finished
	public String getRoom(){
		return room.toString();
	}
	
	//Finished
	public int rollDie(int num, int size){
		int x = 0;
		for (int i = 0; i < num; i++){
			x += rnd.nextInt(size) + 1;
		}
		return x;
	}
}
