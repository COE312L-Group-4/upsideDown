package scene1;

import scene2.*;

public class LaundryRoom extends Place {
	String[] avaliablePos = { "hallway" };
	ControlPanel localcp;

	public LaundryRoom(Player p) {
		super("You entered the laundry room!.", 4, true, p);
		items.add(new Chair("Brown"));

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
		
		Command[] ca3 = { lcomm, wcomm, ucomm, scomm, bcomm, rbcomm, hcomm, ncomm, tcomm, conscomm}; // walk-> drive, talk->
		localcp = new ControlPanel(ca3);
		this.setCp(localcp);
	}

	@Override
	public void look() {
		if (!items.isEmpty()) {
			System.out.println("watch out from the wet floor, you can see the follwoing objects:");
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
			System.out.println("The laundry room is closed by the chair, you need to open it first");
			p.setPosition(pos);

		}
	}

	@Override
	public void useInPlace(String s) {
		if (!items.isEmpty() || p.bag.size() > 0) {
			for (int i = 0; i < items.size(); i++) {
				if (s.contains(items.get(i).name.toLowerCase())) {
					if (s.contains("chair")) {
						items.get(i).use(p, this);

					} else {
						items.get(i).use(p,s);

					}
					return;
				}
			}
			for (int i = 0; i < p.bag.size(); i++) {
				if (s.contains(p.bag.get(i).name.toLowerCase())) {
					p.bag.get(i).use(p,s);
					return;
				}
			}
			System.out.println("This item doesn't exist in this place");
		} else {
			System.out.println("No items exist in this place or you don't have items in the bag");
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