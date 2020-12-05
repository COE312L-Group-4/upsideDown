package scene1;
import scene2.*;


import java.io.IOException;

public class VictimID extends Object {

	public VictimID() {
		super();
	}

	public VictimID(String color) {
		super("victim id", color, "The Victim ID is on the floor beside the dead body", true);
	}

	@Override
	public void errorMessage() {

	}

	@Override
	public void use(Player p) {
		System.out.println("*************************************************");
		System.out.println("*\t----------IDENTITY CARD----------\t*");
		System.out.println("*\t  ID Number: 784-1973-84961579-0 \t*");
		System.out.println("*\t  Name: Kitai Sainosuke          \t*");
		System.out.println("*\t  Gender: Male                   \t*");
		System.out.println("*\t  Nationality: Japanese          \t*");
		System.out.println("*\t  Occupation: Lawyer 			*");
		System.out.println("*\t  Birthdate: 09.11.1973			*");
		System.out.println("*************************************************");

		p.setScore(p.getScore() + 5);
		p.setEvidence(p.getEvidence()+1);
		try {
			p.nbook.write("You found the ID card of the victim. His name is Sainosuke Kitai and he is a lawyer\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
