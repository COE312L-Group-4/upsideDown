package scene1;
import java.util.Scanner;
import java.util.Calendar;

public class VictimPhone extends Object {

	Scanner s;
	Calendar now;

	public VictimPhone() {
		super();
		s = new Scanner(System.in);
	}

	public VictimPhone(String color) {
		super("victim phone", color, "victim's phone is dropped at the ground", true);
		s = new Scanner(System.in);
	}

	@Override
	public void errorMessage() {
		// TODO Auto-generated method stub

	}

	public void callHistory() {
		now = Calendar.getInstance();
		now.add(Calendar.MINUTE, -20);

		System.out.println("----CALL HISTORY----");
		System.out.println("Incoming Call " + now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)
				+ " はる ハル 佐藤 Haru Sato --- Today ");
		now.add(Calendar.MINUTE, -50);
		System.out.println("Outgoing Call " + now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)
				+ " はる ハル 佐藤 Haru Sato --- Today ");
		System.out.println("Missed Call " + now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)
				+ " 奥さん wife --- Today ");
		now.add(Calendar.MINUTE, -55);
		System.out.println("Outgoing Call " + now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)
				+ " 息子 Son --- Yesterday\n");

	}

	public void viewMessage() {
		System.out.println("You have recieved 1 new message! (open y/n?)");
		Scanner cmd = new Scanner(System.in);
		String input = cmd.nextLine();
		now = Calendar.getInstance();
		now.add(Calendar.MINUTE, -20);
		if (input.toLowerCase().equals("y")) {
			System.out.println("---Message History---");
			System.out.println("From: Unknown\nI have what is needed to\nruin your life");
			System.out.println("\t\t\t\tFrom:You\n\t\t\t\tWho are you?");
			System.out.println("From: Unknown\nYou seem like you were having\na good time with ゆあ加藤 (Yua kato)");
			System.out.println("\t\t\t\tFrom:You\n\t\t\t\twhat do you want?");
			System.out.println("From: Unknown\njustice");
			System.out.println("\t\t\t\tFrom:You\n\t\t\t\tI am gonna need more than that!");
			System.out.println(
					"From: Unknown\nbring the evidence that proves\nthe defendant innocence in\ncase#58496 to light");
			System.out.println("\t\t\t\tFrom:You\n\t\t\t\tWhat makes you think that there is any..");
			System.out.println("From: Unknown\nwe both know what you did in\nthat case..She is innocent");
			System.out.println(
					"\t\t\t\tFrom:You\n\t\t\t\tI see what's going on now\n\t\t\t\tI know who you are and you are not getting away with it YT!");
			System.out.println("---Unread Messages---");
			System.out.println("From: Unknown\nThis was ur biggest yet final mistake, Salute");
			System.out.println("----------------------");
		}
	}

	@Override
	public void use(Player p) {
		System.out.println(
				"The phone is locked with a 3 digit password\nFortunately there is a hint:\nWhat 3 positive numbers give the same result when multiplied and added together? (in ascending order)");
		System.out.println("Enter the Passowrd to access the phone:");
		String pass = s.nextLine();
		int option = -1;
		boolean pafirst = true;
		boolean callfirst = true;
		boolean messagefirst = true;
		while (true) {
			if (pass.equals("123")) {
				if (pafirst) {
					p.setScore(p.getScore() + 10);
					pafirst = false;
				}
				break;
			} else {
				System.out.println("Password is wrong! Please try again or exit");
				p.setScore(p.getScore() - 10);
			}
			pass = s.nextLine();
		}
		while (option != 3) {
			System.out.println("Pick one of the follwoing options:\n1-View call history\n2-View messages\n3-exit");
			System.out.print("Your choice is:");
			option = s.nextInt();
			try {
				if (option == 1) {
					callHistory();
					if (callfirst) {
						p.setScore(p.getScore() + 5);
						p.setEvidence(p.getEvidence()+1);
						callfirst = false;
						p.nbook.write(
								"You found on the victim's phone call history with 3 people: Haru Sato, Wife, Son.\n");
					}
				} else if (option == 2) {
					if (messagefirst) {
						p.setScore(p.getScore() + 5);
						p.setEvidence(p.getEvidence()+1);
						messagefirst = false;
						p.nbook.write(
								"You found on the victim's phone a converstation with an unknown number that is threatining him.\n");
					}
					viewMessage();

				} else if (option == 3) {
					System.out.println("Phone closed!");
					break;
				} else {
					System.out.println("Invalid option please try again!");
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}
}
