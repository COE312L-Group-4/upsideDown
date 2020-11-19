
public abstract class Place {
	
	String description;
	//array of characters
	//character [] c = null;
	//array of objects
	Object [] items;
    int pos;
    boolean state; 
    
    public Place() {
    	description = " ";
    	pos = -1;
    	items = null;
    	state = false; 
	}

	public Place(String description, int pos, boolean state) {
		this.description = description;
		this.pos = pos;
		this.items = null;
		this.state = state;
	}
	
	public abstract void look();
}
