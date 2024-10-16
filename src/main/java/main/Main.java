package main;

import entities.*;
import game.*;
import rooms.Room;
import rooms.DungeonGenerator;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player player = Player.getInstance("Joe", 100, 10);

        DungeonGenerator.generateDungeon(3, 3 , player);


        Thread gameLoopThread = new Thread(new GameLoop(player));
        gameLoopThread.start();
    }
}