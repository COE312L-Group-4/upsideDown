package scene1;

public class helpCommand implements Command {

	public helpCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(String s) {
		System.out.println("---The commands are as the follwoing---");
		System.out.println("help: to know all the commands available in the game");
		System.out.println("look around: to see the area you are in");
		System.out.println("walk <place name>: to navigate through the game");
		System.out.println("use <object name>  or open <object name>: to use or open different objects");
		System.out.println("statement that contains (fight && object name): to fight using different objects");
		System.out.println("read notebook: to open a summary of evidence collected");
		System.out.println("talk <character name>: to talk to a character");
		System.out.println("Store <object name>: to store the portable objects in your bag");
		System.out.println("Statement that contains (look && bag): to view the contents of your bag");
		System.out.println("Statement that contains (remove <object name> && bag): to remove an object from the bag");
		System.out.println("I give up: to exit the game");
	}

}
