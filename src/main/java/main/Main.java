package main;

import entities.*;
import game.*;
import rooms.CombatRoom;
import rooms.Room;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player("Joe", 100, 10);
        GoblinEnemy goblin1 = new GoblinEnemy("Bob", 100, 10);
        GoblinEnemy goblin2 = new GoblinEnemy("Bob", 100, 10);

        CombatRoom room1 = new CombatRoom("Pokój Północny", "Wkraczasz do ciemnego pokoiku", new ArrayList<>(List.of(goblin1)));
        Room room2 = new CombatRoom("Pokój Wschodni", "Pokój z jasnym światłem.", new ArrayList<>(List.of(goblin2)));
        Room room3 = new Room("Pokój Zachodni", "Pokój wypełniony ciemnością.", new ArrayList<>());

        // Set exits
        room1.setExit("east", room2);
        room1.setExit("west", room3);
        room2.setExit("west", room1); // Return exit
        room3.setExit("east", room1); // Return exit

        player.setCurrentRoom(room1);


        Thread gameLoopThread = new Thread(new GameLoop(player));
        gameLoopThread.start();
    }
}