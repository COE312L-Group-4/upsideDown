
public abstract class Object implements ObjectBehaviour, ObserverSensor {

	String name;
	String color;
	String description;
	boolean portable;

	public Object() {
		super();
		name = " ";
		color = " ";
		description = " ";
		portable = false;
	}

	public Object(String name, String color, String description, boolean portable) {
		super();
		this.name = name;
		this.color = color;
		this.description = description;
		this.portable = portable;

	}

	@Override
	public String toString() {
		return "Object [name=" + name + ", color=" + color + "]";
	}

	public abstract void use(Player p);

	public abstract void errorMessage();

	public void use(Player p, Place place) {

	}

	@Override
	public void update(double accx, double accy, double accz, double gyrx, double gyry, double gyrz) {

	}

}
