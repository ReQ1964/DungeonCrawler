package game;

import entities.Player;

public class GameLoop {
    private boolean running = true;


    public void start(Player player){
        System.out.println("Welcome to the GAME!");
        while(running){
            checkGameOver(player);
        }
    }

    private void checkGameOver(Player player){
        running = player.isAlive();

        if(!running){
            System.out.println("Game Over!");
            System.exit(0);
        }
    }
}
