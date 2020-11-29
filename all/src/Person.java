
public abstract class Person {

	String name;
	int age;
	private int position;
	String job;

	public Person() {
		this.name = " ";
		this.age = 0;
		this.position = -1; // default value of empty location is -1
		this.job = " ";
	}

	public Person(String name, int age, int position, String job) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.job = job;
	}

	@Override
	public String toString() {
		return "Hey, I'm " + name + " " + age + " years old, I work as " + job + " I'm currently at position "
				+ position;
	}

	public synchronized int getPosition() {
		return position;
	}

	public synchronized void setPosition(int position) {
		this.position = position;
	}

}
