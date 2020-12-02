package scene1;

public abstract class Room301 extends Place{

	public Room301() {
		super("You entered room 301!.\n",8,false);
	}

	@Override
	public void look() {
	}

	@Override
	public int walk(String s) {
		System.out.println("This is Room 1");
		return 0;
	}




}
