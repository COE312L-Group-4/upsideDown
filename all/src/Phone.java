import java.util.Scanner;
import java.util.Date;
public class Phone extends Object {
	Scanner cin;

	public Phone(String color) {
		super("phone", color, "The Phone is placed on the desk next to you.", true);
		cin = new Scanner(System.in);
	}

	@Override
	public void errorMessage() {

	}

	@Override
	public void use(Player p) {
		System.out.println("Please pick one of the following: \n1-What time is it?\n2-Use the notepad");
		int s = cin.nextInt();
		Date date = new Date();
		boolean found = false;
		String note;
		try {
			while (!found) {
				switch (s) {
				case 1:
				    System.out.println(date.toString());
					found = true;
					break;
				case 2:
					System.out.println("Enter the note you want to input: ");
					note = cin.nextLine();
					p.nbook.write(note);
					found = true;
					break;
				default:
					System.out.println("Please enter a valid command");
				}
				s = cin.nextInt();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
