package scene1;

import scene2.*;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

public class SecurityCamera extends Object {
	Scanner s;

	public SecurityCamera() {
		super();
		s = new Scanner(System.in);
	}

	public SecurityCamera(String color) {
		super("computer", color,
				"There is a computer connected to security cameras you can access it if you are smart enough", false);
		s = new Scanner(System.in);
	}

	@Override
	public void use(Player p, String input) {
		if (input.contains("use") || input.contains("open")) {
			System.out.println(
					"The computer is password protected but there is a hint: 1 Jug 2 Birthdays 3 Fights 4 Cars 2 Laptops 1 Watch\n");
			System.out.print("Enter the Passowrd to access the computer: ");
			String pass = s.nextLine();
			boolean pafirst = true;
			boolean exit = false;
			while (!exit) {
				if (pass.toLowerCase().equals("jigsaw")) {
					if (pafirst) {
						try {
							p.setScore(p.getScore() + 10);
							p.setEvidence(p.getEvidence() + 1);

							pafirst = false;
							// ************Display the image***********
							MyCanvas m = new MyCanvas("video-evidence-901.jpeg");
							JFrame f = new JFrame();
							f.add(m);
							f.setSize(1920, 1080);
							f.setVisible(true);
							// ****************************************
							p.nbook.write(
									"Security camera footage shows:\nA guy with short black hair\nHe has a tatto on his right hand\nHe wears a Jacket with a logo");
						} catch (Exception e) {
							System.out.println(e);
						}
					}
					System.out.println("");
					break;
				} else if (pass.toLowerCase().equals("exit")) {
					exit = true;
				} else {
					System.out.println("Password is wrong! Please try again or exit");
					p.setScore(p.getScore() - 10);
				}
				pass = s.nextLine();
			}
		} else {
			System.out.println("You can't use this object with that command");
		}
	}
}
