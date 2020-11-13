package upsidedown;

public abstract class Object implements ObjectBehaviour{

	String name;
	boolean use; //a flag to indicated if used or not..maybe add an int level 
	String color;
	int level;
	
	public synchronized int getLevel() {
		return level;
	}
	public synchronized void setLevel(int level) {
		this.level = level;
	}
	public Object() {
		super();
		name=" ";
		use=false;
		color=" ";
		level=10;
	}
	public Object(String name, boolean use, String color) {
		super();
		this.name = name;
		this.use = use;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Object [name=" + name + ", use=" + use + ", color=" + color + "]";
	}
	public synchronized boolean isUse() {
		return use;
	}
	public synchronized void setUse(boolean use) {
		this.use = use;
	}
	
	
	
}
