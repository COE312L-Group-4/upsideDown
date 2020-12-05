package scene1;
import scene2.*;


import java.util.ArrayList;

public abstract class Place {

	public String description;
	protected ArrayList<Object> items;
	protected ArrayList<Person> characters;

	protected int pos;
	private boolean open;

	public Place() {
		description = " ";
		pos = -1;
		items = new ArrayList<Object>();
		characters = new ArrayList<Person>();
		open = false;
	}

	public Place(String description, int pos, boolean open) {
		this.description = description;
		this.pos = pos;
		this.items = new ArrayList<Object>();
		characters = new ArrayList<Person>();
		this.open = open;
	}

	public abstract void look();

	public abstract int walk(String s);

	public void useInPlace(String s, Player p) {
		if (!items.isEmpty() || p.bag.size() > 0) {
			for (int i = 0; i < items.size(); i++) {
				if (s.contains(items.get(i).name.toLowerCase())) {
					items.get(i).use(p);
					return;
				}
			}
			for (int i = 0; i < p.bag.size(); i++) {
				if (s.contains(p.bag.get(i).name.toLowerCase())) {
					p.bag.get(i).use(p);
					return;
				}
			}
			System.out.println("This item doesn't exist in this place");
		} else {
			System.out.println("No items exist in this place or you don't have items in the bag");
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void store(String s, Player p) {
		if (!items.isEmpty()) {
			if (!p.isBagFull()) {
				for (int i = 0; i < items.size(); i++) {
					if (s.contains(items.get(i).name.toLowerCase())) {
						if (items.get(i).portable) {
							items.get(i).description = "Stored in the players bag";
							p.bag.add(items.get(i));
							System.out.println("You have stored " + items.get(i).name + " in your bag!");
							items.remove(i);
							return;
						} else {
							System.out.println("This item is not portable, You can't Store it");
							return;
						}
					}
				}
				System.out.println("This item doesn't exist in this place");
				return;
			} else {
				System.out.println("You can't store as your bag is full");
				return;
			}
		} else {
			System.out.println("No items exist in this place");
			return;
		}
	}

	public void remove(String s, Player p) {
		if (!p.bag.isEmpty()) {
			for (int i = 0; i < p.bag.size(); i++) {
				if (s.contains(p.bag.get(i).name.toLowerCase())) {
					items.get(i).description = "stored in " + this.getClass().getTypeName();
					items.add(p.bag.get(i));
					System.out.println("You have removed " + p.bag.get(i).name + " !");
					p.bag.remove(i);
					return;
				}
			}
			System.out.println("This item doesn't exist in this place");
		} else {
			System.out.println("Your bag is empty!");
		}
	}

	public void talkInPlace(String s, Player p) {
		if (!characters.isEmpty()) {
			for (int i = 0; i < characters.size(); i++) {
				if (s.contains(characters.get(i).name.toLowerCase())) {
					characters.get(i).talk(p);
					return;
				}
			}
			System.out.println("This character doesn't exist in this place");
		} else {
			System.out.println("No character exist in this place");
		}
	}

	public synchronized boolean isOpen() {
		return open;
	}

	public synchronized void setOpen(boolean open) {
		this.open = open;
	}

}