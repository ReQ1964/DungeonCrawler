package entities;

import game.Battle;
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

        System.out.println("You are in: " + currentRoom.getName());
        System.out.println("Description: " + currentRoom.getDescription());
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move(String direction) throws InterruptedException {
        Room newRoom = currentRoom.getExit(direction);
        Room prevRoom = currentRoom;
        if (newRoom != null) {
            setCurrentRoom(newRoom);

                if (!currentRoom.getEnemies().isEmpty()) {
                    Scanner scanner = new Scanner(System.in);
                    boolean validInput = false;

                    while (!validInput) {
                        System.out.println("You have encountered enemies! Do you want to fight them? (yes/no)");
                        String input = scanner.nextLine();

                        if (input.equalsIgnoreCase("yes")) {
                            new Battle().startBattle(this, currentRoom);
                            validInput = true;
                        } else if (input.equalsIgnoreCase("no")) {
                            setCurrentRoom(prevRoom);
                            System.out.println("You have fled!");
                            validInput = true;
                        } else {
                            System.out.println("Invalid input! Please type 'yes' or 'no'.");
                        }
                    }
                }
        } else {
            System.out.println("You can't go that way!");
        }
    }

    public void printAllExits(Room currentRoom){
        System.out.print("You can still go in these directions: ");
        for (var entry : currentRoom.getAllExits().entrySet()) {
            System.out.print(entry.getKey()+ ", ");
        }
        System.out.println();
    }
}
