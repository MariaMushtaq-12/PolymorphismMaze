package PolymorphismMaze;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create map
        Map map = new Map(8); // 8x8 map

        // Create player starting at (0,0)
        Player player = new Player(0, 0);

        // Create guard at random location (not 0,0)
        int guardX = (int) (Math.random() * map.getSize());
        int guardY = (int) (Math.random() * map.getSize());

        if(guardX == 0 && guardY == 0) guardX = 1; // avoid start
        Guard guard = new Guard(guardX, guardY);

        // Store entities in a list (polymorphism)
        List<Entity> entities = new ArrayList<>();
        entities.add(player);
        entities.add(guard);

        boolean running = true;

        System.out.println("Game Start! Collect all treasures and avoid the guard!");
        System.out.println("W = Up, S = Down, A = Left, D = Right, Q = Quit");

        while(running) {

            System.out.println("\nPlayer position: (" + player.getX() + "," + player.getY() + ")");
            System.out.println("Guard position: (" + guard.getX() + "," + guard.getY() + ")");
            System.out.println("Treasures left: " + map.getRemainingTreasures());
            System.out.print("Move (W/A/S/D/Q): ");

            String input = sc.nextLine().toUpperCase();

            if(input.equals("Q")) {
                System.out.println("Game quit.");
                break;
            }

            char moveChar = input.isEmpty() ? ' ' : input.charAt(0);

            // Move player
            player.move(moveChar, map);

            // Move guard
            guard.move(' ', map); // ignore input

            // Check win condition
            if(map.getRemainingTreasures() == 0) {
                System.out.println("You collected all treasures! You won!");
                break;
            }

            // Check lose condition
            if(player.getX() == guard.getX() && player.getY() == guard.getY()) {
                System.out.println("Guard caught you! Game over!");
                break;
            }
        }

        sc.close();
        System.out.println("Game ended.");
    }
}
