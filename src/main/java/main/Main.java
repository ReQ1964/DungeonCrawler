package main;

import entities.*;
import game.*;
import rooms.Room;
import rooms.RoomFactory;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player("Joe", 100, 10);

        Map<String, Room> rooms = RoomFactory.createRandomRooms(1, 2 , player);


        Thread gameLoopThread = new Thread(new GameLoop(player));
        gameLoopThread.start();
    }
}