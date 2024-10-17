package game;

import entities.Player;

import java.util.HashMap;
import java.util.Scanner;

public class GameLoop implements Runnable {
    private boolean running = true;
    private Player player;

    public GameLoop(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        while (running) {
            try {
                checkGameOver();
                move();

                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Game loop interrupted.");
                throw new RuntimeException(e);
            }
        }
    }

    private void checkGameOver() {
        running = player.isAlive();

        if (!running) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }

    public void move() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type: (WASD) to move, (M) map, (I) inventory, (C) stats");
        String input = scanner.next();

        if (input.length() > 1) {
            System.out.println("Wrong command!");
            return;
        }

        char key = Character.toLowerCase(input.charAt(0));

        switch (key) {
            case 'w':
                player.move("north");
                break;
            case 's':
                player.move("south");
                break;
            case 'd':
                player.move("east");
                break;
            case 'a':
                player.move("west");
                break;
            case 'm':
                DungeonGenerator.printDungeonMap(player);
                break;
            case 'i':
                player.inventory.printAllItems();
                break;
            case 'c':
                HashMap<String, String> stats = player.getAllStatistics();
                System.out.println("\nPlayer Statistics:");
                for (var entry : stats.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                System.out.println();
                break;
            default:
                System.out.println("Invalid command! Please use (WASD), (M), (I), or (C).");
                break;
        }
    }
}
