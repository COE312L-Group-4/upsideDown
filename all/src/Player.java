import java.util.ArrayList;
import java.util.Observer;

// Use the Singleton pattern 
public class Player extends Person implements Subject {

	private ArrayList observers;
	private static Player instance;
	int Score;
	int Health; // this could be a state or something
	Object[] bag;

	private Player(String name, int age, int position) {
		super(name, age, position, "Player");
		bag = new Object[5];
		observers = new ArrayList();
	}

	// can we use singleton with 2 constructors (Only used the non-default)
	public static synchronized Player getInstance(String name, int age, int position) {
		if (instance == null) {
			instance = new Player(name, age, position);
		}
		return instance;
	}

	@Override
	public void registerObserver(Security o) {
		observers.add(o);

	}

	@Override
	public void removeObsever(Security o) {
		int i = observers.indexOf(o);
		if (i>=0) observers.remove(i);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Security observer = (Security) observers.get(i);
			observer.update(this.getPosition());
		}
	}

}
