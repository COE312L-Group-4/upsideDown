package scene2;

import scene1.*;

public class DinningHall extends Place {
	String[] avaliablePos = { "Kitchen" };
	Place k;

	public DinningHall(Sound s, Place k) {
		super("Welcome to Happy Sushi resturant, you have entered the dining hall of the resturant.", 11, true);
		this.k = k;
		characters.add(new Cashier(k));
		characters.add(new Waiter());
		items.add(new Sushi("pink", s));
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
	public int walk(String s) {
		if (s.contains("kitchen") && s.contains("walk")) {
			if (k.isOpen()) {
				return 12;
			} else {
				System.out.println("I think I should gather some information first");
			}
		} else {
			System.out.println("There is no such place, please try another place");
		}
		return pos;
	}

}
