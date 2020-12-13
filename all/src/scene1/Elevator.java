package scene1;

import scene2.*;

public class Elevator extends Place {
	String[] avaliablePos = { "hallway" };
	ControlPanel localcp;

	public Elevator(Player p) {
		super("You have entered the Elevator you can go back to the hallway or exit to your car.", 2, true, p);
		items.add(new Button("grey"));

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
		System.out.print(
				"You are in the elevator, you can use the exit button to exit the hotel and move to the next scene\nor you can go back to the hallway");
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
			System.out.println("This room is closed");
			p.setPosition(pos);
		}

	}

	@Override
	public void help() {
		System.out.println("---The commands are as the follwoing---");
		System.out.println("help: to know all the commands available in the game");
		System.out.println("look around: to see the area you are in");
		System.out.println("walk <place name>: to navigate through the game");
		System.out.println("Press <object name>: to push elevator buttons");
		System.out.println("read notebook: to open a summary of evidence collected");
		System.out.println("Statement that contains (look && bag): to view the contents of your bag");
		System.out.println("Statement that contains (remove <object name> && bag): to remove an object from the bag");
		System.out.println("I give up: to exit the game");		
	}

}
