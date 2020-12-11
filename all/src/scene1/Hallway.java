package scene1;

import scene2.*;

public class Hallway extends Place {
	String[] avaliablePos = { "elevator", "housekeeping room", "laundry room", "room 314", "security room",
			"room 394" }; // 2,3,4,5,6,7
	ControlPanel localcp;
	Place security;
	public Hallway(TCP_Client subject, Place sr, Player p) {
		super("you are standing in the hallway!", 1, true, p);
		items.add(new FireExtinguisher("Red", subject, sr, p)); // sensor
		security = sr;
		lookCommand lcomm = new lookCommand(this);
		walkCommand wcomm = new walkCommand(this);
		useCommand ucomm = new useCommand(this);
		storeCommand scomm = new storeCommand(this);
		bagCommand bcomm = new bagCommand(p);
		removeBagCommand rbcomm = new removeBagCommand(this);
		helpCommand hcomm = new helpCommand(this);
		readNotebookCommand ncomm = new readNotebookCommand(p);
		talkCommand tcomm = new talkCommand(this);
		consumeCommand conscomm = new consumeCommand(this);
		
		Command[] ca3 = { lcomm, wcomm, ucomm, scomm, bcomm, rbcomm, hcomm, ncomm, tcomm, conscomm }; // walk-> drive, talk->
		localcp = new ControlPanel(ca3);
		this.setCp(localcp);
	}

	@Override
	public void look() {
		if (!items.isEmpty()) {
			System.out.println("You are in the hallway, you can find the following objects:"); // Room descrption
			for (int i = 0; i < items.size(); i++) {
				System.out.println(items.get(i).description);
			}
		}
		System.out.println("You can see the following places:");
		for (int i = 0; i < avaliablePos.length; i++) {
			System.out.println(avaliablePos[i]);
		}
		System.out.println("room 301\nroom 302\nroom 303\n");
		System.out.println(
				"You notice that the door for room 394 is slightly open\nYour detective instinct is sensing that something is wrong");

	}

	@Override
	public void walk(String s) {
		if (this.isOpen()) {
			for (int i = 0; i < avaliablePos.length; i++) {
				if ((s.contains(avaliablePos[i])) && (s.contains("walk"))) {
					if(!security.isOpen() && i+2 == 6) {			
						System.out.println("you can't enter the " + avaliablePos[i] + " it is closed !");
						 p.setPosition(pos);
						 return;
					}
					System.out.println("you are standing in " + avaliablePos[i] + "!");
					p.setPosition(i+2);
					p.notifyObservers();
					return;
				}
			}
			if (s.contains("302") || s.contains("301") || s.contains("303")) {
				System.out.println("This place is locked, please try another place");
			} else {
				System.out.println("There is no such place, please try another place");
			}	
			 p.setPosition(pos);
		} else {
			System.out.println("The room is closed, you need to open it first");
			p.setPosition(pos);;
		}
	}

	@Override
	public void help() {
		System.out.println("---The commands are as the follwoing---");
		System.out.println("help: to know all the commands available in the game");
		System.out.println("look around: to see the area you are in");
		System.out.println("walk <place name>: to navigate through the game");
		System.out.println("use <object name>  or open <object name>: to use or open different objects");
		System.out.println("read notebook: to open a summary of evidence collected");
		System.out.println("talk <character name>: to talk to a character");
		System.out.println("eat/drink <object name>: to consume food or drink for energy");
		System.out.println("Store <object name>: to store the portable objects in your bag");
		System.out.println("Statement that contains (look && bag): to view the contents of your bag");
		System.out.println("Statement that contains (remove <object name> && bag): to remove an object from the bag");
		System.out.println("I give up: to exit the game");				
	}
}
