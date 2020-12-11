package scene2;

import java.util.Scanner;
import scene1.*;


public class Waiter extends Person {
	Scanner cin;

	public Waiter() {
		super("waiter", 35, 11, "waiter");
		cin = new Scanner(System.in);

	}

	@Override
	public void talk(Player player) {
		System.out.println(name + ": Welcome to our resturant, how can I help you?");
		System.out.println("Choose your reply:\n1-How long have you been here\n2-I am looking for Haro Satu");
		String reply = cin.nextLine();
		System.out.println();
		boolean fofo = true;
		while (fofo) {
			switch (reply) {
			case "1":
				System.out.println(player.name + ": How long have you been here");
				System.out.println(name + ": Since day one.. I am the owner cousin");
				fofo = false;
				break;
			case "2":
				System.out.println(player.name + ": I am looking for Haro Satu");
				System.out.println(name + ": Haro Satu is busy right now.. you can come back later... or don't");
				fofo = false;
				break;
			default:
				System.out.print("Please choose one of the options: ");
				reply = cin.nextLine();
				System.out.println();
			}
		}
		if (reply.contains("1")) {
			System.out.println(player.name + ": I am looking for Haro Satu");
			System.out.println(name + ": Haro Satu is busy right now.. you can come back later... or don't");
		}
		System.out.println(player.name + ": I am a detective, I want to ask him some questions");
		System.out.println(name + ": oh sorry, I did not know .. you can find him in the kitchen");
		System.out.println(player.name + ": whatever...you barely have anyone here");
		player.setEvidence(player.getEvidence() + 1);
		player.setScore(player.getScore() + 10);
		try {
			player.nbook.write("waiter said Haru Sato is in the kitchen!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
