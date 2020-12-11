package scene1;

import scene2.*;
//add the help function and the drive
public class car extends Place {

	String[] avaliablePos = { "resturant", "friend home" };
	ControlPanel localcp;

	public car(Player p,Sound s) {
		super("You have entered your car!\n", 0, true, p);
		items.add(new Gun("Black"));
		items.add(new EnergySnack("Brown",s));
		items.add(new Water("transparent",s));

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

		Command[] ca3 = { lcomm, wcomm, ucomm, scomm, bcomm, rbcomm, hcomm, ncomm, tcomm,conscomm }; // walk-> drive, talk->
		localcp = new ControlPanel(ca3);
		this.setCp(localcp);
	}

	@Override
	public void look() {
		System.out.println("You entered your car, you can see the follwoing objects:");
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).description);
		}
	}

	@Override
	public void walk(String s) {

		if (((s.contains("sushi")) || (s.contains("downtown")) || (s.contains("restaurant")))
				&& (s.contains("drive"))) {
			System.out.println("All this stress is tiring me");
			p.setHealth(p.getHealth() - 20);
			p.setPosition(11);
			System.out.println("Welcome to Happy Sushi resturant, you have entered the dining hall of the resturant");
			return;

		} else {
			System.out.println("There is no such place, please try another place");
		}

		 p.setPosition(pos);
	}

	@Override
	public void help() {
		System.out.println("----------------------Help Commands------------------------");
		System.out.println("help: to know all the commands available in the game");
		System.out.println("look around: to see the area you are in");
		System.out.println("drive <place name>: to navigate through the game");
		System.out.println("use <object name> : to use or open different objects");
		System.out.println("read notebook: to open a summary of evidence collected");
		System.out.println("answer <character name>: to talk to a character");
		System.out.println("Store <object name>: to store the portable objects in your bag");
		System.out.println("eat/drink <object name>: to consume food or drink for energy");
		System.out.println("Statement that contains (look && bag): to view the contents of your bag");
		System.out.println("Statement that contains (remove <object name> && bag): to remove an object from the bag");
		System.out.println("I give up: to exit the game");		
		System.out.println("-------------------------------------------------------");
	}
	
	

}
