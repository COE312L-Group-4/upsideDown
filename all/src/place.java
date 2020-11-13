package locations;

public abstract class place {
	
	String description;
	//array of characters
	//character [] c = null;
	//array of objects
	//object [] o = null;
    int pos;

    public place() {
    	description = " ";
    	pos = -1;
	}

	public place(String description, int pos) {
		this.description = description;
		this.pos = pos;
	}
	
	public abstract void look();
}
