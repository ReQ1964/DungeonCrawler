package entities;

import game.Battle;
import rooms.CombatRoom;
import rooms.Room;

import java.util.Scanner;

public class Player implements LivingCreature {
    private final String name; // Player's name
    private int health;        // Player's health
    private int attackDamage;  // Player's attack damage
    private Room currentRoom;  // The room the player is currently in

    public Player(String name, int health, int attackDamage) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void attack(LivingCreature target) {
        target.takeDamage(this.attackDamage);
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move(String direction) throws InterruptedException {
        Room newRoom = currentRoom.getExit(direction);
        Room prevRoom = currentRoom;
        if (newRoom != null) {
            currentRoom = newRoom;
            System.out.println("You moved to: " + currentRoom.getName());
            System.out.println("Description: " + currentRoom.getDescription());

            if (newRoom instanceof CombatRoom combatRoom) {
                if (!combatRoom.getEnemies().isEmpty()) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You have encountered enemies! Do you want to fight them? (yes/no)");
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("yes")) {
                        new Battle().startBattle(this, combatRoom);
                    }else {
                        currentRoom = prevRoom;
                        System.out.println("You have fled to: " + prevRoom.getName());
                    }
                }
            }
        } else {
            System.out.println("You can't go that way!");
        }
    }
}
