package scene2;

import scene1.*;
import java.util.*;

public class HaruSato extends Person {
	Scanner cin;

	public HaruSato() {
		super("haru sato", 35, 12, "Chef");
		cin = new Scanner(System.in);
	}

	@Override
	public void talk(Player player) {
		System.out.println(name + ": As you can see, I'm busy now ..(shouting) Order 20 is on the way!");
		System.out.println("Choose your reply:\n1-It's an urgent matter\n2-I know you killed the guy at the hotel");
		String reply = cin.nextLine();
		boolean fofo = true;
		while (fofo) {
			switch (reply) {
			case "1":
				System.out.println(player.name + ": It's an urgent matter");
				System.out.println(name + ": Not now");
				fofo = false;
				break;
			case "2":
				System.out.println(player.name + ": I know you killed the guy at the hotel");
				System.out.println(name
						+ ": I don't get what you are talking about. You need to leave now or I will kick you out myself");
				fofo = false;
				break;
			default:
				System.out.print("Please choose one of the options: ");
				reply = cin.nextLine();
			}
		}
		if (reply.contains("1")) {
			System.out.println(player.name + ": I know you killed the guy at the hotel");
			System.out.println(name
					+ ": I don't get what you are talking about. You need to leave now or I will kick you out myself");
		}
		System.out.println(player.name + ": let's see you trying");
		System.out.println(player.name + ": I need to fight him to get what I need. (Fight using objects in the kitchen, bag, or by hand)\nHint: type *help* to remember fight command ");
	}

}
