
public class ControlPanel {
	Command[] slots;
	
	public ControlPanel(Command[]slots) {
		this.slots=slots;
	}
	
	public void commandCalled(int index, String s)
	{
		slots[index].execute(s);
	}
}
