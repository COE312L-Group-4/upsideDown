package scene1;
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
	public void errorMessage() {

	}

	@Override
	public void use(Player p) {
		System.out.println(
				"Please pick one of the following: \n1-What time is it?\n2-Write to the phone notepad\n3-Read all notes\n4-exit");
		String s = cin.nextLine();
		Date date = new Date();
		boolean found = false;
		String note;
		try {
			while (!found) {
				switch (s) {
				case "1":
					System.out.println(date.toString());
					break;
				case "2":
					System.out.println("Enter the note you want to input: ");
					note = cin.nextLine();
					this.nb.write(note + " ");
					System.out.println("Your input is entered");
					break;
				case "3":
					this.nb.read();
					break;
				case "4":
					found = true;
					System.out.println("Phone closed!!");
					break;
				default:
					System.out.println("Please enter a valid command");
				}

				if (!found) {
					System.out.println(
							"Please pick one of the following: \n1-What time is it?\n2-Write the notepad\n3-Read all notes\n4-exit");
					s = cin.nextLine();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}


}
