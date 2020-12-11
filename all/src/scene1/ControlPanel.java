package scene1;
import scene2.*;

public class ControlPanel {
	Command[] slots;
	
	public ControlPanel(Command[]slots) {
		this.slots=slots;
	}
	
	public void commandCalled(int index, String s)
	{
		if(index >= slots.length) {
			System.out.println("This is an invalid Command, you can't do this command here");
		}else {
			slots[index].execute(s);
		}
	}
}
