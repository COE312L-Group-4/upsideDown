import java.io.*;
import java.util.*;

public class Driver {

	public static void main(String[] args) throws Exception {
		// new TCP_Client("192.168.0.163", 56615); // N 192.168.1.133 // A 192.168.0.135

		// --Nouran--
		FileWriter fw = new FileWriter("notebook1.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		FileReader fr = new FileReader("notebook1.txt");

		PrintWriter writer = new PrintWriter("notebook1.txt");
		writer.print("");
		writer.close();

		// Places Initialization
		Place[] places = new Place[8];
		places[0] = new car();
		places[1] = new Hallway();
		places[2] = new Elevator();
		places[3] = new HouseKeepingRoom();
		places[4] = new LaundryRoom();
		places[5] = new PlayerRoom();
		places[6] = new SecurityRoom();
		places[7] = new VictimRoom();

		Notebook notebook = new Notebook(bw, fr);

		System.out.println("**Welcome to Upside Down!**\nEnter your name");
		Scanner cin = new Scanner(System.in);
		String name = cin.nextLine();

		System.out.println("ay 7agh kdh " + name);
		System.out.println("Type start to start");

		// Enter the Start Phrase
		String MP = cin.nextLine().toLowerCase();
		while (!MP.contains("start")) {
			System.out.println("The magic words you entered are not magical enough\nEnter the magic word CORRECTLY:");
			MP = cin.nextLine();
		}

		Player p = Player.getInstance(name, 40, 5, notebook);
		Time t = new Time(p);
		SecurityControl sc = new SecurityControl(t, p);

		// Commands intialization
		lookCommand lcomm = new lookCommand(places, p);
		walkCommand wcomm = new walkCommand(places, p);
		useCommand ucomm = new useCommand(places, p);
		storeCommand scomm = new storeCommand(places, p);
		bagCommand bcomm = new bagCommand(p);
		removeBagCommand rbcomm = new removeBagCommand(places, p);
		Command[] ca = { lcomm, wcomm, ucomm, scomm, bcomm, rbcomm };
		ControlPanel cp = new ControlPanel(ca);

		// Story descrpition
		System.out.println("Story!");

		while (!t.isTimeup()) {

			MP = cin.nextLine();
			MP = MP.toLowerCase();

			if (MP.contains("look") && MP.contains("around")) {
				cp.commandCalled(0, MP);
			} else if (MP.contains("walk")) {
				cp.commandCalled(1, MP);
			} else if (MP.contains("use")) {
				cp.commandCalled(2, MP);
			} else if (MP.contains("store")) {
				cp.commandCalled(3, MP);
			} else if (MP.contains("look") && MP.contains("bag")) {
				cp.commandCalled(4, MP);
			} else if (MP.contains("remove") && MP.contains("bag")) {
				cp.commandCalled(5, MP);
			} else if (MP.equals("mischief managed")) {
				System.out.println("Hiding map contents...end!");
				t.setTimeup(true);

			} else {
				if (!t.isTimeup()) {
					System.out.println("Invalid command \nplease enter a valid command");
				}
			}
		}
		System.out.println(".... THE END......\nThank you for playing UpsideDown");

		fw.flush();
		fw.close();

		fr.close();
		bw.close();

	}

}