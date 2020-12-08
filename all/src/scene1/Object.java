package scene1;
import scene2.*;


public abstract class Object implements ObjectBehaviour, ObserverSensor {

	public String name;
	String color;
	public String description;
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
	public void update(Message m) {

	}

}
