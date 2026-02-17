package PolymorphismMaze;

import java.util.Random;

public class Map {
	
	private boolean[][] walls; // 2D array storing wall positions 
    private boolean[][] treasures; // 2D array storing treasure positions
    private int size; // Size of map (size x size grid)
    private int totalTreasures;   // Total treasure count remaining in map

    public Map(int size) {

        this.size = size;

        walls = new boolean[size][size];
        treasures = new boolean[size][size];

        Random rand = new Random();

        // OPTIONAL: random walls only (not treasure)
        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                walls[x][y] = rand.nextBoolean(); // random walls
            }
        }

        // Start tile safe
        walls[0][0] = false;

        // ----------------------------
        // ⭐ Place ONLY ONE TREASURE
        // ----------------------------

        int tx;
        int ty;

        do {
            tx = rand.nextInt(size);
            ty = rand.nextInt(size);
        }
        while((tx == 0 && ty == 0) || walls[tx][ty]); 
        // Not start tile
        // Not inside wall

        treasures[tx][ty] = true;
        totalTreasures = 1;
    }

    public boolean isInside(int x, int y){
        return x>=0 && y>=0 && x<size && y<size;
    }

    public boolean isWall(int x, int y){
        return walls[x][y];
    }

    public boolean hasTreasure(int x, int y){
        return treasures[x][y];
    }

    public void removeTreasure(int x, int y){
        if(treasures[x][y]){
            treasures[x][y] = false;
            totalTreasures--;
        }
    }

    public int getRemainingTreasures(){
        return totalTreasures;
    }

    public int getSize(){
        return size;
    }
}
