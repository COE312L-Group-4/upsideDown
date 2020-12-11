package scene1;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import scene2.DinningHall;
import scene2.ITFriend;
import scene2.Kitchen;
import scene2.fightCommand;
import scene2.talkCommand;

public class UpsideDown implements Runnable {

	public UpsideDown() {
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {

		try {
			// ------------Sensor connection----------------------
			// N 192.168.1.133 // A 192.168.0.135

			// ------------------------Sound declerations--------------------------------
			Sound powerUp = new Sound("Power_Up_Ray-Mike_Koenig-800933783.wav");
			Sound alarm = new Sound("TIMER2.wav");
			Sound phoneRing = new Sound("Phone Ringing-SoundBible.com-1358131443-[AudioTrimmer.com].wav");
			Sound  panic = new Sound("Incoming_Suspense-Maximilien_-1060577487.wav");

			// ------------------File I/O notebook-----------
			FileWriter fw = new FileWriter("notebook.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			FileReader fr = new FileReader("notebook.txt");

			PrintWriter writer = new PrintWriter("notebook.txt");
			writer.write("");
			writer.close();

			// --File I/O : Phone notebook
			FileWriter fwp = new FileWriter("phonenotebook.txt", true);
			BufferedWriter bwp = new BufferedWriter(fwp);
			FileReader frp = new FileReader("phonenotebook.txt");

			PrintWriter writerp = new PrintWriter("phonenotebook.txt");
			writerp.write("");
			writerp.close();

			Notebook notebook = new Notebook(bw, fr);
			Notebook phonenotebook = new Notebook(bwp, frp);

			// ----------Welcome and Game introduction------------------
			System.out.println("\r\n" + 
					" __  __                          __              ____                                   \r\n" + 
					"/\\ \\/\\ \\                  __    /\\ \\            /\\  _`\\                                 \r\n" + 
					"\\ \\ \\ \\ \\  _____     ____/\\_\\   \\_\\ \\     __    \\ \\ \\/\\ \\    ___   __  __  __    ___    \r\n" + 
					" \\ \\ \\ \\ \\/\\ '__`\\  /',__\\/\\ \\  /'_` \\  /'__`\\   \\ \\ \\ \\ \\  / __`\\/\\ \\/\\ \\/\\ \\ /' _ `\\  \r\n" + 
					"  \\ \\ \\_\\ \\ \\ \\L\\ \\/\\__, `\\ \\ \\/\\ \\L\\ \\/\\  __/    \\ \\ \\_\\ \\/\\ \\L\\ \\ \\ \\_/ \\_/ \\/\\ \\/\\ \\ \r\n" + 
					"   \\ \\_____\\ \\ ,__/\\/\\____/\\ \\_\\ \\___,_\\ \\____\\    \\ \\____/\\ \\____/\\ \\___x___/'\\ \\_\\ \\_\\\r\n" + 
					"    \\/_____/\\ \\ \\/  \\/___/  \\/_/\\/__,_ /\\/____/     \\/___/  \\/___/  \\/__//__/   \\/_/\\/_/\r\n" + 
					"             \\ \\_\\                                                                      \r\n" + 
					"              \\/_/                                                                      \r\n" + 
					"");

			Scanner cin = new Scanner(System.in);
			System.out.println(
					"UpsideDown is a thriller and crime game.\nAs a player you will have to go around solving puzzels, and collecting evidence to win the game\nYou have health that you can increase by eating or drinking from the game enviroment\nYou have a bag that you can use to store up to 7 objects\nYou can always access the notebook to read a summary of the evidence collected\nYou can use the notepad feature in your phone that is placed in the bag to write personalized notes\nyou can type *help* to know the commands available at the current position to play the game\n\n----Good Luck trying to fix your life when it turns upside down----\n");
			System.out.println("Type your name to start..");
			String name = cin.nextLine();
			Player p = Player.getInstance(name, 40, 5, notebook, phonenotebook); // change back
			TCP_Client tcp = new TCP_Client("192.168.0.163", 58194, p);

			// Intailize extra room
			ITFriend it = ITFriend.getInstance(p,phoneRing);
			Place security = new SecurityRoom(p);
			Place kitchen = new Kitchen(p, tcp);

			// Places Initialization
			Place[] places = new Place[15];
			// -------Scene1----------
			places[0] = new car(p,powerUp);
			places[1] = new Hallway(tcp, security, p);
			places[2] = new Elevator(p);
			places[3] = new HouseKeepingRoom(powerUp, p);
			places[4] = new LaundryRoom(p);
			places[5] = new PlayerRoom(powerUp, p);
			places[6] = security;
			places[7] = new VictimRoom(p, tcp);
			places[8] = new Room301();
			places[9] = new Room302();
			places[10] = new Room303();
			// -------Scene2----------
			places[11] = new DinningHall(powerUp, kitchen, p);
			places[12] = kitchen;

			Time t = new Time(p,panic);
			Security s1 = new StaticSecurity(p, t);
			Security s2 = new MovingSecurity(p, t, places[4]);

			// Commands intialization
			ControlPanel mainPanel;

			// Story descrpition
			System.out.println("\nAs the famous detective " + name
					+ " you have spent your entire life chasing and catching the bad guys.\nIt is finally the time for you to take a break (or at least you think that)"
					+ "\nYou packed your luggage and went to Japan for a refereshing break..."
					+ "\n\n*After a 12 hours long flight*"
					+ "\nYou entered the hotel extremely exhausted from the flight, barely reached the bed and passed out"
					+ "\n\nTrnnn..Trnn"
					+ "\nThe sound of your alarm wakes you up from your deep sleep..\nYou are feeling energized and ready to leave the room and start exploring Tokyo, Japan's busiest capital\n");
			alarm.playSound();
			String MP;
			// p.setEvidence(4);
			while (!p.isLoss() && !p.isFinish()) {

				MP = cin.nextLine();
				MP = MP.toLowerCase();
				mainPanel = places[p.getPosition()].cp;

				if (MP.contains("look") && MP.contains("around")) {
					mainPanel.commandCalled(0, MP);
				} else if (MP.contains("walk") || MP.contains("drive")) {
					mainPanel.commandCalled(1, MP);
				} else if (MP.contains("use") || MP.contains("open") || MP.contains("pick") || MP.contains("press")|| MP.contains("jump")) {
					mainPanel.commandCalled(2, MP);
				} else if (MP.contains("store")) {
					mainPanel.commandCalled(3, MP);
				} else if (MP.contains("look") && MP.contains("bag")) {
					mainPanel.commandCalled(4, MP);
				} else if (MP.contains("remove") && MP.contains("bag")) {
					mainPanel.commandCalled(5, MP);
				} else if (MP.contains("help")) {
					mainPanel.commandCalled(6, MP);
				} else if (MP.contains("read") && MP.contains("notebook")) {
					mainPanel.commandCalled(7, MP);
				} else if (MP.contains("talk")) {
					mainPanel.commandCalled(8, MP);
				} else if (MP.contains("eat") || MP.contains("drink")) {
					mainPanel.commandCalled(9, MP);
				} else if (MP.contains("fight")) {
					mainPanel.commandCalled(10, MP);
				} else if (MP.equals("i give up")) {
					System.out.println("I was doubting you from the beginning...\n");
					t.setTimeup(true);

				} else {
					if (!p.isLoss() && !p.isFinish()) {
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
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
