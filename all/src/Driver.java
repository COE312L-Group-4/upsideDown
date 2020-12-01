import java.io.*;
import java.util.*;
import javax.sound.sampled.*;

public class Driver {

	public static void main(String[] args) throws Exception {
		// new TCP_Client("192.168.0.163", 56615); // N 192.168.1.133 // A 192.168.0.135
		// -------------Nadeen-----------Sound--------------------------------
		Sound powerUp = new Sound("Power_Up_Ray-Mike_Koenig-800933783.wav");
		powerUp.playSound();
		// --Nouran--
		FileWriter fw = new FileWriter("notebook.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		FileReader fr = new FileReader("notebook.txt");
		
		PrintWriter writer = new PrintWriter("notebook.txt");
		writer.write("");
		writer.close();
		
		// --Ahmed--
		FileWriter fwp = new FileWriter("phonenotebook.txt", true);
		BufferedWriter bwp = new BufferedWriter(fwp);
		FileReader frp = new FileReader("phonenotebook.txt");
		
		PrintWriter writerp = new PrintWriter("phonenotebook.txt");
		writerp.write("");
		writerp.close();
		
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
		Notebook phonenotebook = new Notebook(bwp, frp);

		System.out.println("**Welcome to Upside Down!**\nEnter your name");
		Scanner cin = new Scanner(System.in);
		String name = cin.nextLine();

		System.out.println("Your name is: " + name);
		System.out.println("Type your name to start");

		// Enter the Start Phrase
		String MP = cin.nextLine().toLowerCase();
		while (!MP.contains(name.toLowerCase())) {
			System.out.println(
					"I doubt you will be able to finish this game if you don't know how to even type your name.\nHint: you just entered it few lines above");
			MP = cin.nextLine();
		}

		Player p = Player.getInstance(name, 40, 5, notebook ,phonenotebook);
		Time t = new Time(p);
		SecurityControl sc = new SecurityControl(t, p, places[4]);

		// Commands intialization
		lookCommand lcomm = new lookCommand(places, p);
		walkCommand wcomm = new walkCommand(places, p);
		useCommand ucomm = new useCommand(places, p);
		storeCommand scomm = new storeCommand(places, p);
		bagCommand bcomm = new bagCommand(p);
		removeBagCommand rbcomm = new removeBagCommand(places, p);
		helpCommand hcomm = new helpCommand();
		readNotebookCommand ncomm = new readNotebookCommand(p);
		Command[] ca = { lcomm, wcomm, ucomm, scomm, bcomm, rbcomm, hcomm, ncomm };
		ControlPanel cp = new ControlPanel(ca);

		// Things the player need to know before starting the game.
		System.out.println(
				"UpsideDown is a thriller and crime game.\nAs a player you will have to go around solving puzzels, and collecting evidence to win the game\nYou have health that you can increase by eating or drinking random stuff from the game enviroment\nYou have a bag that you can use to store up to 7 objects in, you can always access the notebook to read a summary of the evidence collected\nYou can use the notepad feature in your phone that is placed in the bag to write personalized notes\nyou can type *help* to know the commands needed to play the game\n");
		// Story descrpition
		System.out.println(
				"As a detective you have spent your entire life chasing and catching the bad guys and it is finally the time for you to take a break\nYou packed your luggage and went to Japan to stay away from everything and to catch your breath!\nYou entered the hotel, got into your room, and you just slept all night\nyou woke up and you are currently setting in your hotel room.");

		while (!t.isTimeup()) {

			MP = cin.nextLine();
			MP = MP.toLowerCase();

			if (MP.contains("look") && MP.contains("around")) {
				cp.commandCalled(0, MP);
			} else if (MP.contains("walk")) {
				cp.commandCalled(1, MP);
			} else if (MP.contains("use") || MP.contains("open")) {
				cp.commandCalled(2, MP);
			} else if (MP.contains("store")) {
				cp.commandCalled(3, MP);
			} else if (MP.contains("look") && MP.contains("bag")) {
				cp.commandCalled(4, MP);
			} else if (MP.contains("remove") && MP.contains("bag")) {
				cp.commandCalled(5, MP);
			} else if (MP.contains("help")) {
				cp.commandCalled(6, MP);
			}else if(MP.contains("read") && MP.contains("notebook")) {
				cp.commandCalled(7, MP);
			} 
			else if (MP.equals("i give up")) {
				System.out.println("I was doubting you from the beginning...\n");
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
		
		fwp.flush();
		fwp.close();
		
		frp.close();
		fwp.close();

	}

}
