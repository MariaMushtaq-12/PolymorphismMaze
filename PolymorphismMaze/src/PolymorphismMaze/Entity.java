package PolymorphismMaze;

//abstract class for movement
public abstract class Entity {
	
    //	coordinates
	protected int x;
	protected int y;
	
	 // Constructor
	public Entity(int startX, int startY) {	
		this.x = startX;
		this.y = startY;
	}


	// Getter for X 
	public int getX() {
		return x;
	}
    
	// Getter for Y
	public int getY() {
		return y;
	}

    // Every entity must implement its own movement
	public abstract void move(char direction, Map map);
	
}
