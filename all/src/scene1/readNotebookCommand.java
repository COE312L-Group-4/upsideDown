package scene1;
import java.io.IOException;

public class readNotebookCommand implements Command {
	Player p;
	
	public readNotebookCommand(Player p) {
		this.p = p;
	}

	@Override
	public void execute(String s) {
		try {
			p.nbook.read();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
