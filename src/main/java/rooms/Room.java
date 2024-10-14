package rooms;

import entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private List<LivingCreature> enemies;
    private Map<String, Room> exits; // To hold neighboring rooms

    public Room(String name, String description, List<LivingCreature> enemies) {
        this.name = name;
        this.description = description;
        this.enemies = enemies;
        this.exits = new HashMap<>();
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<LivingCreature> getEnemies() {
        return enemies;
    }

    public Map<String, Room> getExits() {
        return exits;
    }
}
