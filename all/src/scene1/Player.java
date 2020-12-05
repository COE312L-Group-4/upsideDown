package scene1;

import java.util.ArrayList;
import java.util.Observer;

// Use the Singleton pattern 
public class Player extends Person implements Subject {

	private ArrayList<Person> observers;
	private static Player instance;
	private int Score;
	private int evidence;
	private int Health; // this could be a state or something
	public ArrayList<Object> bag;
	public Notebook nbook;
	private boolean finish;

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
		if(finish) {
			System.out.println("Congratulations, You Won");
		}
	}

	public synchronized int getScore() {
		return Score;
	}

	public synchronized int getHealth() {
		return Health;
	}

	public synchronized void setScore(int score) {
		if (score < 0) {
			this.Score = 0;
		} else {
			this.Score = score;
		}
		System.out.println("Your score has been updated, your new score = " + Score);
	}

	public synchronized void setHealth(int health) {
		if (health > 100) {
			Health = 100;
		} else if (health == 100) {
			System.out.println("Your health is already full!");
		} else if (health < 0) {
			Health = 0;
		} else if (Health <= 15) {
			System.out.println("Your health is dropping low, Health = " + Health + "/100");
		} else {
			Health = health;
			System.out.println("Your health is now = " + health + " /100!");
		}

	}

	private Player(String name, int age, int position, Notebook nbook, Notebook phonenbook) {
		super(name, age, position, "Player");
		bag = new ArrayList<Object>();
		bag.add(new Phone("White", phonenbook));
		observers = new ArrayList<Person>();
		Score = 0;
		Health = 100;
		evidence = 0;
		this.nbook = nbook;
		this.finish = false;
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
	public void registerObserver(Person o) {
		observers.add(o);
	}

	@Override
	public void removeObsever(Person o) {
		int i = observers.indexOf(o);
		if (i >= 0)
			observers.remove(i);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Person observer = (Person) observers.get(i);
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
			System.out.println("Your bag contains: ");
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

	@Override
	public void talk(Player p) {
		System.out.println("I'm a player");

	}
}
