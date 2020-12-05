package scene1;
import scene2.*;


public interface Subject {
	public void registerObserver(Person o);
	public void removeObsever(Person o);
	public void notifyObservers();
}
