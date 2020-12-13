package scene1;

import scene2.*;

public class SecurityRoom extends Place {
	String[] avaliablePos = { "hallway" };
	ControlPanel localcp;

	public SecurityRoom(Player p) {
		super("You entered the security room!", 6, false, p);
		items.add(new SecurityCamera("black"));
		lookCommand lcomm = new lookCommand(this);
		walkCommand wcomm = new walkCommand(this);
		useCommand ucomm = new useCommand(this);
		storeCommand scomm = new storeCommand(this);
		bagCommand bcomm = new bagCommand(p);
		removeBagCommand rbcomm = new removeBagCommand(this);
		helpCommand hcomm = new helpCommand(this);
		readNotebookCommand ncomm = new readNotebookCommand(p);
		talkCommand tcomm = new talkCommand(this);
		consumeCommand ccomm = new consumeCommand(this);

		Command[] ca3 = { lcomm, wcomm, ucomm, scomm, bcomm, rbcomm, hcomm, ncomm, tcomm, ccomm }; // walk-> drive, talk->
		localcp = new ControlPanel(ca3);
		this.setCp(localcp);
	}

	@Override
	public void look() {
		if (!items.isEmpty()) {
			System.out.println("You are in security room, you can find the following objects:"); // Room descrption
			for (int i = 0; i < items.size(); i++) {
				System.out.println(items.get(i).description);
			}
		}
		System.out.println("You can only walk to the hallway");
	}

	@Override
	public void walk(String s) {

		if (this.isOpen()) {
			if ((s.contains(avaliablePos[0])) && (s.contains("walk"))) {
				System.out.println("you are standing in the hallway!");
				p.setPosition(1);
				p.notifyObservers();
				return;
			} else {
				System.out.println("There is no such place, please try another place");
			}
			p.setPosition(pos);
		} else {
			System.out.println("The room is closed, you need to open it first");
			p.setPosition(pos);

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
		System.out.println("Store <object name>: to store the portable objects in your bag");
		System.out.println("Statement that contains (look && bag): to view the contents of your bag");
		System.out.println("Statement that contains (remove <object name> && bag): to remove an object from the bag");
		System.out.println("I give up: to exit the game");		
	}
}
