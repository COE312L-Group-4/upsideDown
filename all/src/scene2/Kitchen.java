package scene2;

import scene1.*;

public class Kitchen extends Place {
	String[] avaliablePos = { "dining hall" };
	ControlPanel localcp;

	public Kitchen(Player p, TCP_Client tcp) {
		super("You have entered the kitchen!", 12, false, p);
		characters.add(new HaruSato());

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
		fightCommand fcomm = new fightCommand(this, p, tcp);

		Command[] ca3 = { lcomm, wcomm, ucomm, scomm, bcomm, rbcomm, hcomm, ncomm, tcomm, ccomm, fcomm }; // walk-> drive, talk->
		localcp = new ControlPanel(ca3);
		this.setCp(localcp);
	}

	@Override
	public void look() {
		if (!items.isEmpty()) {
			System.out.println("You are in the Kitchen, you can see the follwoing:");
			for (int i = 0; i < items.size(); i++) {
				System.out.println(items.get(i).description);
			}
		}
		System.out.println("You can see a knife on the table and a Pan on the cooker");
		System.out.println("You can see the following characters that you can talk to: ");
		for (int i = 0; i < characters.size(); i++) {
			System.out.println(characters.get(i).name);
		}
		System.out.println("You can walk to the dining hall");
	}

	@Override
	public void walk(String s) {
		if (this.isOpen()) {
			if ((s.contains(avaliablePos[0])) && (s.contains("walk"))) {
				System.out.println("you are standing in the Dining Hal!");
				p.setPosition(11);
				return;

			} else {
				System.out.println("There is no such place, please try another one");
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
		System.out.println("statement that contains (fight && object name): to fight using different objects");
		System.out.println("read notebook: to open a summary of evidence collected");
		System.out.println("talk <character name>: to talk to a character");
		System.out.println("eat/drink <object name>: to consume food or drink for energy");
		System.out.println("Store <object name>: to store the portable objects in your bag");
		System.out.println("Statement that contains (look && bag): to view the contents of your bag");
		System.out.println("Statement that contains (remove <object name> && bag): to remove an object from the bag");
		System.out.println("I give up: to exit the game");
	}

}
