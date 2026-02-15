package PolymorphismMaze;

import java.util.Random;

public class Map {
	private boolean[][] walls;
    private boolean[][] treasures;
    private int size;
    private int totalTreasures;

    public Map(int size) {

        this.size = size;
        walls = new boolean[size][size];
        treasures = new boolean[size][size];

        Random rand = new Random();

        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){

                walls[x][y] = rand.nextInt(100) < 20;
                treasures[x][y] = rand.nextInt(100) < 15;

                if(treasures[x][y]) totalTreasures++;
            }
        }

        // start tile safe
        walls[0][0] = false;
        treasures[0][0] = false;
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
