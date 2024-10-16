package rooms;

import entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    List<LivingCreature> enemies;
    private Map<String, Room> exits;

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

    public Map<String, Room> getAllExits(){
        return exits;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
