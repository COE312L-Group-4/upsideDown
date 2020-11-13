package upsidedown;

public interface ObjectBehaviour {

	void checkLevel();
	//create a dynamic obj interface that has check level
	//for dynamic objects maybe we can use strategy design? change level dynamically
	void checkDescription();
	void use();
	void errorMessage();
	void collect();
	void store();
}
