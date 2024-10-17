package entities;

import actions.room.RoomAction;
import game.Inventory;
import game.DungeonGenerator;
import rooms.Room;
import actions.room.RoomActionFactory;

import java.util.LinkedHashMap;
import java.util.Random;

public class Player implements LivingCreature {
    private static Player instance; // Singleton instance
    private final String name;
    public Inventory inventory;
    private int health;
    private int attackDamage;
    private final double critChance = 0.5;
    public boolean isDmgCritical;
    private Room currentRoom;
    private Room previousRoom;

    private Player(String name, int health, int attackDamage) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.inventory = Inventory.getInstance();
    }

    public static Player getInstance(String name, int health, int attackDamage) {
        if (instance == null) {
            instance = new Player(name, health, attackDamage);
        }
        return instance;
    }

    public LinkedHashMap<String, String> getAllStatistics() {
        LinkedHashMap<String, String> stats = new LinkedHashMap<>();
        stats.put("Name", this.name);
        stats.put("Health", Integer.toString(this.getHealth()));
        stats.put("Attack Damage", Integer.toString(this.getAttackDamage()));
        stats.put("Critical Chance", Double.toString(this.critChance * 100) + "%");
        return stats;
    }

    public int getAttackDamage() {
        return attackDamage;
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
        Random rand = new Random();
        isDmgCritical = rand.nextDouble() <= critChance;
        int damage = attackDamage;

        if (isDmgCritical) {
            damage = (int) (damage * 1.5);
        }

        target.takeDamage(damage);
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
        previousRoom = currentRoom;
        this.currentRoom = room;
        DungeonGenerator.printDungeonMap(this);
        RoomAction action = RoomActionFactory.getAction(room);
        try {
            action.perform(this, room);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void move(String direction){
        Room newRoom = currentRoom.getExit(direction);

        if (newRoom != null) {
            setCurrentRoom(newRoom);
        } else {
            System.out.println("You can't go that way!\n");
        }
    }
}
