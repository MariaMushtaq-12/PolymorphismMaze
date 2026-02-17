package PolymorphismMaze;

public class Player extends Entity {

    private int treasuresCollected = 0;

    public Player(int x, int y) {
        super(x, y);
    }

    public int getTreasuresCollected() {
        return treasuresCollected;
    }

    // Movement helper functions 
    public void moveUp() {
        y = y + 1;
    }

    public void moveDown() {
        y = y - 1;
    }

    public void moveLeft() {
        x = x - 1;
    }

    public void moveRight() {
        x = x + 1;
    }

    @Override
    public void move(char direction, Map map) {

        // Save old position (in case move invalid)
        int oldX = x;
        int oldY = y;

        if(direction == 'W') moveUp();
        else if(direction == 'S') moveDown();
        else if(direction == 'A') moveLeft();
        else if(direction == 'D') moveRight();
        else return;

        // Check boundaries
        if(!map.isInside(x, y)) {
            x = oldX;
            y = oldY;
            System.out.println("Out of bounds!");
            return;
        }

        // Check wall
        if(map.isWall(x, y)) {
            x = oldX;
            y = oldY;
            System.out.println("You hit a wall!");
            return;
        }

        // Check treasure
        if(map.hasTreasure(x, y)) {
            treasuresCollected++;
            map.removeTreasure(x, y);
            System.out.println("Treasure collected!");
        }
    }
}
