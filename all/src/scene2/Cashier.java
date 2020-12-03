package scene2;

import scene1.*;
import java.util.*;

public class Cashier extends Person {
	Scanner cin;
	Place k;

	public Cashier(Place k) {
		super("Keiji Suzuki", 55, 11, "Cashier");
		cin = new Scanner(System.in);
		this.k = k;
	}

	@Override
	public void talk(Player player) {
		System.out.println(name + ": Welcome to our resturant, how can I help you?");
		System.out.println("Choose your reply:\n1-what can I order\n2-I am looking for Haro Satu");
		String reply = cin.nextLine();
		boolean fofo = true;
		while (fofo) {
			switch (reply) {
			case "1":
				System.out.println(player.name + ": what can I order");
				System.out.println(name + ": umm... Sushi?");
				fofo = false;
				break;
			case "2":
				System.out.println(player.name + ": I am looking for Haro Satu");
				System.out.println(name + ": who is asking?");
				fofo = false;
				break;
			default:
				System.out.print("Please choose one of the options: ");
				reply = cin.nextLine();
			}
		}
		if (reply.contains("1")) {
			System.out.println(player.name + ": I am looking for Haro Satu");
			System.out.println(name + ": who is asking?");
		}
		System.out.println(player.name + ": I am a detective, I want to ask him some questions");
		System.out.println(name + ": He is the only chef here, you can find him in the kitchen, try making it quick!");
		System.out.println(player.name + ": whatever...you barely have anyone here");
		k.setOpen(true);
	}

}
