package game;

import entities.Player;
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
        System.out.print("Enter a direction (north/east/south/west) to move or (map) for the map: ");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("map")){
            player.printAllExits(player.getCurrentRoom());
        }else{
            player.move(input);
        }
    }
}
