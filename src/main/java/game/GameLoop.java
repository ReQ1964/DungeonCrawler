package game;

import entities.Player;
import items.Item;

import java.util.Map;
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

    public void move() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a direction (north/east/south/west) to move, (map) for a map, (inventory) for inventory ");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("map")){
            DungeonGenerator.printDungeonMap(player);
        }else if(input.equalsIgnoreCase("inventory")){
            Map<String, Item> items = player.inventory.getAllItems();
            if(items != null){
                for(var item: items.entrySet()) {
                    System.out.println();
                    System.out.println(item.getValue().examine());
                }
                System.out.println();
            }

        }else{
                player.move(input);
            }
        }
    }
