package scene1;
import scene2.*;


public class Safe extends Object{

	public Safe() {
		super();
	}

	public Safe(String color) {
		super("safe", color, "There is an open safe", false);
	}


	@Override
	public void use(Player p,String s) {
		if(s.contains("use") || s.contains("open")) {
		System.out.println("There are a pile of papers with some cases folders that has different names:\nKyoko, Tamashini, Haru Sato, Yiugang ma");
		}
	}

}
