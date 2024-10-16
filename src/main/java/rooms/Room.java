package rooms;

import entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits;
    private int x;
    private int y;

    public Room(String name, String description, int x, int y) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.x = x;
        this.y = y;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
