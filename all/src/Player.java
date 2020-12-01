import java.util.ArrayList;
import java.util.Observer;

// Use the Singleton pattern 
public class Player extends Person implements Subject {

	private ArrayList observers;
	private static Player instance;
	private int Score;
	private int evidence;
	private int Health; // this could be a state or something
	ArrayList<Object> bag;
	Notebook nbook;

	public synchronized int getScore() {
		return Score;
	}

	public synchronized int getHealth() {
		return Health;
	}

	public synchronized void setScore(int score) {
		Score = score;
	}

	public synchronized void showScore() {
		System.out.println("Your Score is " + Score);
	}

	public synchronized void setHealth(int health) {
		if (health > 100) {
			Health = 100;
		} else if (health < 0) {
			Health = 0;
		} else {
			Health = health;
		}
	}

	private Player(String name, int age, int position, Notebook nbook, Notebook phonenbook) {
		super(name, age, position, "Player");
		bag = new ArrayList<Object>();
		bag.add(new Phone("White", phonenbook));
		observers = new ArrayList();
		Score = 0;
		Health = 100;
		evidence = 0;
		this.nbook = nbook;
	}

	// can we use singleton with 2 constructors (Only used the non-default)
	public static synchronized Player getInstance(String name, int age, int position, Notebook nbook,
			Notebook phonenbook) {
		if (instance == null) {
			instance = new Player(name, age, position, nbook, phonenbook);
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
		if (i >= 0)
			observers.remove(i);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Security observer = (Security) observers.get(i);
			observer.update(this.getPosition());
		}
	}

	public boolean isBagFull() {
		if (bag.size() >= 7) {
			return true;
		}
		return false;
	}

	public void getBagContent() {
		if (!bag.isEmpty()) {
			System.out.println("Your bag contains are: ");
			for (int i = 0; i < bag.size(); i++) {
				System.out.println(bag.get(i).name);
			}
		} else {
			System.out.println("Your bag is empty");
		}
	}

	public int getEvidence() {
		return evidence;
	}

	public void setEvidence(int evidence) {
		this.evidence = evidence;
		if (this.evidence == 4) {
			this.bag.add(new CarKeys("silver"));
			System.out.println(
					"Congratulations! You have collected enough evidence to move on to the next stage\nYou can find the car keys in your bag, you can use them to open the car and go to your next destination.");
		}
	}
}
