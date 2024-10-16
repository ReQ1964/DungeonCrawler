package main;

import entities.*;
import game.*;
import game.DungeonGenerator;

public class Main {
    public static void main(String[] args) {
        Player player = Player.getInstance("Joe", 100, 10);

        DungeonGenerator dungeonGenerator = DungeonGenerator.getInstance();
        dungeonGenerator.generateDungeon(5, 5 , player);


        Thread gameLoopThread = new Thread(new GameLoop(player));
        gameLoopThread.start();
    }
}