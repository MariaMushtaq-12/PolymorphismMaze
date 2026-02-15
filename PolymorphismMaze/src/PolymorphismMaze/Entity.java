package PolymorphismMaze;

public abstract class Entity {
	
	/** Player X coordinate (column). */
	protected int x;

	/** Player Y coordinate (row). */
	protected int y;

	public Entity(int startX, int startY) {	
		this.x = startX;
		this.y = startY;
	}


	/** Return player's X coordinate. */
	public int getX() {
		return x;
	}
    
	/** Return player's Y coordinate. */
	public int getY() {
		return y;
	}

    // Every entity must implement its own movement
	public abstract void move(char direction, Map map);
	
}
