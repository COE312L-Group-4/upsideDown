package scene2;

import java.util.Scanner;

import scene1.*;
import scene3.*;

//This should be an observer for the time or the location of the player so he can talk
public class ITFriend extends Person implements Observer {

	private static ITFriend instance;
	Player player;
	Sound s;
	Scanner cin;

	private ITFriend(Player player, Sound s) {
		super("Oda", 30, 13, "IT Consultant");
		this.player = player;
		player.registerObserver(this);
		this.s = s;
		cin = new Scanner(System.in);

	}

	public static synchronized ITFriend getInstance(Player p, Sound s) {
		if (instance == null) {
			instance = new ITFriend(p, s);
		}
		return instance;
	}

	@Override
	public void talk(Player p) { // at his home
		System.out.println("i'm a nerd");

	}

	public void answerPhone() {
		System.out.println("Yamamoto Takashi: Hey " + player.name
				+ ", I have heared what happened, the whole department is looking for you.\n");
		boolean fofo = true;
		System.out.println("Choose your reply:\n1-I did not do it!\n2-I need your help\n3-What do you think?");
		String reply = cin.nextLine();
		String s = "";
		while (fofo) {
			switch (reply) {
			case "1":
				System.out.println(player.name + ": I did not do it");
				s = "I know";
				fofo = false;
				break;
			case "2":
				System.out.println(player.name + ": I need your help");
				s = "I'm here, don't worry";
				fofo = false;
				break;
			case "3":
				System.out.println(player.name + ": What do you think?");
				s = "It's really sad but I don't think you did it";
				fofo = false;
				break;
			default:
				System.out.print("Please choose one of the options: ");
				reply = cin.nextLine();
			}
		}
		fofo = true;
		System.out.println("Yamamoto Takashi: " + s + " how can I help you?");
		System.out.println(
				"Choose your reply:\n1-I need you to find a location of an unknown number\n2-I need you to lookup a person called Haru Sato\n3-The victim was contacting someone with the initials YT");
		reply = cin.nextLine();
		while (fofo) {
			switch (reply) {
			case "1":
				System.out.println(player.name + ": I need you to find a location of an unknown number");
				System.out.println("Yamamoto Takashi: on it..give me a sec");
				s = "The last location detected was the local happy sushi resturant at down town (25.3097° N, 55.4906° E)";
				fofo = false;
				break;
			case "2":
				System.out.println(player.name + ": I need you to lookup a person called Haru Sato");
				System.out.println("Yamamoto Takashi: on it..give me a sec");
				s = "Haru satu works as a chef at the local happy sushi resturant at downtown (25.3097° N, 55.4906° E)";
				fofo = false;
				break;
			case "3":
				System.out.println(player.name + ": The victim was contacting someone with the initials YT");
				s = "I would need something more than this ";
				fofo = false;
				break;
			default:
				System.out.print("Please choose one of the options: ");
				reply = cin.nextLine();
			}
		}
		fofo = true;
		System.out.println("Yamamoto Takashi: " + s);
		if (reply.contains("3")) {
			System.out.println(
					"Choose your reply:\n1-I need you to find a location of an unknown number\n2-I need you to lookup a person called Haru Sato");
			reply = cin.nextLine();
			while (fofo) {
				switch (reply) {
				case "1":
					System.out.println(player.name + ": I need you to find a location of an unknown number");
					s = "The last location detected was the local happy sushi resturant at down town (25.3097° N, 55.4906° E)";
					fofo = false;
					break;
				case "2":
					System.out.println(player.name + ": I need you to lookup a person called Haru Satu");
					s = "Haru satu works as a chef at the local happy sushi resturant at down town (25.3097° N, 55.4906° E)";
					fofo = false;
					break;
				default:
					System.out.print("Please choose one of the options: ");
					reply = cin.nextLine();
				}
			}
			fofo = true;
			System.out.println("Yamamoto Takashi: on it..give me a sec");
			System.out.println("Yamamoto Takashi: " + s);
		}
		System.out.println(player.name + ": Heading there right now.. thanks for your help");
		System.out.println("Yamamoto Takashi: Anything for you brother!");
	}

	@Override
	public void update(int p) {
		if (p == 0) {
			System.out.println(
					"You have a call from your friend who works in the IT department for the police (type 'answer' to recieve the call)");
			// s.playSound();
			String answer = cin.nextLine();
			while (!answer.toLowerCase().contains("answer")) {
				System.out.print("Type answer ");
				answer = cin.nextLine();
			}
			answerPhone();
			player.removeObsever(this);
		}

	}

}
