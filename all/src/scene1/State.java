package scene1;

public interface State {
	public void prev(Player context);
	public void next(Player context);
	public String printStatus(Player context);
}
