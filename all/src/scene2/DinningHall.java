package scene2;

import scene1.*;

public class DinningHall extends Place {
	String[] avaliablePos = { "Kitchen" };
	Place k;
	ControlPanel localcp;

	public DinningHall(Sound s, Place k, Player p) {
		super("Welcome to Happy Sushi resturant, you have entered the dining hall of the resturant.", 11, true, p);
		this.k = k;
		characters.add(new Cashier(k));
		characters.add(new Waiter());
		items.add(new Sushi("pink", s));

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
		System.out.println("You are in the Dining hall, you can see the follwoing:");
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).description);
		}
		System.out.println("You can see the following characters that you can talk to: ");
		for (int i = 0; i < characters.size(); i++) {
			System.out.println(characters.get(i).name);
		}
		System.out.println("You can only walk to the Kitchen");
	}

	@Override
	public void walk(String s) {
		if (s.contains("kitchen") && s.contains("walk")) {
			if (k.isOpen()) {
				System.out.println("you are standing in the kitchen!");
				p.setPosition(12);
				return;

			} else {
				System.out.println("I think I should gather some information first");
			}
		} else {
			System.out.println("There is no such place, please try another one");
		}
		p.setPosition(pos);
	}

	@Override
	public void help() {
		System.out.println("---The commands are as the follwoing---");
		System.out.println("help: to know all the commands available in the game");
		System.out.println("look around: to see the area you are in");
		System.out.println("walk <place name>: to navigate through the game");
		System.out.println("use <object name>  or open <object name>: to use or open different objects");
		System.out.println("read notebook: to open a summary of evidence collected");
		System.out.println("eat/drink <object name>: to consume food or drink for energy");
		System.out.println("talk <character name>: to talk to a character");
		System.out.println("Store <object name>: to store the portable objects in your bag");
		System.out.println("Statement that contains (look && bag): to view the contents of your bag");
		System.out.println("Statement that contains (remove <object name> && bag): to remove an object from the bag");
		System.out.println("I give up: to exit the game");		
	}

}
