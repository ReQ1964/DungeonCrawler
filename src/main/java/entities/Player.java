package entities;

import rooms.CombatRoom;
import rooms.Room;

public class Player implements LivingCreature {
    private final String name;
    private int health;
    private int attackDamage;
    private Room currentRoom;

    public Player(String name, int health, int attackDamage) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
    }

    @Override
    public void attack(LivingCreature target) {
        target.takeDamage(this.attackDamage);
    }

    @Override
    public void takeDamage(int damage){
        health -= damage;
    }

    @Override
    public boolean isAlive(){
        return health > 0;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getHealth(){
        return health;
    }


    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move(String direction) {
        Room newRoom = currentRoom.getExit(direction);
        if (newRoom != null) {
            currentRoom = newRoom;
            System.out.println("You moved to: " + currentRoom.getName());
            System.out.println("Description: " + currentRoom.getDescription());

            if (currentRoom instanceof CombatRoom) {
                ((CombatRoom) currentRoom).startBattle();
            }
        } else {
            System.out.println("You can't go that way!");
        }
    }
}
