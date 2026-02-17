package PolymorphismMaze;

import java.util.Random;

public class Guard extends Entity{

	 private Random rand = new Random();

	    public Guard(int x, int y) {
	        super(x, y);
	    }

	    @Override
	    public void move(char direction, Map map) {

	        // Guard ignores input direction and moves randomly every time 
	        int move = rand.nextInt(4);

	        int newX = x;
	        int newY = y;

	        if(move == 0) newY++;
	        else if(move == 1) newY--;
	        else if(move == 2) newX--;
	        else newX++;
	        
	        // Only move if tile is not wall
	        if(map.isInside(newX, newY) && !map.isWall(newX, newY)) {
	            x = newX;
	            y = newY;
	        }
	    }
}
