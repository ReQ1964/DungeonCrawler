package main;

import entities.*;
import game.*;

public class Main {
    public static void main(String[] args) {
        GameLoop game = new GameLoop();
        Player player = new Player("Joe", 100, 10);

        game.start(player);
    }
}