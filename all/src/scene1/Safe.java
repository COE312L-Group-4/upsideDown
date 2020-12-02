package scene1;

public class Safe extends Object{

	public Safe() {
		super();
	}

	public Safe(String color) {
		super("safe", color, "There is an open safe", false);
	}


	@Override
	public void errorMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void use(Player p) {
		System.out.println("There are a pile of papers with some cases folders that has different names:\nKyoko, Tamashini, Haru Sato, Yiugang ma");
	}

}
