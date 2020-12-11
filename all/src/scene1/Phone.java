package scene1;
import scene2.*;

import java.util.Scanner;
import java.util.Date;

public class Phone extends Object {
	Scanner cin;
	Notebook nb;
	

	public Phone(String color, Notebook nb) {
		super("phone", color, "your phone is in your bag", true);
		cin = new Scanner(System.in);
		this.nb = nb;
	}

	@Override
	public void use(Player p,String input) {
		if(input.contains("use")) {
		System.out.println(
				"Please pick one of the following: \n1-What time is it?\n2-Write to the phone notepad\n3-Read all notes\n4-exit");
		System.out.println();
		String s = cin.nextLine();
		Date date = new Date();
		boolean found = false;
		String note;
		try {
			while (!found) {
				switch (s) {
				case "1":
					System.out.println(date.toString());
					System.out.println();
					break;
				case "2":
					System.out.println("Enter the note you want to input: ");
					note = cin.nextLine();
					this.nb.write(note + "\n");
					System.out.println("Your input is entered");
					System.out.println();
					break;
				case "3":
					this.nb.read();
					System.out.println();
					break;
				case "4":
					found = true;
					System.out.println("Phone closed!!");
					System.out.println();
					break;
				default:
					System.out.println("Please enter a valid command");
					System.out.println();
				}

				if (!found) {
					System.out.println(
							"Please pick one of the following: \n1-What time is it?\n2-Write the notepad\n3-Read all notes\n4-exit");
					s = cin.nextLine();
					System.out.println();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		}else {
			System.out.println("You can't use this object with that command");
		}
	}


}
