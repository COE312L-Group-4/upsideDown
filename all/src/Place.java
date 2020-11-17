
public abstract class Place {
	
	String description;
	//array of characters
	//character [] c = null;
	//array of objects
	Object [] items;
    int pos;

    
    public Place() {
    	description = " ";
    	pos = -1;
    	items = null;
	}

	public Place(String description, int pos) {
		this.description = description;
		this.pos = pos;
		this.items = null;
	}
	
	public abstract void look();
}
